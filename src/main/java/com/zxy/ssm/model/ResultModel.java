package com.zxy.ssm.model;

/**
 *<p>
 *@Description: 返回结果类
 *</p>
 *@author yuzu
 *@date 2018/9/29 16:03
 */
 
public class ResultModel {
	
	/**
	 * 是否成功的标志
	 */
	private boolean result = false;
	
	/**
	 * 详细信息
	 */
	private String detail = null;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}