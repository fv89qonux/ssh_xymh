package com.my.xymh.entity;

import java.io.Serializable;

/**
 * 关于我们
 * @author 
 *
 */
public class Config implements Serializable{
	private Integer id;
	private String name;//名称
	private String web;//网址
	private String address;//地址
	private String email;//邮编
	private String tel;//电话
	private String beian;//备案
	private String introduce;//介绍
	
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getWeb()
	{
		return web;
	}
	public void setWeb(String web)
	{
		this.web = web;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}
	public String getBeian()
	{
		return beian;
	}
	public void setBeian(String beian)
	{
		this.beian = beian;
	}
	public String getIntroduce()
	{
		return introduce;
	}
	public void setIntroduce(String introduce)
	{
		this.introduce = introduce;
	}
	

}
