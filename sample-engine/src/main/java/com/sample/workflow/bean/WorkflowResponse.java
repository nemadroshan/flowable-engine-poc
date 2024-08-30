package com.sample.workflow.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkflowResponse implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3804661879873252012L;

    private String key;

    private Integer version;

    private String processDefinitionId;

    private String processInstanceId;

    private String executionStatus;

    private Map<String, Object> processVariables;

}
