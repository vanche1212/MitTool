package com.zrtg.mittoolcoreldap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

@Data
@Entry(objectClasses = {"Employee","top"}, base = "dc=zrtg,dc=com")
public class Employee {

	@Id
	@JsonIgnore
	private Name dn;

	private String EMID; // 员工主键
	private String CN;  // 登录名
	private String SN; // emid
	// ldap密码存储为二进制！！！
	@Attribute(name = "UserPassword", type = Attribute.Type.BINARY)
	private byte[] UserPassword;
	private String DEID; //部门ID
	private String CardSort;
	private String Email;
	private String EMEnable;
	private String EMIDCard; // 身份证
	private String EMName; // 员工姓名
	private String EMNo; // 员工排序
	private String InCardNo;
	private String MobilePhone; // 手机号
	private String PaperNo;
	private String Phone;
	private String SMS;
	private String SubDEID; // 子部门ID
	private String UID;
	private String VPN;
	private String WebPriority;
	private String ExpireDate;

}

