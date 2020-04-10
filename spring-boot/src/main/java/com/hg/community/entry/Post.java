package com.hg.community.entry;


import com.fasterxml.jackson.annotation.JsonInclude;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Post {

    private Integer id;

    @NotNull
    private String appId;

    @NotNull
    @Min(1)
    private Integer userId;

    @NotNull
    private String content;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private int goodNum;

    private int badNum;

    private int commentNum;

    private String goodPersonIds;

    private String badPersonIds;


    private List<Comment> commentList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public int getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(int goodNum) {
        this.goodNum = goodNum;
    }

    public int getBadNum() {
        return badNum;
    }

    public void setBadNum(int badNum) {
        this.badNum = badNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public String getGoodPersonIds() {
        return goodPersonIds;
    }

    public void setGoodPersonIds(String goodPersonIds) {
        this.goodPersonIds = goodPersonIds;
    }

    public String getBadPersonIds() {
        return badPersonIds;
    }

    public void setBadPersonIds(String badPersonIds) {
        this.badPersonIds = badPersonIds;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
