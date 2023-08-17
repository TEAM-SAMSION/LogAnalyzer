package com.pawith.loganalyzer.domain.service;

import com.pawith.loganalyzer.domain.entity.Log;
import com.pawith.loganalyzer.domain.entity.LogRepository;
import com.pawith.loganalyzer.domain.entity.LogType;
import com.pawith.loganalyzer.domain.service.dto.LogMapper;
import com.pawith.loganalyzer.domain.service.dto.request.SaveLogRequest;
import com.pawith.loganalyzer.domain.service.dto.response.InfoLogResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService{
    private final LogRepository logRepository;

    /**
     * 동일한 메서드에서 에러 로그 발생 시 슬랙 알람 보내기,
     */
    public Mono<Void> saveLog(SaveLogRequest request){
        return logRepository.save(LogMapper.mapToLog(request)).then();
    }

    public Flux<InfoLogResponse> getLogsByLogType(LogType logType){
        Flux<Log> byLogType = logRepository.findAllByLogType(logType);
        return byLogType
            .publishOn(Schedulers.parallel())
            .flatMap(data -> Flux.just(LogMapper.mapToInfoLogResponse(data)));
    }

    @Override
    public Flux<InfoLogResponse> getLogById(String logId) {
        return logRepository.findAllByLogId(logId)
            .publishOn(Schedulers.parallel())
            .map(LogMapper::mapToInfoLogResponse);
    }
}
