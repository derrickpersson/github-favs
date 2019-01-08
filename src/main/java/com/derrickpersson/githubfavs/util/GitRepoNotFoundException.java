package com.derrickpersson.githubfavs.util;

public class GitRepoNotFoundException extends RuntimeException {
    public GitRepoNotFoundException(Long id) {
        super("Could not find Git Repo: " + id);
    }
}
