package com.zrtg.mittoolcoreldap.service;

import com.zrtg.mittoolcoreldap.entity.Employee;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.support.LdapNameBuilder;

import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;

/**
 * ldap用户实体映射（使用ldap的odm时不需要使用映射，其他情况需要使用映射）
 */
public class LdapPersonAttributeMapper implements AttributesMapper<Employee> {
    @Override
    public Employee mapFromAttributes(Attributes attributes) throws NamingException {
        Employee employee = new Employee();
        Name dn = LdapNameBuilder.newInstance()
                .add("ou", "employee")
                .add("CN", attributes.get("cn").get().toString())
                .build();
        employee.setDn(dn);
        employee.setCN(attributes.get("cn").get().toString());
        employee.setEMName(attributes.get("emname").get().toString());
        employee.setSN(attributes.get("sn").get().toString());
        return employee;
//        return Employee.builder()
//                .dn(LdapUtils.newLdapName(attributes.get("cn").get().toString()))
//                .CN(attributes.get("cn").get().toString())
//                .build();
    }
}
