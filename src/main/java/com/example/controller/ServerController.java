package com.example.controller;

import com.example.model.Server;
import com.example.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ServerController {

    @Autowired
    private ServerService service;

    @GetMapping("/servers")
    public String register(Model model){
        model.addAttribute("server", new Server());
        return "register";
    }

    @PostMapping("/servers")
    public String postServer(@ModelAttribute Server server, Model model){
        service.addServer(server);
        model.addAttribute("listServers",service.findAllServer());
        return "Added";
    }

    @GetMapping("/servers/all")
    public String viewHome(Model model){
        model.addAttribute("listServers",service.findAllServer());
        return "index";
    }

    @GetMapping("/servers/get")
    public String getServer(Model model){
        model.addAttribute("server", new Server());
        return "getserver";
    }

    @PostMapping("/servers/get")
    public String getPostServer(@ModelAttribute Server server, Model model){
        service.getServerByServerId(server.getServerId());
        model.addAttribute("listServers",service.getServerByServerId(server.getServerId()));
        return "index";
    }

    @GetMapping("/servers/delete")
    public String deleteServer(Model model){
        model.addAttribute("server", new Server());
        return "getserver";
    }

    @PostMapping("/servers/delete")
    public String deletePostServer(@ModelAttribute Server server, Model model){
        service.deleteServer(server.getServerId());
       // model.addAttribute("listServers",service.getServerByServerId(server.getServerId()));
        return "deleted";
    }

}
