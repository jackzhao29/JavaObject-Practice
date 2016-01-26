package com.coldface.code.flow.processor;

/**
 * 类Processor.java的实现描述：Processor接口
 * 
 * @author coldface 2015年12月11日 下午1:39:37
 */
public interface Processor<T> {

    /**
     * @param param
     */
    void process(T param) throws Exception;
}
