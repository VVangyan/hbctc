/**  
 * All rights Reserved, Designed By www.blueintelligencewh.com
 * @Title:  UsedMoneyRecordServiceImpl.java   
 * @Package io.renren.modules.hbctc.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 武汉蓝智 
 * @date:   2018年8月6日 下午10:40:12   
 * @version V1.0 
 * @Copyright: 2018 www.blueintelligencewh.com Inc. All rights reserved. 
 * 注意：本内容仅限武汉蓝智科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
package io.renren.modules.hbctc.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.renren.modules.hbctc.dao.FundFromMapper;
import io.renren.modules.hbctc.dao.UsedMoneyRecordMapper;
import io.renren.modules.hbctc.entity.FundFrom;
import io.renren.modules.hbctc.entity.UsedMoneyRecord;
import io.renren.modules.hbctc.entity.UsedMoneyRecordExample;
import io.renren.modules.hbctc.service.UsedMoneyRecordService;

/**
 * @author yan
 *
 */
@Service
public class UsedMoneyRecordServiceImpl implements UsedMoneyRecordService {
	@Autowired
	UsedMoneyRecordMapper mapper;
	
	@Autowired
	SqlSession sqlSession;
	

	@Override
	public long countByExample(UsedMoneyRecordExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(UsedMoneyRecordExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(UsedMoneyRecord record) {
		return mapper.insert(record);
	}

	@Override
	public int batchInsert(List<UsedMoneyRecord> usedList) {
		UsedMoneyRecordMapper mapper = sqlSession.getMapper(UsedMoneyRecordMapper.class);
		int num = 0;
		for (int i = 0; i < usedList.size(); i++) {
			num=mapper.insertSelective(usedList.get(i));
		}
		System.out.println("批量插入完成!");
		return num;
	}
	
	
	@Override
	public int insertSelective(UsedMoneyRecord record) {
		return mapper.insertSelective(record);
	}

	@Override
	public List<UsedMoneyRecord> selectByExample(UsedMoneyRecordExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public UsedMoneyRecord selectByPrimaryKey(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(UsedMoneyRecord record, UsedMoneyRecordExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(UsedMoneyRecord record, UsedMoneyRecordExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(UsedMoneyRecord record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(UsedMoneyRecord record) {
		return mapper.updateByPrimaryKey(record);
	}
}
