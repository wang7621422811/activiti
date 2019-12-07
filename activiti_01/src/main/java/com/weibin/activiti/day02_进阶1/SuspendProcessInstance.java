package com.weibin.activiti.day02_进阶1;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;

/**
 * @author: webin
 * @date: 2019-12-07 21:56
 * @description:    实全部流程实例挂起与激活
 * @version: 0.0.1
 */
public class SuspendProcessInstance {

    public static void main(String[] args) {
        //1.得到ProcessEngine实例
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到RepositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3.查询流程定义对象
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("holiday").singleResult();
        //4.得到当前流程定义的实例是否都为暂停状态
        boolean suspended = processDefinition.isSuspended();
        //5.判断
        String processDefinitionId = processDefinition.getId();
        if (suspended) {
            //暂停状态，可以进行激活操作
            repositoryService.activateProcessDefinitionById(processDefinitionId,true,null);
            System.out.println("实例：" + processDefinitionId + "激活");
        } else {
            repositoryService.suspendProcessDefinitionById(processDefinitionId,true,null);
            System.out.println("实例：" + processDefinitionId + "挂起");
        }
    }



}
