package com.github.notintoab.grs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Commit {
    @JsonProperty("sha")
    public String sha;
}
