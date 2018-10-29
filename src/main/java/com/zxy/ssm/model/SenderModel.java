package com.zxy.ssm.model;

/**
 * <p>
 *
 * @author hiYuzu
 * @Description: SenderModel
 * </p>
 * @date 2018/10/29 21:38
 */

public class SenderModel {
	private String senderId;
	private String senderName;
	private String senderTel;
	private String senderMsg;

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderTel() {
		return senderTel;
	}

	public void setSenderTel(String senderTel) {
		this.senderTel = senderTel;
	}

	public String getSenderMsg() {
		return senderMsg;
	}

	public void setSenderMsg(String senderMsg) {
		this.senderMsg = senderMsg;
	}
}