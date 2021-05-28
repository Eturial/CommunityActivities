package com.activity.server.service;

import com.activity.server.pojo.Dynamic;
import com.activity.server.pojo.RespBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
*
*/
public interface DynamicService {

    RespBean updateDynamic(Dynamic dynamic);

    List<Dynamic> getAllDynamic();

    RespBean updateThumb(Dynamic dynamic);

//    void updatePicture(Dynamic dynamic);

    // 测试
//    Dynamic getDynamic();
}
