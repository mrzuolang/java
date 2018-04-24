package org.blog.jobs.pk10;

import java.sql.Date;

public class PK10VO {
	/**
	 * 期数
	 */
	private String bill_code;
	/**
	 * 计划号 xxx~xyy
	 */
	private String plan_code;
	/**
	 * 预测开奖内容
	 */
	private String plan_content;
	/**
	 * 开奖第一名
	 */
	private String num_one;
	/**
	 * 结果是否中
	 */
	private byte result;
	/**
	 * 
	 */
	private Date open_time;
	//开奖排名
	private String nums;
	
	private String n1;
	private String n2;
	private String n3;
	private String n4;
	private String n5;
	private String n6;
	private String n7;
	private String n8;
	private String n9;
	private String n10;



	public PK10VO() {
		super();
	}

	public String getBill_code() {
		return bill_code;
	}

	public void setBill_code(String bill_code) {
		this.bill_code = bill_code;
	}

	public String getPlan_code() {
		return plan_code;
	}

	public void setPlan_code(String plan_code) {
		this.plan_code = plan_code;
	}

	public String getPlan_content() {
		return plan_content;
	}

	public void setPlan_content(String plan_content) {
		this.plan_content = plan_content;
	}

	public String getNum_one() {
		return num_one;
	}

	public void setNum_one(String num_one) {
		this.num_one = num_one;
	}

	public byte getResult() {
		return result;
	}

	public void setResult(byte result) {
		this.result = result;
	}

	public Date getOpen_time() {
		return open_time;
	}

	public void setOpen_time(Date open_time) {
		this.open_time = open_time;
	}

	public String getNums() {
		return nums;
	}

	public void setNums(String nums) {
		this.nums = nums;
	}

	public String getN1() {
		return n1;
	}

	public void setN1(String n1) {
		this.n1 = n1;
	}

	public String getN2() {
		return n2;
	}

	public void setN2(String n2) {
		this.n2 = n2;
	}

	public String getN3() {
		return n3;
	}

	public void setN3(String n3) {
		this.n3 = n3;
	}

	public String getN4() {
		return n4;
	}

	public void setN4(String n4) {
		this.n4 = n4;
	}

	public String getN5() {
		return n5;
	}

	public void setN5(String n5) {
		this.n5 = n5;
	}

	public String getN6() {
		return n6;
	}

	public void setN6(String n6) {
		this.n6 = n6;
	}

	public String getN7() {
		return n7;
	}

	public void setN7(String n7) {
		this.n7 = n7;
	}

	public String getN8() {
		return n8;
	}

	public void setN8(String n8) {
		this.n8 = n8;
	}

	public String getN9() {
		return n9;
	}

	public void setN9(String n9) {
		this.n9 = n9;
	}

	public String getN10() {
		return n10;
	}

	public void setN10(String n10) {
		this.n10 = n10;
	}

	@Override
	public String toString() {
		return "PK10VO [bill_code=" + bill_code + ", plan_code=" + plan_code + ", plan_content=" + plan_content + ", num_one=" + num_one + ", result=" + result + ", open_time="
				+ open_time + ", nums=" + nums + ", n1=" + n1 + ", n2=" + n2 + ", n3=" + n3 + ", n4=" + n4 + ", n5=" + n5 + ", n6=" + n6 + ", n7=" + n7 + ", n8=" + n8 + ", n9="
				+ n9 + ", n10=" + n10 + "]";
	}

}
