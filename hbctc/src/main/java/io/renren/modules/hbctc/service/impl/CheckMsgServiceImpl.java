package io.renren.modules.hbctc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.renren.modules.hbctc.dao.CheckMsgMapper;
import io.renren.modules.hbctc.entity.CheckMsg;
import io.renren.modules.hbctc.entity.CheckMsgExample;
import io.renren.modules.hbctc.service.CheckMsgService;

@Service
public class CheckMsgServiceImpl implements CheckMsgService {

	@Autowired
	private CheckMsgMapper checkMsgMapper;
	
	@Override
	public long countByExample(CheckMsgExample example) {
		return checkMsgMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(CheckMsgExample example) {
		return checkMsgMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return checkMsgMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(CheckMsg record) {
		return checkMsgMapper.insert(record);
	}

	@Override
	public int insertSelective(CheckMsg record) {
		return checkMsgMapper.insertSelective(record);
	}

	@Override
	public List<CheckMsg> selectByExample(CheckMsgExample example) {
		return checkMsgMapper.selectByExample(example);
	}

	@Override
	public CheckMsg selectByPrimaryKey(Integer id) {
		return checkMsgMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(CheckMsg record, CheckMsgExample example) {
		return checkMsgMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(CheckMsg record, CheckMsgExample example) {
		return checkMsgMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(CheckMsg record) {
		return checkMsgMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(CheckMsg record) {
		return checkMsgMapper.updateByPrimaryKey(record);
	}

}
