package com.zrtg.mittoolcoreldap.service;

import com.zrtg.mittoolcommon.exception.BizException;
import com.zrtg.mittoolcoreldap.entity.Department;
import com.zrtg.mittoolcoreldap.entity.Employee;
import com.zrtg.mittoolcoreldap.entity.Group;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ldap.control.PagedResultsDirContextProcessor;
import org.springframework.ldap.core.AttributesMapperCallbackHandler;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.SearchExecutor;
import org.springframework.ldap.query.ContainerCriteria;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.ldap.support.LdapUtils;
import sun.misc.BASE64Encoder;

import javax.naming.Name;
import javax.naming.directory.SearchControls;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

/**
 * Ldap服务门面
 */
@Slf4j
public abstract class LdapServiceFacade {

    private final LdapTemplate ldapTemplate;

    public LdapServiceFacade(LdapTemplate ldapTemplate) {
        this.ldapTemplate = ldapTemplate;
    }

    public LdapTemplate getLdapTemplate() {
        return ldapTemplate;
    }

    /**
     * 添加员工
     */
    public void addEmployee(Employee employee) {
        try {
            Name dn = LdapNameBuilder.newInstance()
                    .add("ou", "employee")
                    .add("CN", employee.getCN())
                    .build();
            employee.setDn(employee.getDn() == null ? dn : employee.getDn());
            employee.setEMEnable(employee.getEMEnable() == null ? "1" : employee.getEMEnable());
            employee.setSN(employee.getSN() == null ? "50000000" : employee.getSN());
            employee.setEMNo(employee.getEMNo() == null ? "50000000" : employee.getEMNo());
            employee.setEMID(employee.getEMID() == null ? "50000000" : employee.getEMID());
            ldapTemplate.create(employee);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BizException("添加用户" + employee.getCN() + "失败");
        }
    }


    /**
     * 删除员工
     */
    public void deleteEmployee(String cn) {
        Employee employee = getOneEmployee(cn);
        ldapTemplate.unbind(employee.getDn());
    }

    /**
     * 获取指定员工信息
     */
    public Employee getOneEmployee(String username) {
        Employee employee = null;
        try {
            employee = ldapTemplate.findOne(query().where("CN").is(username), Employee.class);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return employee;
    }

    /**
     * 获取所有员工信息
     */
    public List<Employee> getAllEmployee() {
        return ldapTemplate.findAll(Employee.class);
    }

    /**
     * 根据部门获取所有员工
     */
    public List<Employee> getDepartmentEmployee(String deId) {
        return ldapTemplate.find(query().where("deid").is(deId), Employee.class);
    }



    /**
     * 获取指定组织
     */
    public Group getOneGroup(String groupId) {
        return ldapTemplate.findOne(query().where("GROUPID").is(groupId), Group.class);
    }

    /**
     * 获取所有组织
     */
    public List<Group> getAllGroup() {
        return ldapTemplate.findAll(Group.class);
    }


    /**
     * 添加部门
     */
    public void addDepartment(Department department) {
        try {
            Name dn = LdapNameBuilder.newInstance()
                    .add("ou", "department")
                    .add("DEID", department.getDEID())
                    .build();
            department.setDn(dn);
            department.setDELevel(department.getDELevel() == null ? "0" : department.getDELevel());
            department.setDEOffice(department.getDEOffice() == null ? "0" : department.getDEOffice());
            department.setDELeader(department.getDELeader() == null ? "0" : department.getDELeader());
            department.setDEHavePro(department.getDEHavePro() == null ? "0" : department.getDEHavePro());
            department.setDECanfile(department.getDECanfile() == null ? "0" : department.getDECanfile());
            department.setDEJYK(department.getDEJYK() == null ? "0" : department.getDEJYK());
            department.setDENo(department.getDENo() == null ? "0" : department.getDENo());
            ldapTemplate.create(department);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BizException("创建部门" + department.getDEID() + "失败");
        }
    }

    /**
     * 删除部门
     */
    public void deleteDepartment(String deid) {
        try {
            Name dn = LdapNameBuilder.newInstance()
                    .add("ou", "department")
                    .add("DEID", deid)
                    .build();
            ldapTemplate.unbind(dn);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BizException("删除部门失败");
        }
    }

    /**
     * 获取Ldap所有部门
     */
    public List<Department> getAllDepartment() {
        return ldapTemplate.findAll(Department.class);
    }

    /**
     * 获取Ldap指定部门
     */
    public Department getOneDepartment(String deid) {
        Department department = null;
        try {
            department = ldapTemplate.findOne(query().where("deid").is(deid), Department.class);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return department;
    }





    /**
     * 更改密码后置处理器
     */
    public abstract void updatePasswordProcessor();

    /**
     * 认证用户名密码
     */
    public boolean authenticate(String username, String password) {
        try {
            ContainerCriteria containerCriteria = query().where("CN").is(username);
            return ldapTemplate.authenticate(containerCriteria.base(), containerCriteria.filter().toString(), password);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取用户名的密码
     */
    public String getPassword(String username) {
        Employee employee = ldapTemplate.findOne(query().where("CN").is(username), Employee.class);
        return employee == null ? null : Arrays.toString(employee.getUserPassword());
    }

    /**
     * 更新用户密码
     */
    public void updatePassword(String username, String newPassword) {
        try {
            Employee employee = ldapTemplate.findOne(query().where("CN").is(username), Employee.class);
            if (employee == null) {
                throw new BizException("用户不存在");
            }
            // 密码加密
            MessageDigest md5 = MessageDigest.getInstance("SHA1");
            BASE64Encoder base64en = new BASE64Encoder();
            byte[] a = md5.digest(newPassword.getBytes(StandardCharsets.UTF_8));
            String shaPassword = "{SHA}" + base64en.encode(a);
            // 使用ODM映射操作ldap
            employee.setUserPassword(shaPassword.getBytes(StandardCharsets.UTF_8));
            ldapTemplate.update(employee);
            // 更新密码后置操作
            updatePasswordProcessor();
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizException("修改密码失败");
        }
    }



    /**
     * 分页查询用户
     * 暂未调试
     * https://www.lingjie.tech/article/2020-01-24/10
     */
    @Deprecated
    public List<Employee> queryAllPage() {
        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        controls.setReturningObjFlag(true);

        SearchExecutor executor = ctx -> ctx.search(LdapUtils.newLdapName("ou=employee"), "(&(objectClass=employee))", controls);
        PagedResultsDirContextProcessor requestControl;
        AttributesMapperCallbackHandler<Employee> callbackHandler = new AttributesMapperCallbackHandler<>(new LdapPersonAttributeMapper());

        requestControl = new PagedResultsDirContextProcessor(10);
        ldapTemplate.search(executor, callbackHandler, requestControl);
        return callbackHandler.getList();
    }


}

