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


    /**
     * 帖子列表,分页
     */
    @GetMapping("/postList")
    public Result<List<Post>> postList(@RequestParam String appId,
                                       @RequestParam int page,
                                       @RequestParam int size) {
        return Result.success(postMapper.selectAllByAppId(appId,
                page * size, (page + 1) * size), "成功");
    }


    /**
     * 获取用户的帖子
     */
    @GetMapping("/postList/user")
    public Result<List<Post>> postListListByUserAppId(@RequestParam int userId,
                                                     @RequestParam String appId,
                                                     @RequestParam int page,
                                                     @RequestParam int size) {
        return Result.success(postMapper.selectAllByUserAppId(userId,appId,
                page * size, (page + 1) * size), "成功");
    }


    /**
     * 获取帖子的评论
     */
    @GetMapping("/commentList/{postId}")
    public Result<List<Comment>> commentListByPostId(@PathVariable int postId,
                                                     @RequestParam int page,
                                                     @RequestParam int size) {
        return Result.success(commentMapper.selectAllByPostId(postId,
                page * size, (page + 1) * size), "成功");
    }

    /**
     * 获取用户的评论
     */
    @GetMapping("/commentList/user")
    public Result<List<Comment>> commentListByUserAppId(@RequestParam int userId,
                                                  @RequestParam String appId,
                                                  @RequestParam int page,
                                                  @RequestParam int size) {
        return Result.success(commentMapper.selectAllByUserAppId(userId,appId,
                page * size, (page + 1) * size), "成功");
    }


    /**
     * 发帖
     */
    @PostMapping("/post")
    public Result<Post> createPost(@RequestBody @Validated Post post) {
        postMapper.insertOne(post);
        post.setCreateAt(LocalDateTime.now());
        return Result.success(post, "发表成功");
    }

    /**
     * 点赞帖子
     */
    @PostMapping("/post/good/{postId}")
    public Result postGood(@PathVariable int postId) {
        postMapper.updatePostGoodNum(postId);
        return Result.success(null, "成功");
    }


    /**
     * 讨厌帖子
     */
    @PostMapping("/post/bad/{postId}")
    public Result postBad(@PathVariable int postId) {
        postMapper.updatePostBadNum(postId);
        return Result.success(null,"成功");
    }


    /**
     * 评论
     */
    @PostMapping("/comment")
    public Result<Comment> comment(@RequestBody Comment comment){
        commentMapper.insertOne(comment);
        comment.setCreateAt(LocalDateTime.now());
        //更新帖子的评论数量
        postMapper.updatePostCommentNum(comment.getPostId());
        return Result.success(comment,"成功");
    }

}
