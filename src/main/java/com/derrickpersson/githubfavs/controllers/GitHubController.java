package com.derrickpersson.githubfavs.controllers;

import com.derrickpersson.githubfavs.impl.GitHubRepo;
import com.derrickpersson.githubfavs.impl.GitHubRepoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GitHubController {

    private final GitHubRepoRepository gitHubRepoRepository;

    GitHubController(GitHubRepoRepository gitHubRepoRepository){
        this.gitHubRepoRepository = gitHubRepoRepository;
    }

    @GetMapping("/repos")
    List<GitHubRepo> all(){
        return gitHubRepoRepository.findAll();
    }

}
