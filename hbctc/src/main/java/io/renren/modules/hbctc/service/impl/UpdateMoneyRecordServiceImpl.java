package io.renren.modules.hbctc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.renren.modules.hbctc.dao.UpdateMoneyRecordMapper;
import io.renren.modules.hbctc.entity.UpdateMoneyRecord;
import io.renren.modules.hbctc.entity.UpdateMoneyRecordExample;
import io.renren.modules.hbctc.service.UpdateMoneyRecordService;

/**
 * @author yan
 * @date 2018-10-17 
 *
 */
@Service("updateMoneyRecordService")
public class UpdateMoneyRecordServiceImpl implements UpdateMoneyRecordService {

	@Autowired
	private UpdateMoneyRecordMapper mapper;
	
	@Override
	public long countByExample(UpdateMoneyRecordExample example) {
		
		return mapper.countByExample(example) ;
	}

	@Override
	public int deleteByExample(UpdateMoneyRecordExample example) {
		
		return mapper.deleteByExample(example) ;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		
		return mapper.deleteByPrimaryKey(id) ;
	}

	@Override
	public int insert(UpdateMoneyRecord record) {
		
		return mapper.insert(record) ;
	}

	@Override
	public int insertSelective(UpdateMoneyRecord record) {
		
		return mapper.insertSelective(record) ;
	}

	@Override
	public List<UpdateMoneyRecord> selectByExample(UpdateMoneyRecordExample example) {
		
		return mapper.selectByExample(example) ;
	}

	@Override
	public UpdateMoneyRecord selectByPrimaryKey(Integer id) {
		
		return mapper.selectByPrimaryKey(id) ;
	}

	@Override
	public int updateByExampleSelective(UpdateMoneyRecord record, UpdateMoneyRecordExample example) {
		
		return mapper.updateByExampleSelective(record, example) ;
	}

	@Override
	public int updateByExample(UpdateMoneyRecord record, UpdateMoneyRecordExample example) {
		
		return mapper.updateByExample(record, example) ;
	}

	@Override
	public int updateByPrimaryKeySelective(UpdateMoneyRecord record) {
		
		return mapper.updateByPrimaryKeySelective(record) ;
	}

	@Override
	public int updateByPrimaryKey(UpdateMoneyRecord record) {
		
		return mapper.updateByPrimaryKey(record) ;
	}

}
