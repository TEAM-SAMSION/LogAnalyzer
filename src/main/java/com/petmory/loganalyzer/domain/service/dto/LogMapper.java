package com.petmory.loganalyzer.domain.service.dto;

import com.petmory.loganalyzer.domain.entity.Log;
import com.petmory.loganalyzer.domain.service.dto.request.SaveLogRequest;
import com.petmory.loganalyzer.domain.service.dto.response.InfoLogResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogMapper {

    public static Log mapToLog(SaveLogRequest request){
        return Log.builder()
            .logId(request.getLogId())
            .executeTime(request.getExecuteTime())
            .methodName(request.getMethodName())
            .exceptionMessage(request.getExceptionMessage())
            .build();
    }

    public static InfoLogResponse mapToInfoLogResponse(Log log){
        return InfoLogResponse.builder()
            .id(log.getId())
            .logId(log.getLogId())
            .executeTime(log.getExecuteTime())
            .methodName(log.getMethodName())
            .exceptionMessage(log.getExceptionMessage())
            .logDate(log.getLogDate())
            .logType(log.getLogType())
            .build();
    }
}
