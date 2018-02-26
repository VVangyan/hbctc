package io.renren.modules.hbctc.service.impl;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.renren.modules.hbctc.dao.BuyItemInfoMapper;
import io.renren.modules.hbctc.entity.BuyItemInfo;
import io.renren.modules.hbctc.entity.BuyItemInfoExample;
import io.renren.modules.hbctc.service.BuyItemInfoService;

@Service
public class BuyItemInfoServiceImpl implements BuyItemInfoService {
	@Autowired
	BuyItemInfoMapper buyItemInfoMapper;

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insertSelective(BuyItemInfo record) {
		return buyItemInfoMapper.insertSelective(record);
	}

	@Override
	public int batchInsert(List<BuyItemInfo> record, int preid) {
		// 如果自动提交设置为true,将无法控制提交的条数，改为最后统一提交，可能导致内存溢出
		SqlSession session = null;
		int status = 0;
		try {
			session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
			BuyItemInfoMapper mapper = session.getMapper(BuyItemInfoMapper.class);
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

	@Override
	public long countByExample(BuyItemInfoExample example) {
		return buyItemInfoMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BuyItemInfoExample example) {
		return buyItemInfoMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return buyItemInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(BuyItemInfo record) {
		return buyItemInfoMapper.insert(record);
	}

	@Override
	public List<BuyItemInfo> selectByExample(BuyItemInfoExample example) {
		return buyItemInfoMapper.selectByExample(example);
	}

	@Override
	public BuyItemInfo selectByPrimaryKey(Integer id) {
		return buyItemInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(BuyItemInfo record, BuyItemInfoExample example) {
		return buyItemInfoMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BuyItemInfo record, BuyItemInfoExample example) {
		return buyItemInfoMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BuyItemInfo record) {
		return buyItemInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BuyItemInfo record) {
		return buyItemInfoMapper.updateByPrimaryKey(record);
	}

	@Override
	public int batchUpdate(List<BuyItemInfo> record, int preid) {
		int status=0;
		for(int i=0;i<record.size();i++) {
			BuyItemInfoExample example=new BuyItemInfoExample();
			BuyItemInfo buyItemInfo = record.get(i);
			example.createCriteria().andPreidEqualTo(preid).andByintemidEqualTo(buyItemInfo.getId());
			status=buyItemInfoMapper.updateByExampleSelective(buyItemInfo, example);
		}
		return status;
	}
}
