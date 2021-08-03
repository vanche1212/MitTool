package com.zrtg.mittoolcoreldap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;


@Service
public class XsLdapService extends LdapServiceFacade {

    @Autowired
    public XsLdapService(LdapTemplate xsLdapTemplate) {
        super(xsLdapTemplate);
    }

    @Override
    public void updatePasswordProcessor() {

    }

}
