package com.derrickpersson.githubfavs.impl;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GitHubCommitList {
    private List<GitHubCommit> gitHubCommits;

    public GitHubCommitList(){
        gitHubCommits = new ArrayList<>();
    }

}
