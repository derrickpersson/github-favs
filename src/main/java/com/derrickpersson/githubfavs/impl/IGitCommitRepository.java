package com.derrickpersson.githubfavs.impl;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGitCommitRepository extends JpaRepository<GitHubCommit, Long> {

}
