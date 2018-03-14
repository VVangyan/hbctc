package io.renren.modules.hbctc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.renren.modules.hbctc.dao.RequestBoxMapper;
import io.renren.modules.hbctc.entity.RequestBox;
import io.renren.modules.hbctc.entity.RequestBoxExample;
import io.renren.modules.hbctc.service.RequestBoxService;

@Service
public class RequestBoxServiceImpl implements RequestBoxService {

	@Autowired
	private RequestBoxMapper requestBoxMapper;
	
	@Override
	public long countByExample(RequestBoxExample example) {
		return requestBoxMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(RequestBoxExample example) {
		return requestBoxMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return requestBoxMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(RequestBox record) {
		return requestBoxMapper.insert(record);
	}

	@Override
	public int insertSelective(RequestBox record) {
		return requestBoxMapper.insertSelective(record);
	}

	@Override
	public List<RequestBox> selectByExample(RequestBoxExample example) {
		return requestBoxMapper.selectByExample(example);
	}

	@Override
	public RequestBox selectByPrimaryKey(Integer id) {
		return requestBoxMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(RequestBox record, RequestBoxExample example) {
		return requestBoxMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(RequestBox record, RequestBoxExample example) {
		return requestBoxMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(RequestBox record) {
		return requestBoxMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(RequestBox record) {
		return requestBoxMapper.updateByPrimaryKey(record);
	}

}
