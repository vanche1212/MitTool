package com.zrtg.mittoolcoreldap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;


@Service
public class DyLdapService extends LdapServiceFacade {



    @Autowired
    public DyLdapService(LdapTemplate dyLdapTemplate) {
        super(dyLdapTemplate);
    }

    @Override
    public void updatePasswordProcessor() {

    }


}
