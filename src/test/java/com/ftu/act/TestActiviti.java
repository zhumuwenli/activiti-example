package com.ftu.act;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

public class TestActiviti {

    
    /**
     * 创建表
     */
    @Test
    public void createTable() {
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        //h2
//        processEngineConfiguration.setJdbcDriver("org.h2.Driver");
//        processEngineConfiguration.setJdbcUrl("jdbc:h2:c:/tmp/test");
//        processEngineConfiguration.setJdbcUsername("sa");
        //mysql
        processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
        processEngineConfiguration.setJdbcUrl("jdbc:mysql://localhost:3306/act?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        processEngineConfiguration.setJdbcUsername("root");
        processEngineConfiguration.setJdbcPassword("123456");
        
//        processEngineConfiguration.setDatabaseSchema("");
        processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        
        ProcessEngine engine = processEngineConfiguration.buildProcessEngine();
        System.out.println(engine);
        
        
        
    }
    
    /**
     * 创建表
     */
    @Test
    public void createTable2() {
        ProcessEngineConfiguration processEngineConfiguration = 
                ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti-custom-context.xml");
        
        ProcessEngine engine = processEngineConfiguration.buildProcessEngine();
        System.out.println(engine);
        
        engine.getRepositoryService();
        engine.getRuntimeService();
        engine.getTaskService();
        
        engine.getHistoryService();
        engine.getIdentityService();
        engine.getFormService();
        
        engine.getManagementService();
        
        
        
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    }
}
