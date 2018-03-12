package io.renren.modules.hbctc.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.renren.modules.hbctc.dao.UserDepartmentMapper;
import io.renren.modules.hbctc.entity.UserDepartment;
import io.renren.modules.hbctc.entity.UserDepartmentExample;
import io.renren.modules.hbctc.service.UserDepartmentService;

@Service
public class UserDepartmentServiceImpl implements UserDepartmentService {
	@Autowired
	private UserDepartmentMapper departmentMapper;

	@Override
	public long countByExample(UserDepartmentExample example) {
		return departmentMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(UserDepartmentExample example) {
		return departmentMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return departmentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(UserDepartment record) {
		return departmentMapper.insert(record);
	}

	@Override
	public int insertSelective(UserDepartment record) {
		return departmentMapper.insertSelective(record);
	}

	@Override
	public List<UserDepartment> selectByExample(UserDepartmentExample example) {
		return departmentMapper.selectByExample(example);
	}

	@Override
	public UserDepartment selectByPrimaryKey(Integer id) {
		return departmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(UserDepartment record, UserDepartmentExample example) {
		return departmentMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(UserDepartment record, UserDepartmentExample example) {
		return departmentMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(UserDepartment record) {
		return departmentMapper.updateByPrimaryKeySelective(null);
	}

	@Override
	public int updateByPrimaryKey(UserDepartment record) {
		return departmentMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<HashMap<Object, Object>> selectMapResutl() {
		return departmentMapper.selectMapResutl();
	}

	@Override
	public HashMap<String, Object> selectIsMiddleDeptMap(Integer userid) {
		return departmentMapper.selectIsMiddleDeptMap(userid);
	}

}
