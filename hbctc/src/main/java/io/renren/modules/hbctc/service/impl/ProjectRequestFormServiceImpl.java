package io.renren.modules.hbctc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.renren.modules.hbctc.dao.ProjectRequestFormMapper;
import io.renren.modules.hbctc.entity.ProjectRequestForm;
import io.renren.modules.hbctc.entity.ProjectRequestFormExample;
import io.renren.modules.hbctc.service.ProjectRequestFormService;

@Service
public class ProjectRequestFormServiceImpl implements ProjectRequestFormService {
	
	@Autowired
	ProjectRequestFormMapper projectRequestFormMapper;
	
	@Override
	public int insertSelective(ProjectRequestForm record) {
		return projectRequestFormMapper.insertSelective(record);
	}

	@Override
	public long countByExample(ProjectRequestFormExample example) {
		return projectRequestFormMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(ProjectRequestFormExample example) {
		return projectRequestFormMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return projectRequestFormMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ProjectRequestForm record) {
		return projectRequestFormMapper.insert(record);
	}

	@Override
	public List<ProjectRequestForm> selectByExample(ProjectRequestFormExample example) {
		return projectRequestFormMapper.selectByExample(example);
	}

	@Override
	public ProjectRequestForm selectByPrimaryKey(Integer id) {
		return projectRequestFormMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(ProjectRequestForm record, ProjectRequestFormExample example) {
		return projectRequestFormMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(ProjectRequestForm record, ProjectRequestFormExample example) {
		return projectRequestFormMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(ProjectRequestForm record) {
		return projectRequestFormMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ProjectRequestForm record) {
		return projectRequestFormMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<ProjectRequestForm> selectSomeByExample(ProjectRequestFormExample example) {
		return projectRequestFormMapper.selectSomeByExample(example);
	}

	@Override
	public int updateByExampleSimple(ProjectRequestForm record, ProjectRequestFormExample example) {
		return projectRequestFormMapper.updateByExampleSimple(record, example);
	}
}
