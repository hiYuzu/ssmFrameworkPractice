package com.zxy.ssm.pojo;

/**
 * <p>
 *
 * @author hiYuzu
 * @Description: SenderPojo
 * </p>
 * @date 2018/10/29 21:40
 */

public class Sender {
	private int senderId;
	private String senderName;
	private String senderTel;
	private String senderMsg;

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
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