package com.activity.server.mapper;

import com.activity.server.pojo.Dynamic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DynamicMapper {

    void addOne(@Param("dynamic") Dynamic dynamic);

    void updateContent(@Param("dynamic") Dynamic dynamic);

    void updateUrl1(@Param("dynamic") Dynamic dynamic);
    
    void updateUrl2(@Param("dynamic") Dynamic dynamic);
    
    void updateUrl3(@Param("dynamic") Dynamic dynamic);

    void updateAvatarUrl(@Param("dynamic") Dynamic dynamic);

    void updateName(@Param("dynamic") Dynamic dynamic);

    List<Dynamic> getAllDynamic();

    Dynamic selectDynamicId(@Param("dynamic") Dynamic dynamic);

    void updateThumb(@Param("dynamic") Dynamic dynamic);

    List<Dynamic> getUserDynamic(@Param("dynamic") Dynamic dynamic);

//    void updatePic3(@Param("dynamic") Dynamic dynamic);

}
