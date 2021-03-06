package com.hg.community.dao;

import com.hg.community.entry.Comment;
import com.hg.community.entry.Post;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {


    @Select("SELECT * FROM comment WHERE id = #{postId} LIMIT 5")
    List<Comment> selectAllByPostIdLimit5(int postId);

    @Select("SELECT * FROM comment WHERE id = #{postId} LIMIT #{limitP},#{limitE}")
    List<Comment> selectAllByPostId( @Param("postId")int postId, @Param("limitP")int limitP, @Param("limitE")int limitE);


    @Insert("INSERT INTO comment (content,userId,appId,postId,commentId) VALUES(#{content},#{userId},#{appId},#{postId},#{commentId})")
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn="id")
    void insertOne(Comment comment);

    @Select("SELECT * FROM comment WHERE userId = #{postId} AND appId = #{appId} LIMIT #{limitP},#{limitE}")
    List<Comment> selectAllByUserAppId(@Param("userId")int userId, @Param("appId")String appId, @Param("limitP")int limitP, @Param("limitE")int limitE);
}
