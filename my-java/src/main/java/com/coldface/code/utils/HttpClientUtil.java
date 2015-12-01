package com.coldface.code.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coldface.code.entity.DataResult;

/**
 * http工具类
 * Created by coldface
 */
public class HttpClientUtil {
	 private static final Logger log= LoggerFactory.getLogger(HttpClientUtil.class);
    /**
     * 默认超时时间
     */
    public static final int     DEFAULT_TIMEOUT        = 3;// 3秒
    /**
     * 默认编码
     */
    public static final String  DEFAULT_ENCODE         = "utf-8";

    /**
     * post方法
     * @param url
     * @param hashMap
     * @return
     */
    public static DataResult<String> post(String url, Map<String, Object> map) {
        return post(url, map, DEFAULT_TIMEOUT);
    }

    /**
     * post方法
     * @param url
     * @param hashMap
     * @param timeoutSecond 超时，秒数
     * @return
     */
    public static DataResult<String> post(String url, Map<String, Object> map, int timeoutSecond) {
        return post(url, map, timeoutSecond, DEFAULT_ENCODE);
    }

    /**post方法
     * @param url
     * @param hashMap
     * @param encode
     * @return
     */
    public static DataResult<String> executeMethod(String url, Map<String, Object> map, String encode) {
        return post(url, map, DEFAULT_TIMEOUT, encode);
    }

    /**
     * post方法
     * @param url
     * @param timeoutSecond
     * @param encode
     * @return
     */
    public static DataResult<String> post(String url, Map<String, Object> maps, int timeoutSecond, String encode) {
        PostMethod postMethod = new PostMethod(url);
        postMethod = parsePostData(postMethod, maps);

        return executeMethod(postMethod, timeoutSecond, encode);
    }

    /**
     * get方法
     * @param url
     * @return
     */
    public static DataResult<String> get(String url) {
        return get(url, DEFAULT_TIMEOUT);
    }

    /**
     * get方法
     * @param url
     * @param timeoutSecond，秒数
     * @return
     */
    public static DataResult<String> get(String url, int timeoutSecond) {
        return get(url, timeoutSecond, DEFAULT_ENCODE);
    }

    /**
     * get方法
     * @param url
     * @param encode
     * @return
     */
    public static DataResult<String> get(String url, String encode) {
        return get(url, DEFAULT_TIMEOUT, encode);
    }

    /**
     *  get方法
     * @param url
     * @param timeoutSecond
     * @param encode
     * @return
     */
    public static DataResult<String> get(String url, int timeoutSecond, String encode) {
        GetMethod getMethod = new GetMethod(url);
        return executeMethod(getMethod, timeoutSecond, encode);
    }

    /**
     * 通用的方法
     * @param httpMethod
     * @return
     */
    public static DataResult<String> executeMethod(HttpMethod httpMethod) {
        return executeMethod(httpMethod, DEFAULT_TIMEOUT);
    }

    /**
     * 通用的方法
     * @param httpMethod
     * @param timeoutSecond
     * @return
     */
    public static DataResult<String> executeMethod(HttpMethod httpMethod, int timeoutSecond) {
        return executeMethod(httpMethod, timeoutSecond, DEFAULT_ENCODE);
    }

    /**
     * 通用的方法
     * @param httpMethod
     * @param encode
     * @return
     */
    public static DataResult<String> executeMethod(HttpMethod httpMethod, String encode) {
        return executeMethod(httpMethod, DEFAULT_TIMEOUT, encode);
    }

    /**
     * 通用的方法
     * @param httpMethod
     * @param timeoutSecond
     * @param encode
     * @return
     */
    public static DataResult<String> executeMethod(HttpMethod httpMethod, int timeoutSecond, String encode) {
        HttpClient httpClient = new HttpClient();
        // 链接超时
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(timeoutSecond * 1000);
        // 读取超时
        httpClient.getHttpConnectionManager().getParams().setSoTimeout(timeoutSecond * 1000);
        httpMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + encode);
        int statusCode = 0;
        try {
            statusCode = httpClient.executeMethod(httpMethod);
        } catch (Exception e) {
            log.error("http链接异常:", e);
        }

        DataResult<String> result = new DataResult<String>();
        if (statusCode == HttpStatus.SC_OK) {
            result.setSuccess("true");
        } else {
        	result.setSuccess("false");
            result.setErrorCode(String.valueOf(statusCode));
        }

        String resultStr = null;
        try {
            resultStr = httpMethod.getResponseBodyAsString();
        } catch (Exception e) {
            log.error("http获取内容异常:", e);
        }
        httpClient.getHttpConnectionManager().closeIdleConnections(0);
        httpMethod.releaseConnection();
        result.setData(resultStr);
        return result;
    }

    /**
     * 组装post方法
     * @param postMethod
     * @param param
     * @return
     */
    private static PostMethod parsePostData(PostMethod postMethod, Map<String, Object> param) {
        Set<Entry<String, Object>> entries = param.entrySet();
        Iterator<Entry<String, Object>> iter = entries.iterator();

        while (iter.hasNext()) {
            Entry<String, Object> entry = iter.next();

            postMethod.addParameter(entry.getKey(), String.valueOf(entry.getValue()));

        }
        return postMethod;
    }
    

}
