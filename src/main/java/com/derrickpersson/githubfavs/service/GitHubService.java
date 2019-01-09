package com.derrickpersson.githubfavs.service;

import com.derrickpersson.githubfavs.impl.*;
import com.derrickpersson.githubfavs.util.GitRepoNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GitHubService {
    private final IGitHubRepoRepository gitHubRepoRepository;
    private final IGitHubCommitRepository gitHubCommitRepository;

    public GitHubService(IGitHubRepoRepository gitHubRepoRepository, IGitHubCommitRepository gitHubCommitRepository) {
        this.gitHubRepoRepository = gitHubRepoRepository;
        this.gitHubCommitRepository = gitHubCommitRepository;
    }

    public List<GitHubRepo> returnAllGitRepos(){
        return gitHubRepoRepository.findAll();
    }

    public GitHubRepo saveRepo(GitHubRepo gitHubRepo){
        return gitHubRepoRepository.save(gitHubRepo);
    }

    public GitHubRepo getRepo(Long gitHubRepoId) throws GitRepoNotFoundException {
        GitHubRepo gitHubRepo = gitHubRepoRepository.findById(gitHubRepoId)
                .orElseThrow(() -> new GitRepoNotFoundException(gitHubRepoId));
        gitHubRepo.setCommits(this.returnAllGitCommits(gitHubRepo.getId()));
        return gitHubRepo;
    }

    public List<GitHubCommit> returnAllGitCommits(Long gitHubRepoId){
        return gitHubCommitRepository.returnAllGitCommits(gitHubRepoId);
    }

    public GitHubCommit saveCommit(GitHubCommit gitHubCommit){
        return gitHubCommitRepository.save(gitHubCommit);
    }
}
