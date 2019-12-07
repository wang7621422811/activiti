package com.weibin.activiti.day01_基础;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

/**
 * @author: webin
 * @date: 2019-12-04 22:19
 * @description:    使用zip的方式
 * @version: 0.0.1
 */
public class ActivitiDeploymentZipTask {

    //查询当前用户的任务并且处理数据
    public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到TaskService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3.转化出ZipInputStream六对象
        InputStream resourceAsStream = ActivitiDeploymentZipTask.class.getClassLoader().getResourceAsStream("diagram/holidayBPMN.zip");
        //将inputStream流转化为zip
        ZipInputStream zipInputStream = new ZipInputStream(resourceAsStream);
        //3.查询当前用户的任务
        Deployment deployment = repositoryService.createDeployment()
                .addZipInputStream(zipInputStream)
                .name("请假申请流程单")
                .deploy();

        //4.输出部署的一些信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());
    }
}
