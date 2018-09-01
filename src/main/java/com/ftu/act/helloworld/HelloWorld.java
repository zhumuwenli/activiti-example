package com.ftu.act.helloworld;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;

public class HelloWorld {
    
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    
    /**
     * 部署流程定义
     */
    @Test
    public void deploymentProcessDefinition() {
        // 流程定义和部署相关的service
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .name("Hello-World-入门")
            .addClasspathResource("diagrams/helloworld.bpmn")
            .addClasspathResource("diagrams/helloworld.png")
            .deploy();
        
        System.out.println(deployment.getId());
        System.out.println(deployment.getName());
        
        
    }
    
    
    /** 启动流程实例 */
    @Test
    public void startProcessInstance() {
        //与正在执行的流程实例和执行对象相关的service
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //对应bpmn的id
        //默认按照最新版本启动
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("helloworld");
        System.out.println("流程实例id:"+ instance.getId());//流程实例id
        System.out.println("流程定义id:"+ instance.getProcessDefinitionId());//流程定义id
        
        
    }
    
    /** 查询当前人的个人任务 */
    @Test
    public void findMyPersonalTask() {
        String assign = "张三";
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(assign).list();
        
        if(tasks != null && tasks.size() > 0) {
            for(Task task : tasks) {
                System.out.println("任务ID："+task.getId());
                System.out.println("名称："+task.getName());
                System.out.println(""+task.getCreateTime());
                System.out.println("办理人："+task.getAssignee());
                System.out.println("实例ID："+task.getProcessInstanceId());
                System.out.println("执行对象："+task.getExecutionId());
                System.out.println("流程定义ID："+task.getProcessDefinitionId());
            }
        }
        
        
    }
    
    
}
