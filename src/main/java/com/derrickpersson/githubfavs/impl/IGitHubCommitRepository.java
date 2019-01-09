package com.derrickpersson.githubfavs.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IGitHubCommitRepository extends JpaRepository<GitHubCommit, Long> {

    @Query(
            value = "SELECT * FROM GIT_HUB_COMMIT WHERE GIT_REPO_ID = :#{#gitRepoId}",
            nativeQuery = true
    )
    List<GitHubCommit> returnAllGitCommits(Long gitRepoId);
}
