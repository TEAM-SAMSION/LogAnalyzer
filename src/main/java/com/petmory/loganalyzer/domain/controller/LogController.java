package com.petmory.loganalyzer.domain.controller;

import com.petmory.loganalyzer.domain.service.LogService;
import com.petmory.loganalyzer.domain.service.dto.request.SaveLogRequest;
import com.petmory.loganalyzer.domain.service.dto.response.InfoLogResponse;
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

    @GetMapping("/all")
    public Flux<InfoLogResponse> getLogs(){
        return logService.getLogs();
    }

}