package com.derrickpersson.githubfavs.service;

import com.derrickpersson.githubfavs.impl.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GitHubService extends AbstractGitService {
    private final IGitRepoRepository gitHubRepoRepository;
    private final IGitCommitRepository gitHubCommitRepository;

    GitHubService(IGitRepoRepository gitHubRepoRepository, IGitCommitRepository gitHubCommitRepository) {
        this.gitHubRepoRepository = gitHubRepoRepository;
        this.gitHubCommitRepository = gitHubCommitRepository;
    }

    public List<GitHubRepo> returnAllGitRepos(){
        return gitHubRepoRepository.findAll();
    }

    public GitHubRepo saveRepo(GitHubRepo gitHubRepo){
        return gitHubRepoRepository.save(gitHubRepo);
    }

    public List<GitHubCommit> returnAllGitCommits(){
        return gitHubCommitRepository.findAll();
    }
}
