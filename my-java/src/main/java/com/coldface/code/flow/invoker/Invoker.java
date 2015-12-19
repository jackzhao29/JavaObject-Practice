package com.coldface.code.flow.invoker; 
/** 
 * 类Invoker.java的实现描述:invoker类 
 * @author guanxin 2015年12月11日 上午10:29:32 
 */
 public abstract class Invoker<T> {
	 
	 /**
	     * 处理实际业务
	     * 
	     * @param context
	     */
	    protected abstract void doInvoke(T param);

	    /**
	     * 是否跳过
	     * 
	     * @param context
	     * @return
	     */
	    protected boolean skip(T param) {
	        return false;
	    }

	    public void invoke(T param) {
	        if (!skip(param)) {
	            doInvoke(param);
	        }

	    }

}

