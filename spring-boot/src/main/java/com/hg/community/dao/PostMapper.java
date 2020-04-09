package com.hg.community.dao;

import com.hg.community.entry.Comment;
import com.hg.community.entry.Post;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PostMapper {


    @Insert("INSERT INTO post (content,userId,appId) VALUES(#{content},#{userId},#{appId})")
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn="id")
    void insertOne(Post post);


    @Select("SELECT * FROM post WHERE appId = #{appId} LIMIT #{limitP},#{limitE}")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(property = "commentList",column = "id",one = @One(select = "com.hg.community.dao.CommentMapper.selectAllByPostIdLimit5")),
    })
    List<Post> selectAllByAppId(@Param("appId") String appId, @Param("limitP")int limitP, @Param("limitE")int limitE);


    @Select("SELECT * FROM post WHERE userId = #{postId} AND appId = #{appId} LIMIT #{limitP},#{limitE}")
    List<Post> selectAllByUserAppId(@Param("userId")int userId, @Param("appId")String appId, @Param("limitP")int limitP, @Param("limitE")int limitE);


}
