package io.renren.modules.hbctc.dao;

import io.renren.modules.hbctc.entity.CapitalSource;
import io.renren.modules.hbctc.entity.CapitalSourceExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CapitalSourceMapper {
    long countByExample(CapitalSourceExample example);

    int deleteByExample(CapitalSourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CapitalSource record);

    int insertSelective(CapitalSource record);

    List<CapitalSource> selectByExample(CapitalSourceExample example);

    CapitalSource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CapitalSource record, @Param("example") CapitalSourceExample example);

    int updateByExample(@Param("record") CapitalSource record, @Param("example") CapitalSourceExample example);

    int updateByPrimaryKeySelective(CapitalSource record);

    int updateByPrimaryKey(CapitalSource record);
}