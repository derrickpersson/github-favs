package com.derrickpersson.githubfavs.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Slf4j
public class SeedDatabase {

    @Value("${githubAPIUrl}")
    private String APIUrl;

    @Bean
    CommandLineRunner initDatabase(GitHubRepoRepository repository) {
        return args -> {
            RestTemplate restTemplate = new RestTemplate();
//            GitHubRepoOverview gitHubRepoOverview = restTemplate.getForObject(this.APIUrl, GitHubRepoOverview.class);
//            gitHubRepoOverview.getItems().forEach(gitHubRepo -> {
//                log.info("Seeding database.... " + repository.save(gitHubRepo));
//            });

            ResponseEntity<GitHubCommit[]> responseEntity  = restTemplate.getForEntity(this.APIUrl, GitHubCommit[].class);
            GitHubCommit[] gitHubCommits = responseEntity.getBody();
            List<GitHubCommit> gitHubCommitsList = Arrays.asList(gitHubCommits);
            gitHubCommitsList.forEach(gitHubCommit -> log.info("GitHubCommit: " + gitHubCommit.toString()));
        };
    }
}
