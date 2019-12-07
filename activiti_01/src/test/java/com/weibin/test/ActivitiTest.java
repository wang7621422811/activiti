package com.weibin.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

/**
 * @author: webin
 * @date: 2019-12-03 22:39
 * @description:    测试类：
 *                      测试activiti所需要的25张表的生成
 * @version: 0.0.1
 */
public class ActivitiTest {

    @Test
    public void testGenTable1() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    }

    @Test
    public void testGenTable2() {
        //1.创建ProcessEngineConfiguration对象
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        //2.创建ProcessEngine对象
        ProcessEngine processEngine = configuration.buildProcessEngine();
        //3.输出processEngine对象
        //System.out.println(processEngine);
        String name = processEngine.getName();
        System.out.println(name);
    }
}
