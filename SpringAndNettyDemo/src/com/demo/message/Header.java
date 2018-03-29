package com.demo.message;

public class Header {
	private byte tag;
	private byte encode;//编码
	private byte encrypt;//加密
	private byte extend1;//其它字段
	private byte extend2;//其他2
	private String sessionid;//会话id
	private int length;//包的长度
	private int cammand;//命令
	public Header() {
	}
	public Header(String sessionid) {
		this.encode=0;
		this.encrypt=0;
		this.sessionid=sessionid;
	}
	
	public Header(byte tag, byte encode, byte encrypt, byte extend1, byte extend2, String sessionid, int length,
			int cammand) {
		super();
		this.tag = tag;
		this.encode = encode;
		this.encrypt = encrypt;
		this.extend1 = extend1;
		this.extend2 = extend2;
		this.sessionid = sessionid;
		this.length = length;
		this.cammand = cammand;
	}
	public byte getTag() {
		return tag;
	}
	public void setTag(byte tag) {
		this.tag = tag;
	}
	public int getCammand() {
		return cammand;
	}
	public void setCammand(int cammand) {
		this.cammand = cammand;
	}
	public byte getEncode() {
		return encode;
	}
	public void setEncode(byte encode) {
		this.encode = encode;
	}
	public byte getEncrypt() {
		return encrypt;
	}
	public void setEncrypt(byte encrypt) {
		this.encrypt = encrypt;
	}
	public byte getExtend1() {
		return extend1;
	}
	public void setExtend1(byte extend1) {
		this.extend1 = extend1;
	}
	public byte getExtend2() {
		return extend2;
	}
	public void setExtend2(byte extend2) {
		this.extend2 = extend2;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	@Override
	public String toString() {
		return "Header [tag=" + tag + ", encode=" + encode + ", encrypt=" + encrypt + ", extend1=" + extend1
				+ ", extend2=" + extend2 + ", sessionid=" + sessionid + ", length=" + length + ", cammand=" + cammand
				+ "]";
	}

}
