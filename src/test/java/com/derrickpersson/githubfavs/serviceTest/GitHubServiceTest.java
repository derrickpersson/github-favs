package com.derrickpersson.githubfavs.serviceTest;

import com.derrickpersson.githubfavs.impl.GitHubCommit;
import com.derrickpersson.githubfavs.impl.GitHubRepo;
import com.derrickpersson.githubfavs.impl.IGitHubCommitRepository;
import com.derrickpersson.githubfavs.impl.IGitHubRepoRepository;
import com.derrickpersson.githubfavs.service.GitHubService;
import com.derrickpersson.githubfavs.util.GitRepoNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class GitHubServiceTest {

    private GitHubService service;
    private IGitHubCommitRepository mockGitHubCommit;
    private IGitHubRepoRepository mockGitHubRepo;

    @Before
    public void initService(){
        IGitHubRepoRepository mockGitHubRepo = mock(IGitHubRepoRepository.class);
        IGitHubCommitRepository mockGitHubCommit = mock(IGitHubCommitRepository.class);
        GitHubService service = new GitHubService(mockGitHubRepo,mockGitHubCommit);
        this.service = service;
        this.mockGitHubCommit = mockGitHubCommit;
        this.mockGitHubRepo = mockGitHubRepo;
        GitHubRepo sampleRepo = new GitHubRepo();
        sampleRepo.setId(new Long(1));
        sampleRepo.setHtml_url("anyURL");
        sampleRepo.setUrl("anyURL");
        sampleRepo.setName("name");
        GitHubCommit sampleCommit = new GitHubCommit();
        sampleCommit.setGitRepoId(new Long(1));
        sampleCommit.setCommitMessage("test");
        sampleCommit.setCommitAuthor("test");
        sampleCommit.setId(new Long(2));
    }

    @Test
    public void testInitService(){
        assertTrue(service instanceof GitHubService);
    }

    @Test
    public void testReturnAllGitRepos(){
        this.service.returnAllGitRepos();
        verify(this.mockGitHubRepo).findAll();
        verifyNoMoreInteractions(this.mockGitHubRepo);
    }

    @Test
    public void testSaveRepo(){
        GitHubRepo gitHubRepo = new GitHubRepo();
        this.service.saveRepo(gitHubRepo);
        verify(this.mockGitHubRepo).save(gitHubRepo);
        verifyNoMoreInteractions(this.mockGitHubRepo);
    }

    @Test
    public void testGetRepo(){
        Long id = new Long(1);
        GitHubRepo sampleRepo = new GitHubRepo();
        sampleRepo.setId(id);
        sampleRepo.setHtml_url("anyURL");
        sampleRepo.setUrl("anyURL");
        sampleRepo.setName("name");
        GitHubCommit sampleCommit = new GitHubCommit();
        sampleCommit.setGitRepoId(id);
        sampleCommit.setCommitMessage("test");
        sampleCommit.setCommitAuthor("test");
        sampleCommit.setId(new Long(2));
        List<GitHubCommit> sampleCommitList = new ArrayList<GitHubCommit>();
        sampleCommitList.add(sampleCommit);
        when(this.mockGitHubRepo.findById(id)).thenReturn(Optional.of(sampleRepo));
        when(this.mockGitHubCommit.returnAllGitCommits(id)).thenReturn(sampleCommitList);
        this.service.getRepo(id);
        verify(this.mockGitHubRepo).findById(anyLong());
        verify(this.mockGitHubCommit).returnAllGitCommits(anyLong());
        verifyNoMoreInteractions(this.mockGitHubRepo);
        verifyNoMoreInteractions(this.mockGitHubCommit);
    }

    @Test(expected = GitRepoNotFoundException.class)
    public void testRepoNotFoundException(){
        when(this.mockGitHubRepo.findById(anyLong())).thenThrow(new GitRepoNotFoundException(anyLong()));
        this.service.getRepo(new Long(1));
    }

    @Test
    public void testReturnAllGitCommits(){
        Long id = new Long(1);
        GitHubCommit sampleCommit = new GitHubCommit();
        sampleCommit.setGitRepoId(id);
        sampleCommit.setCommitMessage("test");
        sampleCommit.setCommitAuthor("test");
        sampleCommit.setId(new Long(2));
        List<GitHubCommit> sampleCommitList = new ArrayList<GitHubCommit>();
        sampleCommitList.add(sampleCommit);
        when(this.mockGitHubCommit.returnAllGitCommits(id)).thenReturn(sampleCommitList);
        this.service.returnAllGitCommits(id);
        verify(this.mockGitHubCommit).returnAllGitCommits(id);
        verifyNoMoreInteractions(this.mockGitHubCommit);
    }

}
