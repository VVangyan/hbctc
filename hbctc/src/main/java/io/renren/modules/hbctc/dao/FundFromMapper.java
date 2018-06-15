package io.renren.modules.hbctc.dao;

import io.renren.modules.hbctc.entity.FundFrom;
import io.renren.modules.hbctc.entity.FundFromExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FundFromMapper {
	long countByExample(FundFromExample example);

	int deleteByExample(FundFromExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(FundFrom record);

	int insertSelective(FundFrom record);

	List<FundFrom> selectByExample(FundFromExample example);

	FundFrom selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") FundFrom record, @Param("example") FundFromExample example);

	int updateByExample(@Param("record") FundFrom record, @Param("example") FundFromExample example);

	int updateByPrimaryKeySelective(FundFrom record);

	int updateByPrimaryKey(FundFrom record);
}