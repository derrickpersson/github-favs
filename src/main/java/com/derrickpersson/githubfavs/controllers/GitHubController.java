package com.derrickpersson.githubfavs.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class GitHubController {

    @RequestMapping(path = "/", method = GET )
    public String getTopGitHubRepos(){
        return "{\"gitHubRepos\": \"TEST\"}";
    }

}
