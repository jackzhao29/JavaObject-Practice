package com.coldface.code.flow.invoker.impl;

import org.springframework.stereotype.Service;

import com.coldface.code.entity.StuEntity;
import com.coldface.code.flow.context.Context;
import com.coldface.code.flow.context.ContextKeyEnum;
import com.coldface.code.flow.invoker.Invoker;

/**
 * 类QueryInfoInvoker.java的实现描述：TODO 类实现描述
 * 
 * @author coldface 2015年12月11日 下午2:22:37
 */
@Service
public class QueryInfoInvoker extends Invoker<Context> {
    @Override
    protected void doInvoke(Context param) {
        //从context中获取参数
        StuEntity stuEntity = (StuEntity) param.getContext(ContextKeyEnum.WRITE_STUENTITY_INFO);
        //todo处理信息
        //把处理结果保存到context中
        param.setContext(ContextKeyEnum.STUENTITY_INFO_RESULT, stuEntity);

    }
}
