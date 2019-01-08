package com.derrickpersson.githubfavs.controllers;

import com.derrickpersson.githubfavs.util.GitRepoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GitRepoNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(GitRepoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String gitRepoNotFoundHandler(GitRepoNotFoundException ex) {
        return ex.getMessage();
    }

}
