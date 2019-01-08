package com.derrickpersson.githubfavs.controllers;

import com.derrickpersson.githubfavs.impl.IGitCommit;
import com.derrickpersson.githubfavs.impl.IGitRepo;
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
    List<IGitRepo> all(){
        return gitHubService.returnAllGitRepos();
    }

    @GetMapping("/repos/{id}")
    IGitRepo getOne(@PathVariable("id") long id) {
        return gitHubService.getRepo(id);
    }

    @GetMapping("/repos/{id}/commits")
    List<IGitCommit> allCommits(@PathVariable("id") long id) {
        return gitHubService.returnAllGitCommits(id);
    }

}
