package com.pawith.loganalyzer.domain.controller;

import com.pawith.loganalyzer.domain.entity.LogType;
import com.pawith.loganalyzer.domain.service.LogService;
import com.pawith.loganalyzer.domain.service.dto.request.SaveLogRequest;
import com.pawith.loganalyzer.domain.service.dto.response.InfoLogResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/log")
@RequiredArgsConstructor
public class LogController {
    private final LogService logService;

    @PostMapping()
    public Mono<Void> saveLog(@RequestBody SaveLogRequest request){
        return logService.saveLog(request);
    }

    @GetMapping("/{logType}")
    public Flux<InfoLogResponse> getLogsByLogType(@PathVariable LogType logType){
        return logService.getLogsByLogType(logType);
    }

    @GetMapping()
    public Flux<InfoLogResponse> getLogById(@RequestParam String logId){
        return logService.getLogById(logId);
    }

}