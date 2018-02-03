package io.renren.modules.hbctc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.renren.modules.hbctc.dao.AgencyMapper;
import io.renren.modules.hbctc.entity.Agency;
import io.renren.modules.hbctc.entity.AgencyExample;
import io.renren.modules.hbctc.service.AgencyService;

@Service
public class AgencyServiceImpl implements AgencyService {
	@Autowired
	AgencyMapper agencyMapper;

	@Override
	public long countByExample(AgencyExample example) {
		return agencyMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(AgencyExample example) {
		return agencyMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return agencyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Agency record) {
		return agencyMapper.insert(record);
	}

	@Override
	public int insertSelective(Agency record) {
		return agencyMapper.insertSelective(record);
	}

	@Override
	public List<Agency> selectByExample(AgencyExample example) {
		return agencyMapper.selectByExample(example);
	}

	@Override
	public Agency selectByPrimaryKey(Integer id) {
		return agencyMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(Agency record, AgencyExample example) {
		return agencyMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Agency record, AgencyExample example) {
		return agencyMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Agency record) {
		return agencyMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Agency record) {
		return agencyMapper.updateByPrimaryKey(record);
	}

}
