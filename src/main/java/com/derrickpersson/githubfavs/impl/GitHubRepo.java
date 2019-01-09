package com.derrickpersson.githubfavs.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubRepo implements IGitRepo {
    private @Id @GeneratedValue Long id;
    private String name;
    private Integer stargazers_count;
    private String html_url;
    private String url;

    // TODO: create proper object to handle view layer requirements
    @Transient
    public List<GitHubCommit> commits;

    public GitHubRepo(){}
}
