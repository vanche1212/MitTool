package com.zrtg.mittoolcoreldap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;


@Service
public class TestLdapService extends LdapServiceFacade {



    @Autowired
    public TestLdapService(LdapTemplate testLdapTemplate) {
        super(testLdapTemplate);
    }

    @Override
    public void updatePasswordProcessor() {

    }


}
