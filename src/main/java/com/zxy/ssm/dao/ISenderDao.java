package com.zxy.ssm.dao;

import com.zxy.ssm.pojo.Sender;

import java.util.List;

/**
 *<p>
 *@Description: Sender数据库操作接口
 *</p>
 *@author hiYuzu
 *@date 2018/10/29 21:33
 */
public interface ISenderDao {
	
	/**
	 *<p>
	 *@Description: 查询结果个数
	 *</p>
	 *@author hiYuzu
	 *@date 2018/10/29 21:33
	 *@return
	 */
	int getCount();
	
	/**
	 *<p>
	 *@Description: 查询Sender数据
	 *</p>
	 *@author hiYuzu
	 *@date 2018/10/29 21:33
	 *@return
	 */
	List<Sender> getSender();
}