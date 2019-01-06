package com.derrickpersson.githubfavs.controllers;

import com.derrickpersson.githubfavs.impl.GitHubRepo;
import com.derrickpersson.githubfavs.service.GitHubService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GitHubController {

    private final GitHubService gitHubService;

    GitHubController(GitHubService gitHubService){
        this.gitHubService = gitHubService;
    }

    @GetMapping("/repos")
    List<GitHubRepo> all(){
        return gitHubService.returnAllGitRepos();
    }

}
