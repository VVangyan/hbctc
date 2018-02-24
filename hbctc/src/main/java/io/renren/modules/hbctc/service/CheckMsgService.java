package io.renren.modules.hbctc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import io.renren.modules.hbctc.entity.CheckMsg;
import io.renren.modules.hbctc.entity.CheckMsgExample;

public interface CheckMsgService {
	long countByExample(CheckMsgExample example);

	int deleteByExample(CheckMsgExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(CheckMsg record);

	int insertSelective(CheckMsg record);

	List<CheckMsg> selectByExample(CheckMsgExample example);

	CheckMsg selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") CheckMsg record, @Param("example") CheckMsgExample example);

	int updateByExample(@Param("record") CheckMsg record, @Param("example") CheckMsgExample example);

	int updateByPrimaryKeySelective(CheckMsg record);

	int updateByPrimaryKey(CheckMsg record);
}