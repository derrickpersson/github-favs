package com.derrickpersson.githubfavs.impl;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGitRepoRepository extends JpaRepository<GitHubRepo, Long> {

}
