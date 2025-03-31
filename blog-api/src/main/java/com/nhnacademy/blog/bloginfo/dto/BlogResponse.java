package com.nhnacademy.blog.bloginfo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nhnacademy.blog.blogmember.domain.BlogMemberMapping;
import com.nhnacademy.blog.category.domain.Category;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
public class BlogResponse {
    @JsonProperty("blogId")
    Long blogId;

    @JsonProperty("categories")
    List<Category> categories;

    @JsonProperty("blogMemberMappings")
    List<BlogMemberMapping> blogMemberMappings;

    @JsonProperty("blogFid")
    String blogFid;

    @JsonProperty("blogMain")
    boolean blogMain;

    @JsonProperty("blogName")
    String blogName;

    @JsonProperty("blogMbNickName")
    String blogMbNickName;

    @JsonProperty("blogDescription")
    String blogDescription;

    @JsonProperty("createdAt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createdAt;

    @JsonProperty("updatedAt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime updatedAt;

    @JsonProperty("blogIsPublic")
    Boolean blogIsPublic;

    @JsonCreator
    public BlogResponse(
            @JsonProperty("blogId") Long blogId,
            @JsonProperty("categories") List<Category> categories,
            @JsonProperty("blogMemberMappings") List<BlogMemberMapping> blogMemberMappings,
            @JsonProperty("blogFid") String blogFid,
            @JsonProperty("blogMain") boolean blogMain,
            @JsonProperty("blogName") String blogName,
            @JsonProperty("blogMbNickName") String blogMbNickName,
            @JsonProperty("blogDescription") String blogDescription,
            @JsonProperty("createdAt") LocalDateTime createdAt,
            @JsonProperty("updatedAt") LocalDateTime updatedAt,
            @JsonProperty("blogIsPublic") Boolean blogIsPublic) {
        this.blogId = blogId;
        this.categories = categories;
        this.blogMemberMappings = blogMemberMappings;
        this.blogFid = blogFid;
        this.blogMain = blogMain;
        this.blogName = blogName;
        this.blogMbNickName = blogMbNickName;
        this.blogDescription = blogDescription;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.blogIsPublic = blogIsPublic;
    }
}