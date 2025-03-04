package com.github.notintoab.grs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Branch {
    @JsonProperty("name")
    public String name;

    @JsonProperty("commit")
    public Commit lastCommitSha;
}
