package com.zxy.ssm.model;

import java.util.ArrayList;
import java.util.List;

/**
 *<p>
 *@Description: 查询数据返回结果
 *</p>
 *@author yuzu
 *@date 2018/9/29 15:55
 */

public class ResultListModel<T> extends ResultModel {
	/**
	 * 返回结果条数
	 */
	private int total = 0;
	
	private String select = null;
	
	/**
	 * 返回结果详细信息
	 */
	private List<T> rows = new ArrayList<T>();

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}