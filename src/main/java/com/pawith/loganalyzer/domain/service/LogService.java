package com.pawith.loganalyzer.domain.service;

import com.pawith.loganalyzer.domain.entity.LogType;
import com.pawith.loganalyzer.domain.service.dto.request.SaveLogRequest;
import com.pawith.loganalyzer.domain.service.dto.response.InfoLogResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LogService {
    Mono<Void> saveLog(SaveLogRequest request);

    Flux<InfoLogResponse> getLogsByLogType(LogType logType);

    Flux<InfoLogResponse> getLogById(String logId);
}
