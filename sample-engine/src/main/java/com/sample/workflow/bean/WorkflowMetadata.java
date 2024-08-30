package com.sample.workflow.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkflowMetadata implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 863987078548226628L;

    private String key;

    private Integer version;

    private Map<String, Object> params;

}
