package com.weibin.activiti.day01_基础;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * @author: webin
 * @date: 2019-12-04 21:00
 * @description:    流程定义流程部署 (创建一个工作流)
 * @version: 0.0.1
 */
public class ActivitiDeployment {

    //流程定义部署
    public static void main(String[] args) {
        //1.创建ProcessEngine工作流对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到RepositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3.进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday.bpmn")
                .addClasspathResource("diagram/holiday.png")
                .name("请假申请的流程")
                .deploy();
        //4.输出部署的一些信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());

    }


}
