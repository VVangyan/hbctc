package io.renren.modules.hbctc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import io.renren.modules.hbctc.entity.BuyItemInfo;
import io.renren.modules.hbctc.entity.BuyItemInfoExample;

public interface BuyItemInfoService {
    long countByExample(BuyItemInfoExample example);

    int deleteByExample(BuyItemInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BuyItemInfo record);

    int insertSelective(BuyItemInfo record);

    List<BuyItemInfo> selectByExample(BuyItemInfoExample example);

    BuyItemInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BuyItemInfo record, @Param("example") BuyItemInfoExample example);

    int updateByExample(@Param("record") BuyItemInfo record, @Param("example") BuyItemInfoExample example);

    int updateByPrimaryKeySelective(BuyItemInfo record);

    int updateByPrimaryKey(BuyItemInfo record);
	
	int batchInsert(List<BuyItemInfo> record,int preid);
	
	int batchUpdate(List<BuyItemInfo> record,int preid);
}
