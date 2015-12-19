package com.coldface.code.flow.processor;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;

import com.coldface.code.flow.invoker.Invoker;
import com.coldface.code.flow.invoker.impl.QueryInfoInvoker;
import com.coldface.code.flow.invoker.impl.WriteInfoInvoker;

/**
 * 类AbstractProcessor.java的实现描述：processor 的invoker定义及pipeline注入
 * 
 * @author coldface 2015年12月11日 下午1:42:40
 */
public abstract class AbstractProcessor<T> implements Processor<T>, InitializingBean {

    protected final List<Invoker<T>> pipeline = new ArrayList<Invoker<T>>();
    
    @Resource
    protected WriteInfoInvoker writeInfoInvoker;
    
    @Resource
    protected QueryInfoInvoker queryInfoInvoker;

    /*
     * (non-Javadoc) * @see
     * com.coldface.code.flow.processor.Processor#process(java.lang.Object)
     */
    public void process(T t) throws Exception {
        for (Invoker<T> invoker : pipeline) {
            invoker.invoke(t);
        }

    }

}
