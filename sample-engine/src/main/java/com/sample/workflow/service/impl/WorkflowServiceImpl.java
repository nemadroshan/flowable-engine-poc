package com.sample.workflow.service.impl;

import com.sample.workflow.bean.WorkflowMetadata;
import com.sample.workflow.bean.WorkflowResponse;
import com.sample.workflow.service.WorkflowService;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;


@Service
public class WorkflowServiceImpl implements WorkflowService {

    @Autowired(required = true)
    private RuntimeService runtimeService;


    @Autowired
    private HistoryService historyService;


    @Override
    public WorkflowResponse startProcess() {
        WorkflowMetadata workflowMetadata = new WorkflowMetadata("getQuote", null,
                new HashMap<String, Object>());
        System.out.println("Starting workflow process with - " + workflowMetadata);
        WorkflowResponse wfResponse = null;
        try {

            if (StringUtils.hasText(workflowMetadata.getKey())
            ) {
                ProcessInstance pi = runtimeService.startProcessInstanceByKey(workflowMetadata.getKey(),
                        workflowMetadata.getParams());
                wfResponse = WorkflowResponse.builder().executionStatus("Success").key(workflowMetadata.getKey())
                        .version(pi.getProcessDefinitionVersion()).processDefinitionId(pi.getProcessDefinitionId())
                        .processInstanceId(pi.getProcessInstanceId()).processVariables(pi.getProcessVariables())
                        .build();
                System.out.println(wfResponse);
            } else {
                throw new Exception("Worklfow key and/or variables are not set.");
            }
        } catch (Exception e) {
            wfResponse = WorkflowResponse.builder().executionStatus("Failed").key(workflowMetadata.getKey()).build();
            //e.printStackTrace();
        }
        System.out.println("Ending workflow process with - " + wfResponse);
        return wfResponse;
    }
}
