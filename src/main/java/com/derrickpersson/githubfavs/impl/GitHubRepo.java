package com.derrickpersson.githubfavs.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubRepo implements IGitRepo {
    private @Id @GeneratedValue Long id;
    private String name;
    private Integer stargazers_count;
    private String html_url;
    private String url;

    // TODO: create proper object to handle view layer requirements
    @Transient
    public List<IGitCommit> commits;
    public List<IGitCommit> setCommits(List<IGitCommit> gitCommits){
        return this.commits = gitCommits;
    }

    GitHubRepo(){

    }

    GitHubRepo(String name, Integer stargazers_count, String html_url, String url) {
        this.name = name;
        this.stargazers_count = stargazers_count;
        this.html_url = html_url;
        this.url = url;
    }
}
