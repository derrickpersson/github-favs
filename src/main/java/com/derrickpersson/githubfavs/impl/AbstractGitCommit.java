package com.derrickpersson.githubfavs.impl;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public abstract class AbstractGitCommit {
    @Id @GeneratedValue Long id;
    String sha;
    String node_id;
}
