package com.derrickpersson.githubfavs.service;

import com.derrickpersson.githubfavs.impl.IGitCommit;

import java.util.List;

public interface IGitCommitService {
    List<IGitCommit> returnAllGitCommits(Long gitRepoId);
}
