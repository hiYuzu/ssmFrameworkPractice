package com.zxy.ssm.service;

import com.zxy.ssm.pojo.Sender;

import java.util.List;

/**
 *<p>
 *@Description: Sender操作服务类接口
 *</p>
 *@author hiYuzu
 *@date 2018/10/29 21:42
 */
 
public interface ISenderService {
	
	/**
	 *<p>
	 *@Description: 查询结果个数
	 *</p>
	 *@author hiYuzu
	 *@date 2018/10/29 21:42
	 *@return
	 */
	int getCount();
	 
	/**
	 *<p>
	 *@Description: 查询sender数据
	 *</p>
	 *@author hiYuzu
	 *@date 2018/10/29 21:42
	 *@return
	 */
	 List<Sender> getSenders();
}