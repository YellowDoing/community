package com.hg.community.entry;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
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

}
