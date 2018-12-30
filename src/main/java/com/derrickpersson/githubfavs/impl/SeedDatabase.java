package com.derrickpersson.githubfavs.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@Slf4j
public class SeedDatabase {
    @Bean
    CommandLineRunner initDatabase(GitHubRepoRepository repository) {
        return args -> {
            RestTemplate restTemplate = new RestTemplate();
            GitHubRepoOverview gitHubRepoOverview = restTemplate.getForObject("https://api.github.com/search/repositories?q=test&sort=stars&order=desc", GitHubRepoOverview.class);
            gitHubRepoOverview.getItems().forEach(gitHubRepo -> {
                log.info("Seeding database.... " + repository.save(gitHubRepo));
            });
        };
    }
}
