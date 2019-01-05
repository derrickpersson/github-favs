package com.derrickpersson.githubfavs.service;

import com.derrickpersson.githubfavs.impl.GitHubRepo;
import com.derrickpersson.githubfavs.impl.GitHubRepoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GitHubService {
    private final GitHubRepoRepository gitHubRepoRepository;

    GitHubService(GitHubRepoRepository repository) {
        this.gitHubRepoRepository = repository;
    }

    public List<GitHubRepo> returnAll(){
        return gitHubRepoRepository.findAll();
    }
}
