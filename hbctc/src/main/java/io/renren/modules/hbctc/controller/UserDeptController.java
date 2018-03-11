package io.renren.modules.hbctc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.renren.common.utils.R;
import io.renren.modules.hbctc.entity.Department;
import io.renren.modules.hbctc.entity.UserDepartment;
import io.renren.modules.hbctc.entity.UserDepartmentExample;
import io.renren.modules.hbctc.entity.UserDepartmentExample.Criteria;
import io.renren.modules.hbctc.service.DepartmentService;
import io.renren.modules.hbctc.service.UserDepartmentService;

@RestController
public class UserDeptController {
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private UserDepartmentService userDepartmentService;

	@GetMapping("/getDeptList")
	public List<Department> getDetpList() {
		return departmentService.selectByExample(null);
	}
	
	@PostMapping("/addUserDept")
	public R addUserDept(@RequestBody UserDepartment userDept) {
		
		UserDepartmentExample example=new UserDepartmentExample();
		example.createCriteria().andUseridEqualTo(userDept.getUserid());
		long countByExample = userDepartmentService.countByExample(example);
		System.out.println("countByExample :"+countByExample);
		if(countByExample>0) {
			return R.error("请不要重复添加部门");
		}
		System.out.println("userDept :"+userDept);
		userDepartmentService.insertSelective(userDept);
		return R.ok();
	}
	@PostMapping("/updateUserDept")
	public R updateUserDept(@RequestBody UserDepartment userDept) {
		UserDepartmentExample example=new UserDepartmentExample();
		example.createCriteria().andUseridEqualTo(userDept.getUserid());
		long countByExample = userDepartmentService.countByExample(example);
		if(countByExample>0) {
			userDepartmentService.updateByExampleSelective(userDept, example);
		}else {
			return R.error("当前用户还没有分配部门!");
		}
		System.out.println("update   userDept   :"+userDept);
		return R.ok();
	}
	@PostMapping("/getUserDept")
	public List<UserDepartment> getUserDept(@RequestBody Map userid) {
		System.out.println("userid "+userid);
		UserDepartmentExample example=new UserDepartmentExample();
		example.createCriteria().andUseridEqualTo(Integer.parseInt(userid.get("userid")+""));
		List<UserDepartment> selectByExample = userDepartmentService.selectByExample(example);
		return selectByExample;
	}
}
