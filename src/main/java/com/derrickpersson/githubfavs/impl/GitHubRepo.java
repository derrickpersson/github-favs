package com.derrickpersson.githubfavs.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubRepo extends AbstractGitRepo {
    private @Id @GeneratedValue Long id;
    private String name;
    private Integer stargazers_count;
    private String html_url;
    private String url;

    GitHubRepo(){

    }

    GitHubRepo(String name, Integer stargazers_count, String html_url, String url) {
        this.name = name;
        this.stargazers_count = stargazers_count;
        this.html_url = html_url;
        this.url = url;
    }
}
