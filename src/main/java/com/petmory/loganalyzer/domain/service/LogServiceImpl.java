package com.petmory.loganalyzer.domain.service;

import com.petmory.loganalyzer.domain.entity.LogRepository;
import com.petmory.loganalyzer.domain.service.dto.LogMapper;
import com.petmory.loganalyzer.domain.service.dto.request.SaveLogRequest;
import com.petmory.loganalyzer.domain.service.dto.response.InfoLogResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    public Flux<InfoLogResponse> getLogs(){
        return logRepository.findAll().map(LogMapper::mapToInfoLogResponse);
    }
}
