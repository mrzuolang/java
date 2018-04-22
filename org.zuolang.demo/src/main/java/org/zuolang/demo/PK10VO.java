package org.zuolang.demo;

import java.sql.Date;

public class PK10VO {
	private String bill_code;
	private String plan_code;
	private String plan_content;
	private String num_one;
	private byte result;
	private Date open_time;
	private String nums;
	private int persen;

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

	public int getPersen() {
		return persen;
	}

	public void setPersen(int persen) {
		this.persen = persen;
	}

	@Override
	public String toString() {
		return "PK10VO [bill_code=" + bill_code + ", plan_code=" + plan_code + ", plan_content=" + plan_content
				+ ", num_one=" + num_one + ", result=" + result + ", open_time=" + open_time + ", nums=" + nums
				+ ", persen=" + persen + "]";
	}
}
