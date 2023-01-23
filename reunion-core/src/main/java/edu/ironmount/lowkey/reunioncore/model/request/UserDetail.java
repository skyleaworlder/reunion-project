package edu.ironmount.lowkey.reunioncore.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserDetail(
    String username,
    String password,
    String nickName,
    String recentResidence,
    String workplace
) {}
