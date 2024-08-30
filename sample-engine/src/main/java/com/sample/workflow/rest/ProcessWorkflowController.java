package com.sample.workflow.rest;

import com.sample.workflow.bean.WorkflowResponse;
import com.sample.workflow.service.WorkflowService;
import org.flowable.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/process")
public class ProcessWorkflowController {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private WorkflowService workflowService;

    @PostMapping(value = "/start",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WorkflowResponse startProcess()
            throws Exception {
        System.out.println("Starting process instance ");
        return workflowService.startProcess();
    }


}
