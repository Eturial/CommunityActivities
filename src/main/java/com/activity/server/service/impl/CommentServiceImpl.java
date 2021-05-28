package com.activity.server.service.impl;

import com.activity.server.mapper.DynamicMapper;
import com.activity.server.mapper.UserMapper;
import com.activity.server.pojo.Comment;
import com.activity.server.pojo.Dynamic;
import com.activity.server.pojo.RespBean;
import com.activity.server.service.CommentService;
import com.activity.server.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*
*/
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    DynamicMapper dynamicMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public RespBean updateComment(Comment comment, Dynamic dynamic) {

        commentMapper.addOne(comment);
        comment.setName(userMapper.getUser(dynamic.getAccount()).getName());
        commentMapper.updateName(comment);
        // 判断内容是否为空
        if(comment.getContent() != null) {
            commentMapper.updateContent(comment);
        } else{
            return RespBean.error("内容不能为空!");
        }
        commentMapper.updateAvatarUrl(comment);

        int id = dynamicMapper.selectDynamicId(dynamic).getDyId();
        comment.setDyId(id);
        commentMapper.updateDyId(comment);

        return RespBean.success("评论成功！");
    }

    @Override
    public List<Comment> getAllComment() {
        return commentMapper.getAllComment();
    }
}
