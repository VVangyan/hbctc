package io.renren.modules.hbctc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.renren.modules.hbctc.dao.ProjectRequestFormMapper;
import io.renren.modules.hbctc.entity.ProjectRequestForm;
import io.renren.modules.hbctc.service.ProjectRequestFormService;

@Service
public class ProjectRequestFormServiceImpl implements ProjectRequestFormService {
	
	@Autowired
	ProjectRequestFormMapper projectRequestFormMapper;
	
	@Override
	public int insertSelective(ProjectRequestForm record) {
		return projectRequestFormMapper.insertSelective(record);
	}

}
