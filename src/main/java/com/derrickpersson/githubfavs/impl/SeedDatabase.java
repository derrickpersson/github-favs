package com.derrickpersson.githubfavs.impl;

import com.derrickpersson.githubfavs.service.GitHubService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Configuration
@Slf4j
public class SeedDatabase {

    @Value("${gitHubAPIUrl}")
    private String APIUrl;

    @Value("${gitHubCommitsResource}")
    private String commitsResource;

    @Value("${maxRepoResults}")
    private Integer maxRepoResults;

    @Value("${maxCommitResults}")
    private Integer maxCommitResults;

    @Bean
    CommandLineRunner initDatabase(GitHubService service) {
        return args -> {
            RestTemplate restTemplate = new RestTemplate();
            GitHubRepoList gitHubRepoList = restTemplate.getForObject(this.APIUrl, GitHubRepoList.class);
            gitHubRepoList.getItems().subList(0, this.maxRepoResults).forEach(gitHubRepo -> {
                IGitRepo savedGitHubRepo = service.saveRepo(gitHubRepo);
                ResponseEntity<GitHubCommit[]> responseEntity  = restTemplate.getForEntity(savedGitHubRepo.getUrl() + this.commitsResource, GitHubCommit[].class);
                GitHubCommit[] gitHubCommits = responseEntity.getBody();
                List<GitHubCommit> gitHubCommitsList = Arrays.asList(gitHubCommits);
                gitHubCommitsList.subList(0, this.maxCommitResults).forEach( gitHubCommit -> {
                    gitHubCommit.setGitRepoId(savedGitHubRepo.getId());
                    service.saveCommit(gitHubCommit);
                });
            });
        };
    }

}
