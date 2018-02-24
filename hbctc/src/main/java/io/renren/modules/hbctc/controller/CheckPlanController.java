package io.renren.modules.hbctc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.renren.common.utils.R;
import io.renren.modules.hbctc.entity.CheckMsg;
import io.renren.modules.hbctc.entity.ProjectRequestForm;
import io.renren.modules.hbctc.service.CheckMsgService;
import io.renren.modules.hbctc.service.ProjectRequestFormService;
import io.renren.modules.sys.controller.AbstractController;
import io.renren.modules.sys.entity.SysUserEntity;

@RestController
public class CheckPlanController extends AbstractController {
	
	@Autowired
	private CheckMsgService checkMsgService;
	
	@Autowired
	private ProjectRequestFormService projectRequestFormService;
	
	@Transactional
	@PostMapping("/checkPlanByYWJBR")
	public R checkPlanByYWJBR(@RequestBody CheckMsg checkMsg) {
		long userid = getUserId();
		checkMsg.setUserid((int)userid);
		Integer stepstatus=checkMsg.getId();
		checkMsg.setId(null);
		System.out.println("checkMsg  :"+checkMsg);
		try {
			checkMsgService.insertSelective(checkMsg);
			
			ProjectRequestForm record=new ProjectRequestForm();
			record.setId(checkMsg.getPreid());     //preid
			record.setStepstatus(stepstatus);      //前台传入 stepStatus
			projectRequestFormService.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error("操作失败!");
		}
		return R.ok("操作成功!");
	}
	
}
