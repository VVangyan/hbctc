package io.renren.modules.hbctc.service;

import io.renren.modules.hbctc.entity.RequestBox;
import io.renren.modules.hbctc.entity.RequestBoxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RequestBoxService {
    long countByExample(RequestBoxExample example);

    int deleteByExample(RequestBoxExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RequestBox record);

    int insertSelective(RequestBox record);

    List<RequestBox> selectByExample(RequestBoxExample example);

    RequestBox selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RequestBox record, @Param("example") RequestBoxExample example);

    int updateByExample(@Param("record") RequestBox record, @Param("example") RequestBoxExample example);

    int updateByPrimaryKeySelective(RequestBox record);

    int updateByPrimaryKey(RequestBox record);
}