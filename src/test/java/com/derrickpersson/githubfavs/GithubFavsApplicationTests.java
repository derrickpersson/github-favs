package com.derrickpersson.githubfavs;

import com.derrickpersson.githubfavs.controllerTest.GitHubControllerTest;
import com.derrickpersson.githubfavs.implTest.GitHubCommitTest;
import com.derrickpersson.githubfavs.implTest.GitHubRepoTest;
import com.derrickpersson.githubfavs.serviceTest.GitHubServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		GitHubControllerTest.class,
		GitHubCommitTest.class,
		GitHubRepoTest.class,
		GitHubServiceTest.class
})
public class GithubFavsApplicationTests {

	@Test
	public void contextLoads() {
	}

}

