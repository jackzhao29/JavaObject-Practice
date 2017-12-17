package com.coldface.code.akka.messagetype.kafka;

import java.io.Serializable;
import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * 类KafakTemplate.java的实现描述：kafka消息工具类
 * 
 * @author coldface
 * @date 2016年7月17日上午10:50:05
 */
public class KafkaTemplate {

  private Producer<String, Serializable> producer;
  private String topic = "app_events";

  public KafkaTemplate(String urls) {
    Properties props = new Properties();
    props.put("metadata.broker.list", urls);
    props.put("serializer.class", "com.coldface.code.akka.messagetype.kafka.ObjectEncoder");
    props.put("request.required.acks", "1");

    ProducerConfig config = new ProducerConfig(props);

    producer = new Producer<String, Serializable>(config);
  }

  public void convertAndSend(Object message) {
    assert message instanceof Serializable;
    KeyedMessage<String, Serializable> data =
        new KeyedMessage<String, Serializable>(topic, topic, (Serializable) message);
    producer.send(data);
  }
}
