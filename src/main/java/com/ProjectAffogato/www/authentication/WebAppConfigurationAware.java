package com.ProjectAffogato.www.authentication;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ProjectAffogato.www.Application;
import com.ProjectAffogato.www.config.JpaConfig;
import com.ProjectAffogato.www.config.SecurityConfig;
import com.ProjectAffogato.www.config.WebMvcConfig;

import javax.inject.Inject;



@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@WebAppConfiguration
@ContextConfiguration(classes = {Application.class, EmbeddedDataSourceConfig.class, JpaConfig.class, SecurityConfig.class, WebMvcConfig.class})
public abstract class WebAppConfigurationAware {

    @Inject
    protected WebApplicationContext wac;
    protected MockMvc mockMvc;

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Before
    public void before() {
        this.mockMvc = MockMvcBuilders.<DefaultMockMvcBuilder>webAppContextSetup(this.wac).build();
    }

}