package com.shaw.cn.pojo;

import java.io.Serializable;

public class AjaxResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -534737076511980177L;

	/**
	 * 成功状态码
	 */
	public static final int STATUS_SUCCESS = 200;
	
	/**
	 * 错误状态码
	 */
	public static final int STATUS_ERROR = 300;
	
	/**
	 * 超时状态码
	 */
	public static final int STATUS_TIMEOUT = 301;
		
	/**
	 * 操作成功
	 */
	public static final AjaxResult SUCCESS = new AjaxResult(STATUS_SUCCESS,"操作成功");
	/**
	 * 操作失败
	 */
	public static final AjaxResult ERROR = new AjaxResult(STATUS_ERROR,"操作失败");
	/**
	 * 操作超时
	 */
	public static final AjaxResult TIMEOUT = new AjaxResult(STATUS_TIMEOUT,"操作超时");
	
    /**
     * 状态码
     */
	private int statusCode;
	
    /**
     * 数据
     */
	private Object data;
	
    /**
     * 消息
     */
	private String message;
	
    /**
     * 获取状态码
     * @return
     */
	public int getStatus() {
		return statusCode;
	}
	
    /**
     * 设置状态码
     * @return
     */
	public void setStatus(int statusCode) {
		this.statusCode = statusCode;
	}

    /**
     * 获取数据对象
     * @return
     */
	public Object getData() {
		return data;
	}
	
    /**
     * 数据对象
     * @return
     */
	public void setData(Object data) {
		this.data = data;
	}

    /**
     * 获取消息
     * @return
     */
	public String getMessage() {
		return message;
	}

    /**
     * 设置消息
     * @return
     */
	public void setMessage(String message) {
		this.message = message;
	}
	
    /**
     * 构造器
     */
	public AjaxResult() {
	}
	
	/**
	 * 构造器
	 * @param statusCode 状态码
	 * @param message 响应消息
	 */
	public AjaxResult(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
	
	
    /**
     * 构造器
     * @param statusCode 状态码
     * @param data 响应数据对象
     * @param message 响应消息
     */
	public AjaxResult(int statusCode, Object data, String message) {
		this.statusCode = statusCode;
		this.data = data;
		this.message = message;
	}
	
}
