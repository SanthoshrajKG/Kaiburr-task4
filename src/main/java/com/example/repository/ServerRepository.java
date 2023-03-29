package com.example.repository;

import com.example.model.Server;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServerRepository extends MongoRepository<Server,String> {

    List<Server> findByServerName(String serverName);
}