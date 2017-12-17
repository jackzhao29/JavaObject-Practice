package com.coldface.code.akka.messagetype.kafka;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * 类TestProducer.java的实现描述：TODO 类实现描述
 * 
 * @author coldface
 * @date 2016年7月17日下午12:10:07
 */
public class TestProducer {
  public static void main(String[] args) throws Exception {
    Properties prop = new Properties();
    prop.put("metadata.broker.list", "localhost:9092");
    prop.put("serializer.class", "kafka.serializer.StringEncoder");
    Producer<String, String> producer = new Producer<String, String>(new ProducerConfig(prop));
    int i = 0;
    
    while (true) {
      producer.send(new KeyedMessage<String, String>("test111", "msg:test"+ i++));
      Thread.sleep(1000);
      System.out.println("消息已发送");
    }
  }

}
