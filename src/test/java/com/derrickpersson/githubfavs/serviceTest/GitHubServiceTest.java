package com.derrickpersson.githubfavs.serviceTest;

import com.derrickpersson.githubfavs.impl.GitHubRepo;
import com.derrickpersson.githubfavs.impl.IGitHubCommitRepository;
import com.derrickpersson.githubfavs.impl.IGitHubRepoRepository;
import com.derrickpersson.githubfavs.service.GitHubService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class GitHubServiceTest {

    @Autowired
    @MockBean
    IGitHubRepoRepository gitHubRepoRepository;

    @Autowired
    @MockBean
    IGitHubCommitRepository gitHubCommitRepository;

    @Test
    public void testInitService(){
        GitHubService gitHubService = new GitHubService(gitHubRepoRepository, gitHubCommitRepository);
        assertTrue(gitHubService instanceof GitHubService);
    }

    @Test
    public void testReturnAllGitRepos(){
        GitHubService gitHubService = new GitHubService(gitHubRepoRepository, gitHubCommitRepository);
        List<GitHubRepo> gitHubRepos = new ArrayList<GitHubRepo>();
        when(gitHubService.returnAllGitRepos()).thenReturn(gitHubRepos);
        Mockito.verify(gitHubRepoRepository).findAll();
    }

    @Test
    public void testSaveRepo(){
        GitHubService gitHubService = new GitHubService(gitHubRepoRepository, gitHubCommitRepository);
        GitHubRepo gitHubRepo = new GitHubRepo();
        when(gitHubService.saveRepo(gitHubRepo)).thenReturn(gitHubRepo);
        Mockito.verify(gitHubRepoRepository).save(gitHubRepo);
    }

    @Test
    public void testGetRepo(){
        GitHubService gitHubService = new GitHubService(gitHubRepoRepository, gitHubCommitRepository);
        Long id = new Long(1);
        GitHubRepo gitHubRepo = new GitHubRepo();
        when(gitHubService.getRepo(id)).thenReturn(gitHubRepo);
        Mockito.verify(gitHubRepoRepository).findById(id);
    }

}
