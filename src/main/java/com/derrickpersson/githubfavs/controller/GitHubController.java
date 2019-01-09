package com.derrickpersson.githubfavs.controller;

import com.derrickpersson.githubfavs.impl.GitHubCommit;
import com.derrickpersson.githubfavs.impl.GitHubRepo;
import com.derrickpersson.githubfavs.service.GitHubService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/repos/{id}")
    GitHubRepo getOne(@PathVariable("id") long id) {
        return gitHubService.getRepo(id);
    }

    @GetMapping("/repos/{id}/commits")
    List<GitHubCommit> allCommits(@PathVariable("id") long id) {
        return gitHubService.returnAllGitCommits(id);
    }

}
