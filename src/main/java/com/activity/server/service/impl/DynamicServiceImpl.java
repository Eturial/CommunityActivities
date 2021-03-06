package com.activity.server.service.impl;

import com.activity.server.mapper.UserMapper;
import com.activity.server.pojo.Dynamic;
import com.activity.server.pojo.RespBean;
import com.activity.server.service.DynamicService;
import com.activity.server.mapper.DynamicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
*
*/
@Service
public class DynamicServiceImpl implements DynamicService {
    @Autowired
    DynamicMapper dynamicMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public RespBean updateDynamic(Dynamic dynamic) {

        if(dynamic.getAccount() == null) {
            return RespBean.error("null");
        }
        // 创建一条动态，存入活动号与时间
//        System.out.println(dynamic.getTime());
        dynamicMapper.addOne(dynamic);
        dynamic.setName(userMapper.getUser(dynamic.getAccount()).getName());
        dynamicMapper.updateName(dynamic);
//        System.out.println(dynamic.getTime());
        // 判断动态内容是否为空
        if(dynamic.getContent() != null) {
            dynamicMapper.updateContent(dynamic);
        } else{
            return RespBean.error("内容不能为空!");
        }

        dynamicMapper.updateAvatarUrl(dynamic);

        if(dynamic.getUrl1() != null)
            dynamicMapper.updateUrl1(dynamic);
        if(dynamic.getUrl2() != null)
            dynamicMapper.updateUrl2(dynamic);
        if(dynamic.getUrl3() != null)
            dynamicMapper.updateUrl3(dynamic);
        return RespBean.success("发布成功！");

    }

    @Override
    public List<Dynamic> getAllDynamic() {
        return dynamicMapper.getAllDynamic();
    }

    @Override
    public RespBean updateThumb(Dynamic dynamic) {
        if(dynamic.getDyId() == null)
            return RespBean.error("动态为空，点赞失败！");

        int thumb = dynamicMapper.selectById(dynamic.getDyId()).getThumb();
        dynamic.setThumb(thumb + 1);
        System.out.println(thumb + 1);
        dynamicMapper.updateThumb(dynamic);

        return RespBean.success("点赞成功！");
    }

//    @Override
//    public void updatePicture(Dynamic dynamic) {
//        dynamicMapper.updatePic3(dynamic);
//    }
//
//    // 测试
//    @Override
//    public Dynamic getDynamic() {
//        return dynamicMapper.getDynamic();
//    }
}
