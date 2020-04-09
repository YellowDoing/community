package com.hg.community.entry;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class Comment {

    private Integer id;

    @NotNull
    @Min(1)
    private Integer postId;
    @NotNull
    @Min(1)
    private Integer userId;

    @NotNull
    private String appId;
    @NotNull
    private String content;

    @NotNull
    @Min(1)
    private int commentId;

    private LocalDateTime createAt;

}
