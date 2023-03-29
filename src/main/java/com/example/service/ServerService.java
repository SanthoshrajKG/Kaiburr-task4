package com.example.service;

import com.example.model.Server;
import com.example.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServerService {
    @Autowired
    private ServerRepository repository;

    public Server addServer(Server server) {
        return repository.save(server);
    }

    public List<Server> findAllServer() {
        return repository.findAll();
    }

    public Server getServerByServerId(String ServerId) {
        return repository.findById(ServerId).get();
    }

    public List<Server> getServerByServerName(String ServerName) {
        return repository.findByServerName(ServerName);
    }

    public String deleteServer(String ServerId) {
        repository.deleteById(ServerId);
        return ServerId + " Server deleted successfully";
    }
}
