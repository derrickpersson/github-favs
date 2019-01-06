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
public class GitHubRepo extends AbstractGitRepo {
    public @Id @GeneratedValue Long id;
    public String name;
    public Integer stargazers_count;
    public String html_url;
    public String url;

    // TODO: create proper object to handle view layer requirements
    @Transient
    public List<GitHubCommit> commits;

    GitHubRepo(){

    }

    GitHubRepo(String name, Integer stargazers_count, String html_url, String url) {
        this.name = name;
        this.stargazers_count = stargazers_count;
        this.html_url = html_url;
        this.url = url;
    }
}
