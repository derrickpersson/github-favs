package com.derrickpersson.githubfavs.impl;

import java.util.List;

public interface IGitRepo {
    List<IGitCommit> setCommits(List<IGitCommit> gitCommits);
    Long getId();
    String getUrl();
}
