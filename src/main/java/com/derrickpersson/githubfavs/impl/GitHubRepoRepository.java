package com.derrickpersson.githubfavs.impl;

import org.springframework.data.jpa.repository.JpaRepository;

interface GitHubRepoRepository extends JpaRepository<GitHubRepo, Long> {

}
