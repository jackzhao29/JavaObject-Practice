package com.coldface.code.akka.messagetype.kafka;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import kafka.serializer.Decoder;
import kafka.utils.VerifiableProperties;

/**
 * 类ObjectDecoder.java的实现描述：TODO 类实现描述
 * 
 * @author coldface
 * @date 2016年7月17日上午11:11:33
 */
public class ObjectDecoder implements Decoder<Serializable> {

  public ObjectDecoder() {}

  public ObjectDecoder(VerifiableProperties props) {}

  public Serializable fromBytes(byte[] bytes) {

    if (bytes == null) {
      return null;
    }
    try {
      ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
      return (Serializable) ois.readObject();
    } catch (IOException ex) {
      throw new IllegalArgumentException("Failed to deserialize object", ex);
    } catch (ClassNotFoundException ex) {
      throw new IllegalStateException("Failed to deserialize object type", ex);
    }
  }
}
