package com.activity.server.mapper;

import com.activity.server.pojo.Dynamic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @Entity com.activity.server.pojo.Dynamic
*/
@Mapper
@Repository
public interface DynamicMapper {

    void addOne(@Param("dynamic") Dynamic dynamic);

    void updateContent(@Param("dynamic") Dynamic dynamic);

    void updateUrl1(@Param("dynamic") Dynamic dynamic);
    
    void updateUrl2(@Param("dynamic") Dynamic dynamic);
    
    void updateUrl3(@Param("dynamic") Dynamic dynamic);

    void updateAvatarUrl(@Param("dynamic") Dynamic dynamic);

    List<Dynamic> getAllDynamic();

    void updatePic3(@Param("dynamic") Dynamic dynamic);

    Dynamic getDynamic();
}
