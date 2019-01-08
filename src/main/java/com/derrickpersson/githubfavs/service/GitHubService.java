package com.derrickpersson.githubfavs.service;

import com.derrickpersson.githubfavs.impl.*;
import com.derrickpersson.githubfavs.util.GitRepoNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GitHubService implements IGitRepoService, IGitCommitService {
    private final IGitRepoRepository gitHubRepoRepository;
    private final IGitCommitRepository gitHubCommitRepository;

    GitHubService(IGitRepoRepository gitHubRepoRepository, IGitCommitRepository gitHubCommitRepository) {
        this.gitHubRepoRepository = gitHubRepoRepository;
        this.gitHubCommitRepository = gitHubCommitRepository;
    }

    public List<IGitRepo> returnAllGitRepos(){
        return gitHubRepoRepository.findAll();
    }

    public IGitRepo saveRepo(IGitRepo gitHubRepo){
        return gitHubRepoRepository.save(gitHubRepo);
    }

    public IGitRepo getRepo(Long gitHubRepoId) throws GitRepoNotFoundException {
        IGitRepo gitHubRepo = gitHubRepoRepository.findById(gitHubRepoId)
                .orElseThrow(() -> new GitRepoNotFoundException(gitHubRepoId));
        gitHubRepo.setCommits(this.returnAllGitCommits(gitHubRepo.getId()));
        return gitHubRepo;
    }

    public List<IGitCommit> returnAllGitCommits(Long gitHubRepoId){
        return gitHubCommitRepository.returnAllGitCommits(gitHubRepoId);
    }

    public IGitCommit saveCommit(IGitCommit gitHubCommit){
        return gitHubCommitRepository.save(gitHubCommit);
    }
}
