package com.weibin.activiti.day02_进阶1;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * @author: webin
 * @date: 2019-12-06 22:33
 * @description:        启动流程实例，添加businessKey
 *                      本质：act_ru_execution中的businessKey要存入业务标识
 * @version: 0.0.1
 */
public class BusinessKeyAdd {

    public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到RuntimeService对象
        RuntimeService runtimeService = defaultProcessEngine.getRuntimeService();
        //3.启动流程实例，同时还要指定业务标识 businessKey  本身就是请假单的ID
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday", "1001");//1:指流程定义key 2：业务标识BusinessKey
        //4.输出ProcessInstance相关属性
        System.out.println(processInstance.getBusinessKey());
    }
}
