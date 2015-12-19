package com.coldface.code.flow.invoker.impl; 

import org.springframework.stereotype.Service;

import com.coldface.code.entity.StuEntity;
import com.coldface.code.flow.context.Context;
import com.coldface.code.flow.context.ContextKeyEnum;
import com.coldface.code.flow.invoker.Invoker;

/** 
 * 类WriteInfo.java的实现描述：写入信息
 * @author guanxin 2015年12月11日 下午2:04:01 
 */
@Service
public class WriteInfoInvoker extends Invoker<Context> {
    
    @Override
    protected void doInvoke(Context param){
        //从context中获取参数
        StuEntity stuEntity=(StuEntity)param.getContext(ContextKeyEnum.WRITE_STUENTITY_INFO);
        //todo,这里就暂时把信息输出
        System.out.println(stuEntity);
        
    }

}

