package com.github.notintoab.grs.client;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.github.notintoab.grs.model.Branch;
import com.github.notintoab.grs.model.Repo;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface GitHubApiClient {
    @GET
    @Path("/users/{ownerLogin}/repos")
    Uni<List<Repo>> getByOwnerLogin(@PathParam("ownerLogin") String ownerLogin);

    @GET
    @Path("repos/{ownerLogin}/{repo}/branches")
    Uni<List<Branch>> getByRepoName(@PathParam("ownerLogin") String ownerLogin, 
                                    @PathParam("repo") String repoName);
}
