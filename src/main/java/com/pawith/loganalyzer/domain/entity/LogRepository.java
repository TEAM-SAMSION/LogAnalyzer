package com.pawith.loganalyzer.domain.entity;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface LogRepository extends ReactiveMongoRepository<Log, String> {
    Flux<Log> findAllByLogType(LogType logType);

    Flux<Log> findAllByLogId(String logId);
}
