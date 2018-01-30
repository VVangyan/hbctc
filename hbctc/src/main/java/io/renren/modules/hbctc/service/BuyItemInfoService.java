package io.renren.modules.hbctc.service;

import java.util.List;

import io.renren.modules.hbctc.entity.BuyItemInfo;

public interface BuyItemInfoService {
	int insertSelective(BuyItemInfo record);
	
	int batchInsert(List<BuyItemInfo> record);
}
