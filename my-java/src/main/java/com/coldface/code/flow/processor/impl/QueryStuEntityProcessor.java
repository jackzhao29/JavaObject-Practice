package com.coldface.code.flow.processor.impl;

import org.springframework.stereotype.Service;

import com.coldface.code.flow.context.Context;
import com.coldface.code.flow.processor.AbstractProcessor;

/**
 * 类QueryStuEntityProcessor.java的实现描述：TODO 类实现描述
 * 
 * @author coldface 2015年12月11日 下午2:14:20
 */
@Service("queryStuEntityProcessor")
public class QueryStuEntityProcessor extends AbstractProcessor<Context> {

    public void afterPropertiesSet() {
        //写入学生信息
        pipeline.add(writeInfoInvoker);
        //查询学生信息
        pipeline.add(queryInfoInvoker);
    }
}
