package com.derrickpersson.githubfavs.controllerTest;

import com.derrickpersson.githubfavs.controller.GitHubController;
import com.derrickpersson.githubfavs.impl.IGitHubRepoRepository;
import com.derrickpersson.githubfavs.service.GitHubService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
        // test implementation
    }
}
