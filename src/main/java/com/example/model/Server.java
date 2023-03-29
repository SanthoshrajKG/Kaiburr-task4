package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "servers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Server {
    @Id
    private String serverId;
    private String serverName;
    private String language;
    private String framework;

}