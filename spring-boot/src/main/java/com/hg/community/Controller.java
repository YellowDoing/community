package com.hg.community;

import com.hg.community.dao.CommentMapper;
import com.hg.community.dao.PostMapper;
import com.hg.community.entry.Comment;
import com.hg.community.entry.Post;
import com.hg.community.entry.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class Controller {

    private final PostMapper postMapper;
    private final CommentMapper commentMapper;


    @Autowired
    public Controller(PostMapper postMapper, CommentMapper commentMapper) {
        this.postMapper = postMapper;
        this.commentMapper = commentMapper;
    }


    @GetMapping("/postList")
    public Result<List<Post>> postList(@RequestParam String appId,
                                       @RequestParam int page,
                                       @RequestParam int size) {
        return Result.success(postMapper.selectAllByAppId(appId,
                page * size, (page + 1) * size), "成功");
    }


    @GetMapping("/postList/user")
    public Result<List<Post>> postListListByUserAppId(@RequestParam int userId,
                                                     @RequestParam String appId,
                                                     @RequestParam int page,
                                                     @RequestParam int size) {
        return Result.success(postMapper.selectAllByUserAppId(userId,appId,
                page * size, (page + 1) * size), "成功");
    }


    @GetMapping("/commentList/{postId}")
    public Result<List<Comment>> commentListByPostId(@PathVariable int postId,
                                                     @RequestParam int page,
                                                     @RequestParam int size) {
        return Result.success(commentMapper.selectAllByPostId(postId,
                page * size, (page + 1) * size), "成功");
    }

    @GetMapping("/commentList/user")
    public Result<List<Comment>> commentListByUserAppId(@RequestParam int userId,
                                                  @RequestParam String appId,
                                                  @RequestParam int page,
                                                  @RequestParam int size) {
        return Result.success(commentMapper.selectAllByUserAppId(userId,appId,
                page * size, (page + 1) * size), "成功");
    }


    @PostMapping("/post")
    public Result<Post> createPost(@RequestBody @Validated Post post) {
        postMapper.insertOne(post);
        post.setCreateAt(LocalDateTime.now());
        return Result.success(post, "发表成功");
    }

    @PostMapping("/comment")
    public Result<Comment> comment(@RequestBody @Validated Comment comment) {
        commentMapper.insertOne(comment);
        comment.setCreateAt(LocalDateTime.now());
        return Result.success(comment, "评论成功");
    }


}
