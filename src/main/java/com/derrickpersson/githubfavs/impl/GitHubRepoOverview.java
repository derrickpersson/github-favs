package com.derrickpersson.githubfavs.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubRepoOverview {
    private List<GitHubRepo> items;

}
