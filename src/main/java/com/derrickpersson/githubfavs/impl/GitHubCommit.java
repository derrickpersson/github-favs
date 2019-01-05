package com.derrickpersson.githubfavs.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubCommit extends AbstractGitCommit {
    private @Id @GeneratedValue Long id;
//    private @ManyToOne GitHubRepo gitHubRepo;
    private String sha;
    private String node_id;


    GitHubCommit() {}

    GitHubCommit(String sha, String node_id) {
//        this.gitHubRepo = gitHubRepo;
        this.sha = sha;
        this.node_id = node_id;
    }
}
