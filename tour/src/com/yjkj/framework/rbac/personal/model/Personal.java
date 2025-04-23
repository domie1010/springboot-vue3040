package com.yjkj.framework.rbac.personal.model;

import com.yjkj.framework.base.basemodel.BaseModel;


public class Personal extends BaseModel{
	
	private String hobby;
	private String status;
	private String like_address;
	private String remark;
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLike_address() {
		return like_address;
	}
	public void setLike_address(String like_address) {
		this.like_address = like_address;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
