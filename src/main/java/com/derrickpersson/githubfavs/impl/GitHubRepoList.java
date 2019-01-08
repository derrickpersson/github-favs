package com.derrickpersson.githubfavs.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubRepoList implements IGitRepoList{
    private List<GitHubRepo> items;

}
