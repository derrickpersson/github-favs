package com.derrickpersson.githubfavs.service;

import com.derrickpersson.githubfavs.impl.*;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
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

    public GitHubRepo getRepo(Long gitHubRepoId){
        GitHubRepo gitHubRepo = gitHubRepoRepository.findById(gitHubRepoId).orElseThrow(() -> new EntityNotFoundException());
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
