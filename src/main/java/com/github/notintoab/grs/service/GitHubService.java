package com.github.notintoab.grs.service;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.github.notintoab.grs.client.GitHubApiClient;
import com.github.notintoab.grs.model.Repo;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;



@ApplicationScoped
public class GitHubService {
    @Inject
    @RestClient
    GitHubApiClient gitHubApiClient;

    public Uni<List<Repo>> getReposAndBranches(String ownerLogin) {
        return gitHubApiClient.getByOwnerLogin(ownerLogin)
                .onItem().transformToUni(repos ->
                        Uni.combine().all().unis(
                            repos.stream().map(repo ->
                            gitHubApiClient.getByRepoName(ownerLogin, repo.repoName)
                            .onItem().invoke(branches -> repo.branches = branches))
                            .toList()
                        ).with(unused -> repos));
    }
}
