package com.weibin.activiti.day02_进阶1;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * @author: webin
 * @date: 2019-12-06 21:36
 * @description:    需求：
 *                      1.从Activiti的act_ge_bytearray读取两个资源文件
 *                      2.将两个资源文件保存到路径， /Users/wangweibin/IdeaProjects/learn/Activiti7/activiti_01/data
 *                  方案：
 *                      1.使用activiti的api实现
 *                      2.可以使用jdbc对blob类型，clob类型数据的读取，并保存你
 *                      3.使用commons-io
 * @version: 0.0.1
 */
public class QueryBpmFile {

    public static void main(String[] args) throws IOException {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3.得到查询器，ProcessDefinitionQuery对象
        ProcessDefinitionQuery definitionQuery = repositoryService.createProcessDefinitionQuery();
        //4.设置查询条件
        ProcessDefinitionQuery processDefinitionQuery = definitionQuery.processDefinitionKey("holiday");
        //5.执行查询操作，查询出想要的流程定义
        ProcessDefinition processDefinition = processDefinitionQuery.singleResult();
        //6.通过流程定义信息得到部署ID
        String deploymentId = processDefinition.getDeploymentId();
        //7.通过repositoryService的方法，实现读取图片信息以及bpm文件信息
        InputStream resourceDiagramAsStream = repositoryService.getResourceAsStream(deploymentId, processDefinition.getDiagramResourceName());//1:部署id 2：资源名称
        InputStream resourceAsStream = repositoryService.getResourceAsStream(deploymentId, processDefinition.getResourceName());
        //8.构造出OutputStream流
        System.out.println(processDefinition.getDiagramResourceName());
        OutputStream pngOs = new FileOutputStream("/Users/wangweibin/IdeaProjects/learn/Activiti7/activiti_01/data/"+processDefinition.getDiagramResourceName());
        OutputStream bpmOs = new FileOutputStream("/Users/wangweibin/IdeaProjects/learn/Activiti7/activiti_01/data/"+processDefinition.getResourceName());
        //9输入流、输出流的转换
        IOUtils.copy(resourceDiagramAsStream,pngOs);
        IOUtils.copy(resourceAsStream,bpmOs);
        //10.关闭流
        resourceDiagramAsStream.close();
        resourceAsStream.close();
        pngOs.close();
        bpmOs.close();
    }
}
