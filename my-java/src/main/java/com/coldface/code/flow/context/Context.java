package com.coldface.code.flow.context;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 类Context.java的实现描述：TODO 类实现描述
 * 
 * @author coldface 2015年12月11日 上午10:22:27
 */
public class Context implements Serializable {

	/** * */
	private static final long serialVersionUID = -8030607093690897109L;

	/** 
	 * 上下文之间的参数传递 
	 */
	protected Map<ContextKeyEnum, Object> contexts = new HashMap<ContextKeyEnum, Object>();

	public Context(ContextKeyEnum key, Object value) {
		super();
		contexts.put(key, value);
	}

	/**
     * 
     */
	public Context() {
		super();
	}

	/**
	 * @return the contexts
	 */
	public Map<ContextKeyEnum, Object> getContexts() {
		return contexts;
	}

	/**
	 * @param contexts
	 *            the contexts to set
	 */
	public void setContexts(Map<ContextKeyEnum, Object> contexts) {
		this.contexts = contexts;
	}

	public Object getContext(ContextKeyEnum key) {
		return contexts.get(key);
	}

	public void setContext(ContextKeyEnum key, Object value) {
		contexts.put(key, value);
	}

}
