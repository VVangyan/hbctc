package io.renren.modules.hbctc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.renren.modules.hbctc.dao.NumfactoryMapper;
import io.renren.modules.hbctc.entity.Numfactory;
import io.renren.modules.hbctc.entity.NumfactoryExample;
import io.renren.modules.hbctc.service.NumfactoryService;

@Service
public class NumfactoryServiceImpl implements NumfactoryService {

	@Autowired
	NumfactoryMapper numfactoryMapper;

	@Override
	public long countByExample(NumfactoryExample example) {
		return numfactoryMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(NumfactoryExample example) {
		return numfactoryMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return numfactoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Numfactory record) {
		return numfactoryMapper.insert(record);
	}

	@Override
	public int insertSelective(Numfactory record) {
		return numfactoryMapper.insertSelective(record);
	}

	@Override
	public List<Numfactory> selectByExample(NumfactoryExample example) {
		return numfactoryMapper.selectByExample(example);
	}

	@Override
	public Numfactory selectByPrimaryKey(Integer id) {
		return numfactoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(Numfactory record, NumfactoryExample example) {
		return numfactoryMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Numfactory record, NumfactoryExample example) {
		return numfactoryMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Numfactory record) {
		return numfactoryMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Numfactory record) {
		return numfactoryMapper.updateByPrimaryKey(record);
	}

	@Override
	public Integer selectMaxBH() {
		return numfactoryMapper.selectMaxBH();
	}

}
