package com.coldface.code.flow.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.coldface.code.entity.StuEntity;
import com.coldface.code.flow.context.Context;
import com.coldface.code.flow.context.ContextKeyEnum;
import com.coldface.code.flow.processor.impl.QueryStuEntityProcessor;
import com.coldface.code.flow.service.QueryStuEntityService;

/**
 * 类QueryStuEntityServiceImpl.java的实现描述：TODO 类实现描述
 * 
 * @author coldface 2015年12月11日 下午2:48:59
 */
@Service("queryStuEntityService")
public class QueryStuEntityServiceImpl implements QueryStuEntityService {

    @Resource
    private QueryStuEntityProcessor queryStuEntityProcessor;

    public StuEntity getStuEntity(StuEntity param) {
        StuEntity result = null;
        Context context = new Context(ContextKeyEnum.WRITE_STUENTITY_INFO, param);
        try {
            queryStuEntityProcessor.process(context);
            result = (StuEntity) context.getContext(ContextKeyEnum.STUENTITY_INFO_RESULT);
        } catch (Exception e) {
            // TODO Auto-generated catch block log.error("error message", e);
        }
        return result;
    }

}
