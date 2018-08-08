package io.renren.modules.hbctc.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.renren.modules.hbctc.dao.FundFromMapper;
import io.renren.modules.hbctc.entity.FundFrom;
import io.renren.modules.hbctc.entity.FundFromExample;
import io.renren.modules.hbctc.service.FundFromService;

@Service
public class FundFromServiceImpl implements FundFromService {
	@Autowired
	private FundFromMapper fundFromMapper;

	@Autowired
	SqlSession sqlSession;

	@Override
	public long countByExample(FundFromExample example) {
		return fundFromMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(FundFromExample example) {
		return fundFromMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return fundFromMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(FundFrom record) {
		return fundFromMapper.insert(record);
	}

	@Override
	public int insertSelective(FundFrom record) {
		return fundFromMapper.insertSelective(record);
	}
	
	@Override
	public List<FundFrom> selectByIds(String idStrs) {
		return fundFromMapper.selectByIds(idStrs);
	}

	@Override
	public List<FundFrom> selectByExample(FundFromExample example) {
		return fundFromMapper.selectByExample(example);
	}

	@Override
	public FundFrom selectByPrimaryKey(Integer id) {
		return fundFromMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(FundFrom record, FundFromExample example) {
		return fundFromMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(FundFrom record, FundFromExample example) {
		return fundFromMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(FundFrom record) {
		return fundFromMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(FundFrom record) {
		return fundFromMapper.updateByPrimaryKey(record);
	}

	@Transactional
	@Override
	public int batchInsert(List list) {
		FundFromMapper mapper = sqlSession.getMapper(FundFromMapper.class);
		int num = 0;
		for (int i = 0; i < list.size(); i++) {
			mapper.insertSelective((FundFrom) list.get(i));
		}
		System.out.println("批量插入完成!");
		return num;
	}

	@Override
	public int batchUpdate(List<FundFrom> fundList) {
		FundFromMapper mapper = sqlSession.getMapper(FundFromMapper.class);
		int num = 0;
		for (int i = 0; i < fundList.size(); i++) {
			num=mapper.updateByPrimaryKeySelective(fundList.get(i));
		}
		System.out.println("批量更新完成!");
		return num;
	}

}
