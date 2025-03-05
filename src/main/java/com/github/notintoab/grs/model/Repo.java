package com.github.notintoab.grs.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Repo {
    @JsonProperty("name")
    public String repoName;

    @JsonProperty("owner")
    public Owner ownerLogin;
    public boolean fork;
    public List<Branch> branches;

}

