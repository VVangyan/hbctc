package io.renren.modules.hbctc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import io.renren.common.annotation.SysLog;
import io.renren.common.utils.R;
import io.renren.modules.hbctc.entity.CheckMsg;
import io.renren.modules.hbctc.entity.FileUploadPath;
import io.renren.modules.hbctc.entity.ProjectRequestForm;
import io.renren.modules.hbctc.entity.RequestBox;
import io.renren.modules.hbctc.entity.RequestBoxExample;
import io.renren.modules.hbctc.service.CheckMsgService;
import io.renren.modules.hbctc.service.FileUploadPathService;
import io.renren.modules.hbctc.service.ProjectRequestFormService;
import io.renren.modules.hbctc.service.RequestBoxService;
import io.renren.modules.hbctc.util.FileUpload;
import io.renren.modules.sys.controller.AbstractController;

@RestController
public class CheckPlanController extends AbstractController {
	
	@Autowired
	private CheckMsgService checkMsgService;
	
	@Autowired
	private ProjectRequestFormService projectRequestFormService;
	
	@Autowired
	private FileUploadPathService fileUploadPathService;
	
	@Autowired
	RequestBoxService requestBoxService;
	
	@SysLog("申请审批")
	@Transactional
	@PostMapping("/checkPlanByYWJBR")
	public R checkPlanByYWJBR(HttpServletRequest request) {
		long userid = getUserId();
		String checkMsgString = request.getParameter("checkMsg");//获取checkMsg
		CheckMsg checkMsg = JSON.parseObject(checkMsgString, CheckMsg.class);//解析checkMsg JSON
		
		checkMsg.setUserid((int)userid);
		Integer stepstatus=checkMsg.getId();
		checkMsg.setId(null);
		System.out.println("checkMsg  :"+checkMsg);
		try {
			
			String filePath = FileUpload.uploadFile(request);//上传 zbwj
			System.out.println("filePath :" + filePath);
			
			if(filePath!=null) {
				String fileName=filePath.split("/")[3];
				FileUploadPath record=new FileUploadPath(filePath, fileName,fileName.substring(fileName.lastIndexOf(".") + 1) , checkMsg.getPreid());
				fileUploadPathService.insertSelective(record);
			}
			
			checkMsgService.insertSelective(checkMsg);
			
			ProjectRequestForm record=new ProjectRequestForm();
			record.setId(checkMsg.getPreid());     //preid
			record.setStepstatus(stepstatus);      //前台传入 stepStatus
			projectRequestFormService.updateByPrimaryKeySelective(record);
			
			RequestBox record2=new RequestBox();
			record2.setCheckstatus(1);
			RequestBoxExample example=new RequestBoxExample();
			example.createCriteria().andFromidEqualTo(checkMsg.getPreid());
			requestBoxService.updateByExampleSelective(record2, example);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error("操作失败!");
		}
		return R.ok("操作成功!");
	}
	
}
