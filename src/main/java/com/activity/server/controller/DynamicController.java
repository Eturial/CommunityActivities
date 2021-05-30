package com.activity.server.controller;

import com.activity.server.pojo.Dynamic;
import com.activity.server.pojo.RespBean;
import com.activity.server.service.DynamicService;
import com.activity.server.utils.StringToTimestamp;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Controller
@RequestMapping(value = "/dynamic")
public class DynamicController {
    @Autowired
    DynamicService dynamicService;

    @PostMapping(value = "/updateDynamic")
    @ResponseBody
    // 发表一条动态
    public RespBean updateDynamic(@RequestBody JSONObject object) {
        Dynamic dynamic = new Dynamic();

        dynamic.setAccount(object.getString("account"));
        dynamic.setContent(object.getString("content"));
        dynamic.setAvatarUrl(object.getString("userimg"));
        dynamic.setTime(object.getString("time"));
        dynamic.setUrl1(object.getString("url1"));
        dynamic.setUrl2(object.getString("url2"));
        dynamic.setUrl3(object.getString("url3"));

        return dynamicService.updateDynamic(dynamic);
    }

    @GetMapping(value = "/getAllDynamic")
    @ResponseBody
    // 查看广场动态
    public List<Dynamic> getAllDynamic() {
        return dynamicService.getAllDynamic();
    }

    // 点赞功能
    @PostMapping(value = "/dynamicThumb")
    @ResponseBody
    public RespBean dynamicThumb(@RequestBody JSONObject object) {
        Dynamic dynamic = new Dynamic();

        dynamic.setDyId(object.getIntValue("dyid"));

        return dynamicService.updateThumb(dynamic);
    }

    // 测试上传图片
//    @PostMapping(value = "/pic")
//    @ResponseBody
//    public RespBean savePic(@RequestParam("file") MultipartFile file) {
//        if (file.isEmpty()) {
//            return RespBean.error("上传失败！");
//        }
//        try {
//            InputStream inputStream = file.getInputStream();
//            Dynamic dynamic = new Dynamic();
//            byte[] pic = new byte[(int) file.getSize()];
//            inputStream.read(pic);
//            dynamic.setPic3(pic);
//            dynamicService.updatePicture(dynamic);
//            return RespBean.success("上传成功！");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return RespBean.success("上传成功！");
//    }

//    @GetMapping(value="/getPhoto")
//    public void getPhotoById(final HttpServletResponse response) throws IOException {
//        Dynamic dynamic = dynamicService.getDynamic();
//        byte[] data = dynamic.getPic3();
//        response.setContentType("image/jpeg");
//        response.setCharacterEncoding("UTF-8");
//        OutputStream outputSream = response.getOutputStream();
//        InputStream in = new ByteArrayInputStream(data);
//        int len = 0;
//        byte[] buf = new byte[1024];
//        while ((len = in.read(buf, 0, 1024)) != -1) {
//            outputSream.write(buf, 0, len);
//        }
//        outputSream.close();
//    }

}
