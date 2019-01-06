package com.derrickpersson.githubfavs.impl;

import com.derrickpersson.githubfavs.service.AbstractGitService;
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
    private String CommitsResource;

    @Bean
    CommandLineRunner initDatabase(GitHubService service) {
        return args -> {
            RestTemplate restTemplate = new RestTemplate();
            GitHubRepoOverview gitHubRepoOverview = restTemplate.getForObject(this.APIUrl, GitHubRepoOverview.class);
            gitHubRepoOverview.getItems().forEach(gitHubRepo -> {
                log.info("Seeding Database.... " + service.saveRepo(gitHubRepo));
                ResponseEntity<GitHubCommit[]> responseEntity  = restTemplate.getForEntity(gitHubRepo.getUrl() + this.CommitsResource, GitHubCommit[].class);
                GitHubCommit[] gitHubCommits = responseEntity.getBody();
                List<GitHubCommit> gitHubCommitsList = Arrays.asList(gitHubCommits);
                gitHubCommitsList.forEach(gitHubCommit -> log.info("GitHubCommit: " + gitHubCommit.toString()));
            });
        };
    }
}
