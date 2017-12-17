package com.coldface.code.akka.messagetype.kafka;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import kafka.serializer.Encoder;
import kafka.utils.VerifiableProperties;

/**
 * 类ObjectEncoder.java的实现描述：TODO 类实现描述
 * 
 * @author coldface
 * @date 2016年7月17日上午11:12:43
 */
public class ObjectEncoder implements Encoder<Serializable> {

  public ObjectEncoder() {}

  public ObjectEncoder(VerifiableProperties props) {

  }

  public byte[] toBytes(Serializable object) {
    if (object == null) {
      return null;
    }
    ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
    try {
      ObjectOutputStream oos = new ObjectOutputStream(baos);
      oos.writeObject(object);
      oos.flush();
    } catch (IOException ex) {
      throw new IllegalArgumentException("Failed to serialize object of type: " + object.getClass(),
          ex);
    }
    return baos.toByteArray();
  }
}
