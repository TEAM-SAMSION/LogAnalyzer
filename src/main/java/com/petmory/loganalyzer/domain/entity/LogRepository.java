package com.petmory.loganalyzer.domain.entity;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface LogRepository extends ReactiveMongoRepository<Log, String> {
}
