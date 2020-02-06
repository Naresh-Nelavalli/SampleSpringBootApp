package com.seva.user.model;

import java.math.BigDecimal;

public class PayChannelDetails {
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getPaidby() {
		return paidby;
	}
	public void setPaidby(String paidby) {
		this.paidby = paidby;
	}
	public String getPaidfor() {
		return paidfor;
	}
	public void setPaidfor(String paidfor) {
		this.paidfor = paidfor;
	}
	private String desc ;
	private String currency;
	private String source ;
	private String email ;
	private BigDecimal amount ;
	private String paidby;
	private String paidfor;

}
