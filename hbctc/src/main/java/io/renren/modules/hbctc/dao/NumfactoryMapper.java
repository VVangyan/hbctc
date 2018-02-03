package io.renren.modules.hbctc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import io.renren.modules.hbctc.entity.Numfactory;
import io.renren.modules.hbctc.entity.NumfactoryExample;

@Mapper
public interface NumfactoryMapper {
    long countByExample(NumfactoryExample example);

    int deleteByExample(NumfactoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Numfactory record);

    int insertSelective(Numfactory record);

    List<Numfactory> selectByExample(NumfactoryExample example);

    Numfactory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Numfactory record, @Param("example") NumfactoryExample example);

    int updateByExample(@Param("record") Numfactory record, @Param("example") NumfactoryExample example);

    int updateByPrimaryKeySelective(Numfactory record);

    int updateByPrimaryKey(Numfactory record);
    
    Integer selectMaxBH();
}