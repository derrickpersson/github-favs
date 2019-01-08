package com.derrickpersson.githubfavs.service;

import com.derrickpersson.githubfavs.impl.IGitRepo;
import com.derrickpersson.githubfavs.util.GitRepoNotFoundException;

import java.util.List;

public interface IGitRepoService {
    List<IGitRepo> returnAllGitRepos();
    IGitRepo saveRepo(IGitRepo gitRepo);
    IGitRepo getRepo(Long gitRepoId) throws GitRepoNotFoundException;
}
