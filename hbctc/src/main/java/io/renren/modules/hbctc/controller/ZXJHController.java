package io.renren.modules.hbctc.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.renren.common.annotation.SysLog;
import io.renren.common.utils.R;
import io.renren.modules.hbctc.entity.Agency;
import io.renren.modules.hbctc.entity.BuyItemInfo;
import io.renren.modules.hbctc.entity.BuyItemInfoExample;
import io.renren.modules.hbctc.entity.CheckMsg;
import io.renren.modules.hbctc.entity.CheckMsgExample;
import io.renren.modules.hbctc.entity.FileUploadPath;
import io.renren.modules.hbctc.entity.FileUploadPathExample;
import io.renren.modules.hbctc.entity.Numfactory;
import io.renren.modules.hbctc.entity.ProjectRequestForm;
import io.renren.modules.hbctc.entity.ProjectRequestFormExample;
import io.renren.modules.hbctc.service.AgencyService;
import io.renren.modules.hbctc.service.BuyItemInfoService;
import io.renren.modules.hbctc.service.CheckMsgService;
import io.renren.modules.hbctc.service.FileUploadPathService;
import io.renren.modules.hbctc.service.NumfactoryService;
import io.renren.modules.hbctc.service.ProjectRequestFormService;
import io.renren.modules.sys.controller.AbstractController;

/**
 * @Description:执行计划controller
 * @date: 2018-01-24
 * @author: yan
 */
@RestController
public class ZXJHController extends AbstractController {

	@Autowired
	ProjectRequestFormService projectRequestFormService;

	@Autowired
	BuyItemInfoService buyItemInfoService;

	@Autowired
	NumfactoryService numfactoryService;

	@Autowired
	AgencyService agencyService;
	
	@Autowired  
	FileUploadPathService fileUploadPathService;
	
	@Autowired
	CheckMsgService checkMsgService;
	
	@SysLog("提交申请")
	@Transactional
	@PostMapping("/project")
	public R info(@RequestBody ProjectRequestForm projectRequestForm) {
		Integer bh2 = 0;
		int year = Calendar.getInstance().get(Calendar.YEAR);
		synchronized (this) {
			bh2 = numfactoryService.selectMaxBH();
		}
		if (bh2 == null) {// 初始没有数据的时候
			bh2 = 1000;
		} else {
			bh2 += 1;
		}
		try {
			Numfactory record = new Numfactory(year, bh2);
			numfactoryService.insertSelective(record);// 插入 numFactory 表数据
			projectRequestForm.setCreatedate(new Date());
			projectRequestForm.setUpdatedate(new Date());
			projectRequestForm.setStepstatus(0);// 0,1,2,3,4,5,6,7
			projectRequestForm.setBh1(year);
			projectRequestForm.setBh2(bh2);
			projectRequestForm.setIsten(projectRequestForm.getPremoney()>=100000 ? 1:0);
			projectRequestForm.setUserid(getUserId());// 用户id。 确认身份。
			projectRequestFormService.insertSelective(projectRequestForm);

			Integer preid = projectRequestForm.getId();
			System.out.println("preid  :" + preid);
			buyItemInfoService.batchInsert(projectRequestForm.getBuyItemInfos(), preid);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error(0, "申请失败");
		}
		return R.ok();
	}

	@SysLog("获取代理机构")
	@GetMapping("/getAgency")
	public List<Agency> getAgency() {
		List<Agency> agencys = agencyService.selectByExample(null);
		return agencys;
	}
	@SysLog("获取报表数据")
	@SuppressWarnings("unchecked")
	@GetMapping("/getReqFormList")
	public Map<String, Object> getReqFormList(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		System.out.println("pn >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> : "+pn);
		PageHelper.startPage(pn, 10);
		ProjectRequestFormExample example=new ProjectRequestFormExample();
		example.createCriteria().andUseridEqualTo(getUserId());//根据用户id来过滤
		List<ProjectRequestForm> resultList = projectRequestFormService.selectSomeByExample(example);

		@SuppressWarnings("rawtypes")
		PageInfo page = new PageInfo(resultList, 10);
		resultMap.put("page", page);
		resultMap.put("resultList", resultList);
		return resultMap;
	}
	
	@SysLog("获取详情")
	@Transactional
	@GetMapping("/getDetails")
	public ProjectRequestForm getDetails(Integer id) {
		ProjectRequestFormExample example1 =new ProjectRequestFormExample();
								  example1.createCriteria().andIdEqualTo(id).andUseridEqualTo(getUserId());
		List<ProjectRequestForm> selectByExample1 = projectRequestFormService.selectByExample(example1);
		BuyItemInfoExample example2=new BuyItemInfoExample();
						   example2.createCriteria().andPreidEqualTo(id);
		List<BuyItemInfo> selectByExample2 = buyItemInfoService.selectByExample(example2);
		ProjectRequestForm projectRequestForm = selectByExample1.get(0);
		projectRequestForm.setBuyItemInfos(selectByExample2);
		
		CheckMsgExample example3=new CheckMsgExample();
						example3.createCriteria().andPreidEqualTo(id);
		List<CheckMsg> clist = checkMsgService.selectByExample(example3);
		projectRequestForm.setClist(clist);

		return projectRequestForm;
	}
	@SysLog("删除清单元素")
	@Transactional
	@DeleteMapping("/delItemById/{id}/{stepstatus}")
	public R delItemById(@PathVariable("id") Integer id,@PathVariable("stepstatus") Integer stepstatus) {
		if(stepstatus==0) {//0  初始状态下的才能删除
			BuyItemInfoExample b1=new BuyItemInfoExample();
			b1.createCriteria().andPreidEqualTo(id);
			buyItemInfoService.deleteByExample(b1);
			projectRequestFormService.deleteByPrimaryKey(id);
			return R.ok("删除成功");
		}
		return R.error(1, "当前状态下不能删除");
	}
	@SysLog("申报")
	@Transactional
	@PostMapping("/requestToLeader/{id}/{stepstatus}")
	public R requestToLeader(@PathVariable("id") Integer id,@PathVariable("stepstatus") Integer stepstatus) {
		if(stepstatus==0||stepstatus==2) {//0  初始状态, 2项目负责人未通过
			ProjectRequestForm record=new ProjectRequestForm();
			record.setId(id);
			record.setStepstatus(1);
			projectRequestFormService.updateByPrimaryKeySelective(record);
			return R.ok("申报成功!");
		}
		return R.error(1, "当前状态下不能申报!");
	}
	
	@SysLog("删除申报表")
	@Transactional
	@DeleteMapping("/deleteByItemInfoById/{id}/{preid}")
	public R deleteByItemInfoById(@PathVariable("id") Integer id,@PathVariable("preid") Integer preid) {
		BuyItemInfoExample example=new BuyItemInfoExample();
		example.createCriteria().andPreidEqualTo(preid).andByintemidEqualTo(id);
		buyItemInfoService.deleteByExample(example);
		return R.ok("删除成功!");
	}
	
	@SysLog("更新报表")
	@Transactional
	@PostMapping("/updatePorject")
	public R updatePorject(@RequestBody ProjectRequestForm projectRequestForm) {
		List<BuyItemInfo> buyItemInfos = projectRequestForm.getBuyItemInfos();
		
		System.out.println("buyItemInfos  :  "+buyItemInfos);
		System.out.println("  <<<<<<<<<::  "+projectRequestForm);
		Integer preid = projectRequestForm.getId();
		BuyItemInfoExample example=new BuyItemInfoExample();
		example.createCriteria().andPreidEqualTo(preid);
		long countByExample = buyItemInfoService.countByExample(example);
		if(countByExample>0) {
			//更新item
			buyItemInfoService.batchUpdate(buyItemInfos, preid);
		}else {//若没有一条记录说明全部删光了。
			buyItemInfoService.batchInsert(buyItemInfos, preid);
		}
		
		//更新project
		ProjectRequestFormExample proExample=new ProjectRequestFormExample();
		proExample.createCriteria().andIdEqualTo(preid);
		projectRequestForm.setUpdatedate(new Date());
		projectRequestFormService.updateByExampleSimple(projectRequestForm, proExample);
		
		return R.ok();
	}
}
