package io.renren.modules.hbctc.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.renren.modules.hbctc.dao.DepartmentMapper;
import io.renren.modules.hbctc.entity.Department;
import io.renren.modules.hbctc.entity.DepartmentExample;
import io.renren.modules.hbctc.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService, Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	public long countByExample(DepartmentExample example) {
		return departmentMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(DepartmentExample example) {
		return departmentMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return departmentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Department record) {
		return departmentMapper.insert(record);
	}

	@Override
	public int insertSelective(Department record) {
		return departmentMapper.insertSelective(record);
	}

	@Override
	public List<Department> selectByExample(DepartmentExample example) {
		return departmentMapper.selectByExample(example);
	}

	@Override
	public Department selectByPrimaryKey(Integer id) {
		return departmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(Department record, DepartmentExample example) {
		return departmentMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Department record, DepartmentExample example) {
		return departmentMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Department record) {
		return departmentMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Department record) {
		return departmentMapper.updateByPrimaryKey(record);
	}

}
