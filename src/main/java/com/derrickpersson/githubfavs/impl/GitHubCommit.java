package com.derrickpersson.githubfavs.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Map;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubCommit extends AbstractGitCommit {
    private @Id @GeneratedValue Long id;

    private Long gitRepoId;

    private String commitAuthor;

    @Column( length = 10000 )
    private String commitMessage;


    GitHubCommit() {}

    @JsonProperty("commit")
    private void unpackNested(Map<String, Object> commit) {
        this.commitMessage = (String)commit.get("message");

        Map<String, String> commitAuthor = (Map<String, String>)commit.get("author");
        this.commitAuthor = commitAuthor.get("name");
    }
}
