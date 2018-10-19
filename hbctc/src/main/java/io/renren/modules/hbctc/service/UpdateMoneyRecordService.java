package io.renren.modules.hbctc.service;

import io.renren.modules.hbctc.entity.UpdateMoneyRecord;
import io.renren.modules.hbctc.entity.UpdateMoneyRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpdateMoneyRecordService {
    long countByExample(UpdateMoneyRecordExample example);

    int deleteByExample(UpdateMoneyRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UpdateMoneyRecord record);

    int insertSelective(UpdateMoneyRecord record);

    List<UpdateMoneyRecord> selectByExample(UpdateMoneyRecordExample example);

    UpdateMoneyRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UpdateMoneyRecord record, @Param("example") UpdateMoneyRecordExample example);

    int updateByExample(@Param("record") UpdateMoneyRecord record, @Param("example") UpdateMoneyRecordExample example);

    int updateByPrimaryKeySelective(UpdateMoneyRecord record);

    int updateByPrimaryKey(UpdateMoneyRecord record);
}