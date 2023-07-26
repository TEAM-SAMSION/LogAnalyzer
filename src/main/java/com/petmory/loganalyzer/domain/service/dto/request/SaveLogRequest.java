package com.petmory.loganalyzer.domain.service.dto.request;

import lombok.Getter;

@Getter
public class SaveLogRequest {
    private String logId;
    private Integer executeTime;
    private String methodName;
    private String exceptionMessage;

    public SaveLogRequest(String logId, Integer executeTime, String methodName, String exceptionMessage) {
        this.logId = logId;
        this.executeTime = executeTime;
        this.methodName = methodName;
        this.exceptionMessage = exceptionMessage;
    }
}
