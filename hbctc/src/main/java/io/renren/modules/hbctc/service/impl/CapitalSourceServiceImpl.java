package io.renren.modules.hbctc.service.impl;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.renren.modules.hbctc.dao.CapitalSourceMapper;
import io.renren.modules.hbctc.entity.CapitalSource;
import io.renren.modules.hbctc.entity.CapitalSourceExample;
import io.renren.modules.hbctc.service.CapitalSourceService;

@Service
public class CapitalSourceServiceImpl extends CapitalSourceService {

	@Autowired
	private CapitalSourceMapper capitalSourceMapper;
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public long countByExample(CapitalSourceExample example) {
		return capitalSourceMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(CapitalSourceExample example) {
		return capitalSourceMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return capitalSourceMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(CapitalSource record) {
		return capitalSourceMapper.insert(record);
	}

	@Override
	public int insertSelective(CapitalSource record) {
		return capitalSourceMapper.insertSelective(record);
	}

	@Override
	public List<CapitalSource> selectByExample(CapitalSourceExample example) {
		return capitalSourceMapper.selectByExample(example);
	}

	@Override
	public CapitalSource selectByPrimaryKey(Integer id) {
		return capitalSourceMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(CapitalSource record, CapitalSourceExample example) {
		return capitalSourceMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(CapitalSource record, CapitalSourceExample example) {
		return capitalSourceMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(CapitalSource record) {
		return capitalSourceMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(CapitalSource record) {
		return capitalSourceMapper.updateByPrimaryKey(record);
	}

	@Transactional
	@Override
	public int batchInsert(List<CapitalSource> record, int preid) {
		// 如果自动提交设置为true,将无法控制提交的条数，改为最后统一提交，可能导致内存溢出
		SqlSession session = null;
		int status = 0;
		try {
			session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
			CapitalSourceMapper mapper = session.getMapper(CapitalSourceMapper.class);
			if (record != null) {
				for (int i = 0; i < record.size(); i++) {
					record.get(i).setPreid(preid);// 设置preid
					record.get(i).setId(null);// 设置id为null
					status = mapper.insertSelective(record.get(i));
				}
			}
			// 手动提交，提交后无法回滚
			session.commit();
			// 清理缓存，防止溢出
			session.clearCache();
		} catch (Exception e) {
			// 没有提交的数据可以回滚
			session.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return status;
	}
}
