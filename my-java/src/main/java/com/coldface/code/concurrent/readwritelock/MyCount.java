package com.coldface.code.concurrent.readwritelock;

/**
 * 信用卡账户，可随意透支
 * @author coldface
 *
 */
public class MyCount {

	private String oid; //账号
	private int cash; //账号余额
	
	MyCount(String oid,int cash){
		this.oid=oid;
		this.cash=cash;
	}
	
	
	
	public String getOid() {
		return oid;
	}



	public void setOid(String oid) {
		this.oid = oid;
	}



	public int getCash() {
		return cash;
	}



	public void setCash(int cash) {
		this.cash = cash;
	}



	@Override
	public String toString(){
		return "MyCount{"+
				"oid="+oid+
				",cash="+cash+
				"}";
	}
}
