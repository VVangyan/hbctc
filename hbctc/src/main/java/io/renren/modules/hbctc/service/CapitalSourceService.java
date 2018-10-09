package io.renren.modules.hbctc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import io.renren.modules.hbctc.entity.CapitalSource;
import io.renren.modules.hbctc.entity.CapitalSourceExample;

public abstract class CapitalSourceService {
	public	abstract long countByExample(CapitalSourceExample example);

	public	abstract int deleteByExample(CapitalSourceExample example);

	public	abstract int deleteByPrimaryKey(Integer id);

	public	abstract int insert(CapitalSource record);
	
	public	abstract int batchInsert(List<CapitalSource> record,int preid);
	
	public	abstract int batchUpdate(List<CapitalSource> record,int preid);

	public	abstract int insertSelective(CapitalSource record);

	public	abstract List<CapitalSource> selectByExample(CapitalSourceExample example);

	public	abstract CapitalSource selectByPrimaryKey(Integer id);

	public	abstract int updateByExampleSelective(@Param("record") CapitalSource record,@Param("example") CapitalSourceExample example);

	public	abstract int updateByExample(@Param("record") CapitalSource record, @Param("example") CapitalSourceExample example);

	public	abstract int updateByPrimaryKeySelective(CapitalSource record);

	public	abstract int updateByPrimaryKey(CapitalSource record);
}