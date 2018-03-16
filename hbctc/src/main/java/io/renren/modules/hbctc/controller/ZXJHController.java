package io.renren.modules.hbctc.controller;

import java.util.ArrayList;
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

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.renren.common.annotation.SysLog;
import io.renren.common.utils.R;
import io.renren.modules.hbctc.entity.Agency;
import io.renren.modules.hbctc.entity.BuyItemInfo;
import io.renren.modules.hbctc.entity.BuyItemInfoExample;
import io.renren.modules.hbctc.entity.CheckMsg;
import io.renren.modules.hbctc.entity.CheckMsgExample;
import io.renren.modules.hbctc.entity.Numfactory;
import io.renren.modules.hbctc.entity.ProjectRequestForm;
import io.renren.modules.hbctc.entity.ProjectRequestFormExample;
import io.renren.modules.hbctc.entity.RequestBox;
import io.renren.modules.hbctc.entity.RequestBoxExample;
import io.renren.modules.hbctc.entity.UserDepartment;
import io.renren.modules.hbctc.entity.UserDepartmentExample;
import io.renren.modules.hbctc.service.AgencyService;
import io.renren.modules.hbctc.service.BuyItemInfoService;
import io.renren.modules.hbctc.service.CheckMsgService;
import io.renren.modules.hbctc.service.FileUploadPathService;
import io.renren.modules.hbctc.service.NumfactoryService;
import io.renren.modules.hbctc.service.ProjectRequestFormService;
import io.renren.modules.hbctc.service.RequestBoxService;
import io.renren.modules.hbctc.service.UserDepartmentService;
import io.renren.modules.sys.controller.AbstractController;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserRoleService;
import io.renren.modules.sys.service.SysUserService;

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
	
	@Autowired
	UserDepartmentService userDepartmentService;
	
	@Autowired
	SysUserRoleService sysUserRoleService;	
	
	@Autowired
	SysUserService sysUserService;	
	
	@Autowired
	RequestBoxService requestBoxService;
	
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
		Long userId = getUserId();
		
		System.out.println("pn >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> : "+pn);
		PageHelper.startPage(pn, 10);

		String deptno = getUserDepartment(Integer.parseInt(getUserId()+"")).get(0).getDeptno();
		
		Long roleId = getRoleIdByUserId(userId);
		
		List<ProjectRequestForm> resultList=new ArrayList<ProjectRequestForm>();
		
		
		List<RequestBox> requestBox = getRequestBox(Integer.parseInt(userId+""));
		List idList=new ArrayList<>();
		for (RequestBox r : requestBox) {
			idList.add(r.getFromid());
		}
		resultList= getProjects(userId,idList,roleId);
		
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
								  example1.createCriteria().andIdEqualTo(id);
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
	
	@GetMapping("/getMapResult")
	public List<HashMap<Object,Object>> getMapResult(){
		List<HashMap<Object, Object>> selectMapResutlt = userDepartmentService.selectMapResutl();
		System.out.println("selectMapResutl  "+selectMapResutlt);
		return selectMapResutlt;
	}
	
	@Transactional
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/sendCheckData")
	public R sendCheckData(@RequestBody HashMap checkData){
		Integer userId = Integer.parseInt(getUserId()+"");
		Integer ztreeUserId=Integer.parseInt(checkData.get("ztreUserid")+"");
		String  ztreDeptno=(String) checkData.get("ztreDeptno");
		Integer stepstatus=  Integer.parseInt(checkData.get("stepstatus")+"");
		Integer id = Integer.parseInt(checkData.get("id")+"");
		String fromusername = getUser().getUsername();
		Long fromroleid = getRoleIdByUserId(Long.parseLong(userId+""));//接收人的 roleid
		Long toroleId = getRoleIdByUserId(Long.parseLong(ztreeUserId+""));//接收人的 roleid
		
		SysUserEntity queryObject = sysUserService.queryObject(Long.parseLong(ztreeUserId+""));
		
		HashMap tmpmap=new HashMap();
				tmpmap.put("fromid",id);
				tmpmap.put("fromuserid",userId);
				tmpmap.put("fromusername",fromusername);
				tmpmap.put("fromroleid",fromroleid);
				tmpmap.put("fromdeptno",getUserDepartment(userId).get(0).getDeptno());
				tmpmap.put("fromdeptname",getUserDepartment(userId).get(0).getDetpname());
				tmpmap.put("fromdate",new Date());
				
				tmpmap.put("touserid",ztreeUserId);
				tmpmap.put("tousername",queryObject.getUsername());
				tmpmap.put("toroleid",toroleId);
				tmpmap.put("todeptno",ztreDeptno);
				tmpmap.put("todeptname",getUserDepartment(userId).get(0).getDetpname());
				tmpmap.put("checkstatus",0);
		
		if(userId==ztreeUserId) {//不能选择自己
			return R.error("请选择正确的审批人");
		}
		//状态为0,2,4,6,8的时候(需要修改正确后)只能发送给项目负责人
		if((stepstatus==0||stepstatus==2||stepstatus==4||stepstatus==6||stepstatus==8)&&ztreDeptno.equalsIgnoreCase(getUserDepartment(userId).get(0).getDeptno())) {
			reportToLeader(id, 1);
			sendRequstToLeader(tmpmap);
		} else if (stepstatus == 3) {// 只有当状态为3的时候才能发送给 业务主管部门或者业务经办人
			// 1:业务主管部门 2:业务经办人
			HashMap getismiddledept = getismiddledept(ztreeUserId);
			Long ismiddledept = Long.parseLong(getismiddledept.get("ismiddledept")+""); 
			if (ismiddledept == 1) {
				reportToLeader(id, 13);// 业务主管部门
				sendRequstToLeader(tmpmap);
			} else if (ismiddledept == 2&&toroleId==4) {
				reportToLeader(id, 5);// 业务经办人
				sendRequstToLeader(tmpmap);
			} else {
				return R.error("请选择正确的审批人");
			}
		} else if (stepstatus == 15) {// 当状态为15可以发送给业务主管部门、项目负责人、业务经办人
			// 1:业务主管部门 2:业务经办人
			HashMap getismiddledept = getismiddledept(ztreeUserId);
			Long ismiddledept = Long.parseLong(getismiddledept.get("ismiddledept")+""); 
			if (ismiddledept == 1) {
				reportToLeader(id, 13);// 业务主管部门
				sendRequstToLeader(tmpmap);
			} else if (ismiddledept == 2&&toroleId==4) {// 业务经办人
				reportToLeader(id, 5);
				sendRequstToLeader(tmpmap);
			} else if (ztreDeptno.equalsIgnoreCase(getUserDepartment(userId).get(0).getDeptno())) {
				reportToLeader(id, 1);// 项目负责人
				sendRequstToLeader(tmpmap);
			} else {
				return R.error("请选择正确的审批人");
			}
		} else if (stepstatus == 7) {//状态为7只能发送给业务负责人审核
			// 1:业务主管部门 2:业务经办人
			HashMap getismiddledept = getismiddledept(ztreeUserId);
			Long ismiddledept = Long.parseLong(getismiddledept.get("ismiddledept")+""); 
			if(ismiddledept==2&&toroleId==6) {//业务负责人审核
				reportToLeader(id, 9);
				sendRequstToLeader(tmpmap);
			}else {
				return R.error("请选择正确的审批人");
			}
		}else if(stepstatus==1||stepstatus==5||stepstatus==9||stepstatus==13) {
			return R.error("当前状态不能申报");
		} else {
			return R.error("请选择正确的审批人");
		}
		System.out.println("selectByExample "+getUserDepartment(userId).get(0));
		System.out.println("checkData  ："+ checkData);
		return R.ok("申报成功!");
	}
	/**
	 * 获取 isMiddleDept
	 * @param ztreeUserId
	 * @return
	 */
	private  HashMap getismiddledept(Integer ztreeUserId) {
		HashMap<String, Object> selectIsMiddleDeptMap = userDepartmentService.selectIsMiddleDeptMap(ztreeUserId);
		return selectIsMiddleDeptMap;
	}
	
	/**
	 * 获取用户部门信息
	 * @param userId
	 * @return
	 */
	private List<UserDepartment> getUserDepartment(Integer userId){
		UserDepartmentExample example=new UserDepartmentExample();
		example.createCriteria().andUseridEqualTo(userId);
		return  userDepartmentService.selectByExample(example);
	}
	/**
	 * 发送审批
	 * @param id
	 * @param status
	 */
	private void reportToLeader(Integer id,Integer status) {
		ProjectRequestForm record=new ProjectRequestForm();
		record.setId(id);
		record.setStepstatus(status);
		projectRequestFormService.updateByPrimaryKeySelective(record);
	}
	/**
	 * 根据用户id 获取角色id
	 * @param userId
	 * @return
	 */
	private  Long getRoleIdByUserId(Long userId) {
		return sysUserRoleService.queryRoleIdList(userId).get(0);
	}
	
	private List<ProjectRequestForm> getProjects(Long userId,List ids,Long roleId) {
		ProjectRequestFormExample example =new ProjectRequestFormExample();
		if(roleId==2) {//项目经办人
			example.createCriteria().andUseridEqualTo(userId);// 根据用户id来过滤
		}else {
			example.createCriteria().andIdIn(ids);
		}
		return projectRequestFormService.selectSomeByExample(example);
	}
	
	private List<RequestBox> getRequestBox(Integer toUserid) {
		RequestBoxExample example=new RequestBoxExample();
		example.createCriteria().andTouseridEqualTo(toUserid);
		return requestBoxService.selectByExample(example);
	}
	
	private void sendRequstToLeader(HashMap dataMap) {
		JSONObject jo=new JSONObject(); 
		           jo.putAll(dataMap);
		RequestBox javaObject = JSONObject.toJavaObject(jo, RequestBox.class);  //map to  bean
		requestBoxService.insertSelective(javaObject);
	}
}
