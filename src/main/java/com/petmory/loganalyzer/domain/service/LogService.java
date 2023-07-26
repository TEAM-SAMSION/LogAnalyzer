package com.petmory.loganalyzer.domain.service;

import com.petmory.loganalyzer.domain.service.dto.request.SaveLogRequest;
import com.petmory.loganalyzer.domain.service.dto.response.InfoLogResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LogService {
    Mono<Void> saveLog(SaveLogRequest request);

    Flux<InfoLogResponse> getLogs();
}
