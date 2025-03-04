package com.github.notintoab.grs.resource;

import java.util.List;

import com.github.notintoab.grs.model.Repo;
import com.github.notintoab.grs.service.GitHubService;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/github")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GitHubResource {
    @Inject
    GitHubService gitHubService;

    @GET
    @Path("/{ownerLogin}")
    public Uni<List<Repo>> getRepos(@PathParam("ownerLogin") String ownerLogin) {
        return gitHubService.getReposAndBranches(ownerLogin);
    }
}
