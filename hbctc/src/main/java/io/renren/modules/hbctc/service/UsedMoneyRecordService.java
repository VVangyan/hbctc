package io.renren.modules.hbctc.service;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import io.renren.modules.hbctc.entity.UsedMoneyRecord;
import io.renren.modules.hbctc.entity.UsedMoneyRecordExample;

public interface UsedMoneyRecordService {
    long countByExample(UsedMoneyRecordExample example);

    int deleteByExample(UsedMoneyRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UsedMoneyRecord record);
    
    int batchInsert(List<UsedMoneyRecord> usedList);

    int insertSelective(UsedMoneyRecord record);

    List<UsedMoneyRecord> selectByExample(UsedMoneyRecordExample example);

    UsedMoneyRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UsedMoneyRecord record, @Param("example") UsedMoneyRecordExample example);

    int updateByExample(@Param("record") UsedMoneyRecord record, @Param("example") UsedMoneyRecordExample example);

    int updateByPrimaryKeySelective(UsedMoneyRecord record);

    int updateByPrimaryKey(UsedMoneyRecord record);
}