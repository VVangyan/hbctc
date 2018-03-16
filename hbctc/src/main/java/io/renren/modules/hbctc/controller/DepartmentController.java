package io.renren.modules.hbctc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.renren.common.utils.R;
import io.renren.modules.hbctc.entity.Department;
import io.renren.modules.hbctc.entity.DepartmentExample;
import io.renren.modules.hbctc.service.DepartmentService;
import io.renren.modules.sys.controller.AbstractController;

@RestController
public class DepartmentController extends AbstractController {
	@Autowired
	private DepartmentService departmentService;
	
	@SuppressWarnings({"unchecked","rawtypes"})
	@GetMapping("/deptList")
	public R deptList(@RequestParam Map<String, Object> params) {
		System.out.println("params  :"+params);
		DepartmentExample example=null;
		if(params.containsKey("detpname")){			
			example=new DepartmentExample();
			example.createCriteria().andDetpnameEqualTo(params.get("detpname")+"");
		}
		
		Integer pn= Integer.parseInt(params.get("page")+"");
		PageHelper.startPage(pn, 10);
		List<Department> deptList = departmentService.selectByExample(example);
		PageInfo page = new PageInfo(deptList, 10);
		return R.ok().put("page", page);
	}
	@PostMapping("/addDept")
	public R addDept(@RequestBody Department  params) {
		//TODO
		System.out.println("paramsparamsparamsparams:  "+params);
		return R.ok();
	}
	@GetMapping("/deptDeptById/{deptId}")
	public R deptDeptById(@PathVariable("deptId") Integer deptId) {
		//TODO
		System.out.println("deptIddeptIddeptId:  "+deptId);
		Department dept = departmentService.selectByPrimaryKey(deptId);
		System.out.println("dept :"+dept);
		return R.ok().put("dept", dept);
	}
	
}

