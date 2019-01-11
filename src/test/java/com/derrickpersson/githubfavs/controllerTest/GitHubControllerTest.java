package com.derrickpersson.githubfavs.controllerTest;

import com.derrickpersson.githubfavs.controller.GitHubController;
import com.derrickpersson.githubfavs.impl.GitHubCommit;
import com.derrickpersson.githubfavs.impl.GitHubRepo;
import com.derrickpersson.githubfavs.service.GitHubService;
import com.derrickpersson.githubfavs.util.GitRepoNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class GitHubControllerTest {

    private GitHubService mockService;
    private GitHubController controller;

    @Before
    public void initTests(){
        GitHubService mockService = mock(GitHubService.class);
        GitHubController controller = new GitHubController(mockService);
        this.mockService = mockService;
        this.controller = controller;
    }

    @Test
    public void testInitController(){
        assertTrue(controller instanceof GitHubController);
    }

    @Test
    public void testGetAllRepos(){
        GitHubRepo sampleRepo = new GitHubRepo();
        sampleRepo.setId(new Long(1));
        sampleRepo.setHtml_url("anyURL");
        sampleRepo.setUrl("anyURL");
        sampleRepo.setName("name");
        List<GitHubRepo> sampleGitRepoList = new ArrayList<GitHubRepo>();
        sampleGitRepoList.add(sampleRepo);
        when(mockService.returnAllGitRepos()).thenReturn(sampleGitRepoList);
        controller.all();
        verify(mockService).returnAllGitRepos();
        verifyNoMoreInteractions(mockService);
    }

    @Test
    public void testGetOneRepo(){
        GitHubRepo sampleRepo = new GitHubRepo();
        sampleRepo.setId(new Long(1));
        sampleRepo.setHtml_url("anyURL");
        sampleRepo.setUrl("anyURL");
        sampleRepo.setName("name");
        when(mockService.getRepo(anyLong())).thenReturn(sampleRepo);
        controller.getOne(1L);
        verify(mockService).getRepo(anyLong());
        verifyNoMoreInteractions(mockService);
    }

    @Test(expected = GitRepoNotFoundException.class)
    public void testGetOneRepoException(){
        when(mockService.getRepo(anyLong())).thenThrow(new GitRepoNotFoundException(anyLong()));
        controller.getOne(1L);
    }

    @Test
    public void testGetCommits(){
        GitHubCommit sampleCommit = new GitHubCommit();
        sampleCommit.setGitRepoId(new Long(1));
        sampleCommit.setCommitMessage("test");
        sampleCommit.setCommitAuthor("test");
        sampleCommit.setId(new Long(2));
        List<GitHubCommit> sampleCommitList = new ArrayList<GitHubCommit>();
        sampleCommitList.add(sampleCommit);
        when(mockService.returnAllGitCommits(anyLong())).thenReturn(sampleCommitList);
        controller.allCommits(1L);
        verify(mockService).returnAllGitCommits(anyLong());
        verifyNoMoreInteractions(mockService);
    }
}
