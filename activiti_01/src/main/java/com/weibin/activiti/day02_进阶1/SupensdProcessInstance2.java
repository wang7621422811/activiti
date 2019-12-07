package com.weibin.activiti.day02_进阶1;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * @author: webin
 * @date: 2019-12-07 22:26
 * @description:
 * @version: 0.0.1
 */
public class SupensdProcessInstance2 {

    public static void main(String[] args) {
        //1.得到ProcessEngine实例
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到runtimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //3.查询流程实例对象
        ProcessInstance processDefinition = runtimeService.createProcessInstanceQuery()
                .processInstanceId("2501").singleResult();
        //4.得到当前流程定义的实例是否都为暂停状态
        boolean suspended = processDefinition.isSuspended();
        String processInstanceId = processDefinition.getProcessInstanceId();
        //5.判断
        if (suspended) {
            runtimeService.activateProcessInstanceById(processInstanceId);
            System.out.println("流程定义：" + processInstanceId + "激活");
        }else {
            runtimeService.suspendProcessInstanceById(processInstanceId);
            System.out.println("流程定义：" + processInstanceId + "挂起");
        }
    }
}
