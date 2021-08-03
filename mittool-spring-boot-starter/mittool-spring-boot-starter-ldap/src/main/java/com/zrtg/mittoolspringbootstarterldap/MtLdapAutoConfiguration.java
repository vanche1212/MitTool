package com.zrtg.mittoolspringbootstarterldap;

import com.zrtg.mittoolcoreldap.service.DyLdapService;
import com.zrtg.mittoolcoreldap.service.LdapServiceFacade;
import com.zrtg.mittoolcoreldap.service.TestLdapService;
import com.zrtg.mittoolcoreldap.service.XsLdapService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;


/**
 * ldap配置类
 */
@Configuration
public class MtLdapAutoConfiguration {

    @Bean
    public LdapContextSource testLdapContextSource() {
        LdapContextSource source = new LdapContextSource();
        source.setBase("dc=zrtg,dc=com");
        source.setUrls(new String[]{"ldap://10.20.29.219:389"});
        source.setUserDn("cn=manager,dc=zrtg,dc=com");
        source.setPassword("Lddaap@1402");
        return source;
    }

    @Bean
    public LdapTemplate testLdapTemplate() {
        return new LdapTemplate(testLdapContextSource());
    }


    @Bean
    public LdapContextSource xsLdapContextSource() {
        LdapContextSource source = new LdapContextSource();
        source.setBase("dc=zrtg,dc=com");
        source.setUrls(new String[]{"ldap://10.20.50.19:389"});
        source.setUserDn("cn=yanfa2,dc=zrtg,dc=com");
        source.setPassword("4deqcbmTaKP4f@dJ");
        return source;
    }

    @Bean
    public LdapTemplate xsLdapTemplate() {
        return new LdapTemplate(xsLdapContextSource());
    }



    @Bean
    public LdapContextSource dyLdapContextSource() {
        LdapContextSource source = new LdapContextSource();
        source.setBase("dc=zrtg,dc=com");
        source.setUrls(new String[]{"ldap://172.16.1.193:389"});
        source.setUserDn("cn=Manager,dc=zrtg,dc=com");
        source.setPassword("5635@cztv.com");
        return source;
    }

    @Bean
    public LdapTemplate dyLdapTemplate() {
        return new LdapTemplate(dyLdapContextSource());
    }


    @Bean
    public LdapServiceFacade testLdapService() {
        return new TestLdapService(testLdapTemplate());
    }

    @Bean
    public LdapServiceFacade xsLdapService() {
        return new XsLdapService(xsLdapTemplate());
    }

    @Bean
    public LdapServiceFacade dyLdapService() {
        return new DyLdapService(dyLdapTemplate());
    }







}
