package com.zrtg.mittoolcoreldap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

@Data
@Entry(objectClasses = {"group","top"}, base = "dc=zrtg,dc=com")
public class Group {
	@Id
	@JsonIgnore
	private Name dn;

	private String GROUPID;
	private String OU;
	private String GROUPNAME;


}
