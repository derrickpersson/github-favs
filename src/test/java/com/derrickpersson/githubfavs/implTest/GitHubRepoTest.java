package com.derrickpersson.githubfavs.implTest;

import com.derrickpersson.githubfavs.impl.GitHubRepo;
import com.derrickpersson.githubfavs.impl.IGitRepo;
import org.junit.Test;

public class GitHubRepoTest {

    @Test
    public void testInterfaceImplemented(){
        GitHubRepo gitHubRepo = new GitHubRepo();
        assert(gitHubRepo instanceof IGitRepo);
    }
}
