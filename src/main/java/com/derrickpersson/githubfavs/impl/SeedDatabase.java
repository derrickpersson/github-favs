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
        // TODO: make call to 'Git Hub API' service and store results
        return args -> {
            RestTemplate restTemplate = new RestTemplate();
            GitHubRepoOverview gitHubRepoOverview = restTemplate.getForObject("https://api.github.com/search/repositories?q=test&sort=stars&order=desc", GitHubRepoOverview.class);
            log.info(gitHubRepoOverview.toString());

//            log.info("Seeding database... " + repository.save(new GitHubRepo("Great Repo!!!", 123)));
//            log.info("Seeding database... " + repository.save(new GitHubRepo("Best Repo!!!", 777)));
        };
    }
}
