package io.renren.modules.hbctc.service;

import io.renren.modules.hbctc.entity.FundFrom;
import io.renren.modules.hbctc.entity.FundFromExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface FundFromService {
	long countByExample(FundFromExample example);

	int deleteByExample(FundFromExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(FundFrom record);
	
	int batchInsert(List list);
	
	int insertSelective(FundFrom record);

	List<FundFrom> selectByExample(FundFromExample example);

	FundFrom selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") FundFrom record, @Param("example") FundFromExample example);

	int updateByExample(@Param("record") FundFrom record, @Param("example") FundFromExample example);

	int updateByPrimaryKeySelective(FundFrom record);

	int updateByPrimaryKey(FundFrom record);
}