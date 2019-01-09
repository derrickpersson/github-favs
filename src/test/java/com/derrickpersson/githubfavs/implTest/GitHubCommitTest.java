package com.derrickpersson.githubfavs.implTest;

import com.derrickpersson.githubfavs.impl.GitHubCommit;
import com.derrickpersson.githubfavs.impl.IGitCommit;
import org.junit.Test;

public class GitHubCommitTest {

    @Test
    public void testInterfaceImplemented(){
        GitHubCommit gitHubCommit = new GitHubCommit();
        assert(gitHubCommit instanceof IGitCommit);
    }

    @Test
    public void testSetGitRepoId(){
        GitHubCommit gitHubCommit = new GitHubCommit();
        gitHubCommit.setGitRepoId(new Long(1));
        assert(gitHubCommit.getGitRepoId() == 1);
    }

}
