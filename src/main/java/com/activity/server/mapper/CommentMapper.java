package com.activity.server.mapper;

import com.activity.server.pojo.Comment;
import com.activity.server.pojo.Dynamic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface CommentMapper {


    void addOne(@Param("comment") Comment comment);

    void updateName(@Param("comment") Comment comment);

    void updateContent(@Param("comment") Comment comment);

    void updateAvatarUrl(@Param("comment") Comment comment);

    void updateDyId(@Param("comment") Comment comment);

    List<Comment> getAllComment();
}
