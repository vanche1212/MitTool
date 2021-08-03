package com.zrtg.mittoolcoreldap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

@Data
@Entry(objectClasses = {"department","top"}, base = "dc=zrtg,dc=com")
public class Department {
	@Id
	@JsonIgnore
	private Name dn;

	private String DEID; // 部门ID
	private String DELevel;
	private String DEOffice;
	private String DELeader;
	private String DEHavePro;
	private String DECanfile;
	private String GroupID; // 部门所属组
	private String DEJYK;
	private String DENo;
	private int DEEnable; // 是否启用
	private String DEUnit;
	private String DEName; // 部门名称
	private String Remark; // 备注


}
