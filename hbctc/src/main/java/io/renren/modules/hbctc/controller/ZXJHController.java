package io.renren.modules.hbctc.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.renren.common.annotation.SysLog;
import io.renren.common.utils.R;
import io.renren.modules.hbctc.entity.Agency;
import io.renren.modules.hbctc.entity.BuyItemInfo;
import io.renren.modules.hbctc.entity.BuyItemInfoExample;
import io.renren.modules.hbctc.entity.CapitalSource;
import io.renren.modules.hbctc.entity.CapitalSourceExample;
import io.renren.modules.hbctc.entity.CheckMsg;
import io.renren.modules.hbctc.entity.CheckMsgExample;
import io.renren.modules.hbctc.entity.FundFrom;
import io.renren.modules.hbctc.entity.FundFromExample;
import io.renren.modules.hbctc.entity.Numfactory;
import io.renren.modules.hbctc.entity.ProjectRequestForm;
import io.renren.modules.hbctc.entity.ProjectRequestFormExample;
import io.renren.modules.hbctc.entity.RequestBox;
import io.renren.modules.hbctc.entity.RequestBoxExample;
import io.renren.modules.hbctc.entity.UpdateMoneyRecord;
import io.renren.modules.hbctc.entity.UsedMoneyRecord;
import io.renren.modules.hbctc.entity.UsedMoneyRecordExample;
import io.renren.modules.hbctc.entity.UserDepartment;
import io.renren.modules.hbctc.entity.UserDepartmentExample;
import io.renren.modules.hbctc.service.AgencyService;
import io.renren.modules.hbctc.service.BuyItemInfoService;
import io.renren.modules.hbctc.service.CapitalSourceService;
import io.renren.modules.hbctc.service.CheckMsgService;
import io.renren.modules.hbctc.service.FileUploadPathService;
import io.renren.modules.hbctc.service.FundFromService;
import io.renren.modules.hbctc.service.NumfactoryService;
import io.renren.modules.hbctc.service.ProjectRequestFormService;
import io.renren.modules.hbctc.service.RequestBoxService;
import io.renren.modules.hbctc.service.UpdateMoneyRecordService;
import io.renren.modules.hbctc.service.UsedMoneyRecordService;
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
	private ProjectRequestFormService projectRequestFormService;

	@Autowired
	private BuyItemInfoService buyItemInfoService;

	@Autowired
	private CapitalSourceService capitalSourceService;

	@Autowired
	private NumfactoryService numfactoryService;

	@Autowired
	private AgencyService agencyService;

	@Autowired  
	private FileUploadPathService fileUploadPathService;

	@Autowired
	private CheckMsgService checkMsgService;

	@Autowired
	private UserDepartmentService userDepartmentService;

	@Autowired
	private SysUserRoleService sysUserRoleService;	

	@Autowired
	private SysUserService sysUserService;	

	@Autowired
	private RequestBoxService requestBoxService;

	@Autowired
	private FundFromService fundFromService;

	@Autowired
	private UsedMoneyRecordService usedMoneyRecordService;

	@Autowired
	private UpdateMoneyRecordService updateMoneyRecordService;

	@SuppressWarnings("unused")
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
			//前台传入的
			List<CapitalSource> uCsList = projectRequestForm.getCapitalsourceInfos();
			boolean flag = checkFundFromMoney(uCsList);
			if(!flag) {//项目预算金额超支
				return R.error().put("msg", "申请失败!项目预算金额填写不正确!");
			}
			
			Numfactory record = new Numfactory(year, bh2);
			numfactoryService.insertSelective(record);// 插入 numFactory 表数据
			projectRequestForm.setCreatedate(new Date());
			projectRequestForm.setUpdatedate(new Date());
			projectRequestForm.setStepstatus(0);// 0,1,2,3,4,5,6,7
			projectRequestForm.setBh1(year);
			projectRequestForm.setBh2(bh2);
			int tempMoney=0;
			for(int i=0;i<projectRequestForm.getCapitalsourceInfos().size();i++) {
				tempMoney+=projectRequestForm.getCapitalsourceInfos().get(i).getPremoney();
			}
			projectRequestForm.setIsten(tempMoney>50000 ? 1:0);
			projectRequestForm.setUserid(getUserId());// 用户id。 确认身份。
		
			projectRequestFormService.insertSelective(projectRequestForm);

			Integer preid = projectRequestForm.getId();
			System.out.println("preid  :" + preid);
			buyItemInfoService.batchInsert(projectRequestForm.getBuyItemInfos(), preid);

			capitalSourceService.batchInsert(uCsList, preid);

			List<Integer> idList=new ArrayList<>();

			UsedMoneyRecord used=null;
			List<UsedMoneyRecord> usedList=new ArrayList<>();

			for(int i=0;i<uCsList.size();i++) {

				Integer csid=uCsList.get(i).getCsid();
				Double premoney=uCsList.get(i).getPremoney();
				Integer capitalSourceId = uCsList.get(i).getId();
				idList.add(csid);

				used=new UsedMoneyRecord(premoney, csid, preid,capitalSourceId);
				usedList.add(used);
			}
			usedMoneyRecordService.batchInsert(usedList);//记录已经使用的

			String strs=idList.toString().replace("[", "").replace("]", "");

			List<FundFrom> selectByIds = fundFromService.selectByIds(strs);
			List<FundFrom> newFundList=new ArrayList<>();

			for(int j=0;j<usedList.size();j++) {
				Integer csid = uCsList.get(j).getCsid();
				Double premoney = uCsList.get(j).getPremoney();
				FundFrom fundFromInDB= selectByIds.stream().filter(f->f.getId()==csid).collect(Collectors.toList()).get(0);
				Double money = fundFromInDB.getMoney();
				Double newMoney=money-premoney;//减去已经用掉的
				fundFromInDB.setDeptno(null);
				fundFromInDB.setBuyitemtype(null);
				fundFromInDB.setDetpname(null);
				fundFromInDB.setMoneyway(null);
				fundFromInDB.setMoney(newMoney);
				newFundList.add(fundFromInDB);
			}
			fundFromService.batchUpdate(newFundList);//更新
			System.out.println(uCsList);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/getReqFormList")
	public Map<String, Object> getReqFormList(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {

		Long userId = getUserId();
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<ProjectRequestForm> resultList=new ArrayList<ProjectRequestForm>();
		PageInfo page = new PageInfo(resultList, 10);

		if(1==userId) {//管理员直接返回
			resultMap.put("page", page);
			resultMap.put("resultList", resultList);
			return resultMap;
		}

		System.out.println("pn >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> : "+pn);
		PageHelper.startPage(pn, 10);

		String deptno = getUserDepartment(Integer.parseInt(getUserId()+"")).get(0).getDeptno();

		Long roleId = getRoleIdByUserId(userId);


		if(roleId==4) {//业务经办人,查询stepStatus 为11【即,业务负责人审核通过了的】
			ProjectRequestFormExample example=new ProjectRequestFormExample();
			example.or().andStepstatusEqualTo(11);
			example.or().andStepstatusEqualTo(7);
			
			resultList = projectRequestFormService.selectByExample(example);
		}else {//其它用户则普通的
			List<RequestBox> requestBox = getRequestBox(Integer.parseInt(userId+""));
			List idList=new ArrayList<>();
			for (RequestBox r : requestBox) {
				idList.add(r.getFromid());
			}
			resultList= getProjects(userId,idList,roleId);
		}
		resultMap.put("page", page);
		resultMap.put("resultList", resultList);
		return resultMap;
	}



	@GetMapping("/getReqList")
	public R list(@RequestParam Map<String, Object> params){
		Long userId = getUserId();
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		List<ProjectRequestForm> resultList=new ArrayList<ProjectRequestForm>();

		Integer pn = Integer.parseInt(params.get("page") + "");

		if(1==userId) {//管理员直接返回
			return R.error();
		}
		System.out.println("pn >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> : "+pn);
		PageHelper.startPage(pn, 10);
		String deptno = getUserDepartment(Integer.parseInt(getUserId()+"")).get(0).getDeptno();
		Long roleId = getRoleIdByUserId(userId);
		if(roleId==4) {//业务经办人,查询stepStatus 为11【即,业务负责人审核通过了的】
			ProjectRequestFormExample example=new ProjectRequestFormExample();
			example.or().andStepstatusEqualTo(11);
			example.or().andStepstatusEqualTo(7);
			
			resultList = projectRequestFormService.selectByExample(example);
		}else {//其它用户则普通的
			List<RequestBox> requestBox = getRequestBox(Integer.parseInt(userId+""));
			List idList=new ArrayList<>();
			for (RequestBox r : requestBox) {
				idList.add(r.getFromid());
			}
			resultList= getProjects(userId,idList,roleId);
		}
		PageInfo page = new PageInfo(resultList, 10);
		return R.ok().put("page", page);
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

		CapitalSourceExample example4=new CapitalSourceExample();
		example4.createCriteria().andPreidEqualTo(id);
		List<CapitalSource> capitalList = capitalSourceService.selectByExample(example4);
		projectRequestForm.setCapitalsourceInfos(capitalList);
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

	@SysLog("删除采购项目需求")
	@Transactional
	@DeleteMapping("/deleteByItemInfoById/{id}/{preid}")
	public R deleteByItemInfoById(@PathVariable("id") Integer id,@PathVariable("preid") Integer preid) {
		BuyItemInfoExample example=new BuyItemInfoExample();
		example.createCriteria().andPreidEqualTo(preid).andByintemidEqualTo(id);
		buyItemInfoService.deleteByExample(example);
		return R.ok("删除成功!");
	}

	@SysLog("删除自主采购资金来源")
	@Transactional
	@DeleteMapping("/deleteCapitalSourceById/{id}/{csid}/{projectid}")
	public R deleteCapitalSourceById(@PathVariable("id") Integer id,@PathVariable("csid") Integer csid,
			@PathVariable("projectid") Integer projectid) {

		//1.查查已经使用的钱
		CapitalSource cs = capitalSourceService.selectByPrimaryKey(id);
		Double premoney = cs.getPremoney();

		//2.查出当前可用资金
		FundFrom fundForm = fundFromService.selectByPrimaryKey(csid);
		Double newMoney = (fundForm.getMoney()+premoney);
		//3.将已用的钱加回去
		fundForm.setMoney(newMoney);
		System.out.println("newMoney csid:"+csid+",, "+newMoney);
		fundForm.setId(csid);
		fundForm.setBuyitemtype(null);
		fundForm.setDeptno(null);
		fundForm.setDetpname(null);
		fundForm.setMoneyway(null);
		fundFromService.updateByPrimaryKeySelective(fundForm);
		//4.删除已用记录
		capitalSourceService.deleteByPrimaryKey(id);

		UsedMoneyRecordExample example=new UsedMoneyRecordExample();
		example.createCriteria().andProjectIdEqualTo(projectid).andFundfromIdEqualTo(csid);
		usedMoneyRecordService.deleteByExample(example);
		return R.ok("删除成功!");
	}

	@SysLog("更新报表")
	@Transactional
	@PostMapping("/updatePorject")
	public R updatePorject(@RequestBody ProjectRequestForm projectRequestForm) {
		List<BuyItemInfo> buyItemInfos = projectRequestForm.getBuyItemInfos();
		UpdateMoneyRecord uprecord=null;
		
		System.out.println("buyItemInfos  :  "+buyItemInfos);
		System.out.println("  <<<<<<<<<::  "+projectRequestForm);
		Integer preid = projectRequestForm.getId();
		BuyItemInfoExample example=new BuyItemInfoExample();
		example.createCriteria().andPreidEqualTo(preid);
		
		List<BuyItemInfo>  hasBuyIdList= buyItemInfos.parallelStream().filter(f->f.getPreid()!=null).collect(Collectors.toList());
		List<BuyItemInfo>  noBuyIdList= buyItemInfos.parallelStream().filter(f->f.getPreid()==null).collect(Collectors.toList());

		
		long buyCount = buyItemInfoService.countByExample(example);
		
		if(!noBuyIdList.isEmpty()&&noBuyIdList.size()>0) {
			buyItemInfoService.batchInsert(noBuyIdList, preid);
		}
		if(buyCount>0) {
			//更新item
			buyItemInfoService.batchUpdate(hasBuyIdList, preid);
		}

		//更新project
		ProjectRequestFormExample proExample=new ProjectRequestFormExample();
		proExample.createCriteria().andIdEqualTo(preid);
		projectRequestForm.setUpdatedate(new Date());
		projectRequestFormService.updateByExampleSimple(projectRequestForm, proExample);


		List<CapitalSource> capitalsourceInfos = projectRequestForm.getCapitalsourceInfos();

		CapitalSourceExample cs=new CapitalSourceExample();
		cs.createCriteria().andPreidEqualTo(preid);
		
		//有id的
		List<CapitalSource> hasIdList = capitalsourceInfos.parallelStream().filter(f->f.getId()!=null).collect(Collectors.toList());
		
		//没有id的
		List<CapitalSource> noIdList = capitalsourceInfos.parallelStream().filter(f->f.getId()==null).collect(Collectors.toList());
		
		if(hasIdList.size()>0&&!hasIdList.isEmpty()) {
			boolean flag = checkUpdateFundFromMoney(hasIdList);
			if(!flag) {//项目预算金额超支
				return R.error().put("msg", "申请失败!项目预算金额填写不正确!");
			}
		}
		
		if(noIdList.size()>0&&!noIdList.isEmpty()) {
			boolean flag = checkFundFromMoney(noIdList);
			if(!flag) {//项目预算金额超支
				return R.error().put("msg", "申请失败!项目预算金额填写不正确!");
			}
			capitalSourceService.batchInsert(noIdList, preid);
		}
		

		
		long capCount = capitalSourceService.countByExample(cs);
		FundFrom record=new FundFrom();
		if(capCount>0) {

			CapitalSourceExample ocs=new CapitalSourceExample();
			ocs.createCriteria().andPreidEqualTo(preid);
			List<CapitalSource> olist = capitalSourceService.selectByExample(ocs);

			System.out.println("olist :"+olist);

			for(int k=0;k<hasIdList.size();k++) {
				Double premoney = hasIdList.get(k).getPremoney();
				Integer id = hasIdList.get(k).getId();
				Integer csid = hasIdList.get(k).getCsid();

				Integer ocsid = olist.get(k).getCsid();
				Integer oid = olist.get(k).getId();

				CapitalSource oCS = olist.parallelStream().filter(f->f.getId()==csid).collect(Collectors.toList()).get(0);

				System.out.println("capitalSource2:"+oCS);

				Integer oCsId = oCS.getCsid();
				Double oPremoney = oCS.getPremoney();

				FundFrom fd = fundFromService.selectByPrimaryKey(oCsId);

				if(premoney>(fd.getMoney()+oPremoney)) {
					//超支了
					return R.error().put("msg", "修改失败! 预算项目金额错误!");
				}
				//修改预算表的金额 start
				if(premoney>oPremoney) {
					//比原来的预算金额大,需要在预算表里面减去两者的差额
					record.setMoney(fd.getMoney()-(premoney-oPremoney));
					record.setId(oCsId);
					fundFromService.updateByPrimaryKeySelective(record);
					uprecord=new UpdateMoneyRecord(oPremoney, premoney, oCsId, preid, getUser().getUserId(), getUser().getUsername());
					updateMoneyRecordService.insertSelective(uprecord);//插入修改记录
				}
				if(premoney<oPremoney){
					//比原来的预算金额小,需要在预算表里面加上两者的差额
					record.setMoney(fd.getMoney()+(oPremoney-premoney));
					record.setId(oCsId);
					uprecord=new UpdateMoneyRecord();
					fundFromService.updateByPrimaryKeySelective(record);
					uprecord=new UpdateMoneyRecord(oPremoney, premoney, oCsId, preid, getUser().getUserId(), getUser().getUsername());
					updateMoneyRecordService.insertSelective(uprecord);//插入修改记录
				}
				//修改预算表的金额  end
				System.out.println("premoney:"+premoney+"  id:"+id+"  csid:"+csid+" preid:"+preid);
				System.out.println("ocsid:"+ocsid+" oid:	"+oid);
			}
			capitalSourceService.batchUpdate(hasIdList, preid);
		}

		System.out.println("hasIdList "+hasIdList);
		return R.ok().put("msg", "修改成功!");
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
		Long fromroleid = getRoleIdByUserId(Long.parseLong(userId+""));//发送人的 roleid
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
			reportToLeader(id, 1);// 【1】项目负责人审核中
			sendRequstToLeader(tmpmap);
		} else if (stepstatus == 3) {// 只有当状态为3的时候才能发送给 业务主管部门或者【业务经办人,改为业务负责人】
			// 1:业务主管部门 2:业务经办人
			HashMap getismiddledept = getismiddledept(ztreeUserId);
			Long ismiddledept = Long.parseLong(getismiddledept.get("ismiddledept")+""); 
			if (ismiddledept == 1) {
				reportToLeader(id, 13);// 业务主管部门审核中
				sendRequstToLeader(tmpmap);
				//} else if (ismiddledept == 2&&toroleId==4) {
			} else if (ismiddledept == 2&&toroleId==6) {
				//reportToLeader(id, 5);// 业务经办人
				reportToLeader(id, 9);// 业务负责人审核中
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
			//} else if (stepstatus == 7) {//状态为7只能发送给业务负责人审核
		} else if (stepstatus == 11) {//状态为11只能发送给业务经办人审核
			// 1:业务主管部门 2:业务经办人
			HashMap getismiddledept = getismiddledept(ztreeUserId);
			Long ismiddledept = Long.parseLong(getismiddledept.get("ismiddledept")+""); 
			//if(ismiddledept==2&&toroleId==6) {//业务负责人审核
			if(ismiddledept==2&&toroleId==4) {//业务经办人审核
				reportToLeader(id, 5);
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

	@GetMapping("/getFounds")
	public R getFounds() {
		Long userId = getUserId();
		if(1==userId) {//管理员直接返回
			return R.error().put("msg", "F");
		}
		String deptno = getUserDepartment(Integer.parseInt(getUserId()+"")).get(0).getDeptno();
		FundFromExample example=new FundFromExample();
		example.createCriteria().andDeptnoEqualTo(deptno).andMoneyGreaterThan(0.0);//资金不为0
		List<FundFrom> fundFormList=new ArrayList<FundFrom>();
		fundFormList= fundFromService.selectByExample(example);
		return R.ok().put("fundFormList", fundFormList);
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

	/**
	 * 
	 * @Title: checkFundFromMoney   
	 * @Description: 檢查是否非法錢
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	private boolean checkFundFromMoney(List<CapitalSource> uCsList) {
		List<Integer> idList = uCsList.parallelStream().map(CapitalSource::getCsid).collect(Collectors.toList());
		FundFromExample c=new FundFromExample();
		c.createCriteria().andIdIn(idList);
		//数据库中的
		List<FundFrom> selectByExample = fundFromService.selectByExample(c);
		//分组求和
		Map<Integer, DoubleSummaryStatistics> uollect = uCsList.parallelStream().collect(Collectors.groupingBy(CapitalSource::getCsid,Collectors.summarizingDouble(CapitalSource::getPremoney)));
		for(int i=0;i<selectByExample.size();i++) {
			Double dbmoney = selectByExample.get(i).getMoney();
			double sum = uollect.get(selectByExample.get(i).getId()).getSum();
			if(sum>dbmoney) {//前台穿入的錢超過預算的錢
				return false;
			}
		}
		return true; 
	}
	private boolean checkUpdateFundFromMoney(List<CapitalSource> uCsList) {
		List<Integer> idList = uCsList.parallelStream().map(CapitalSource::getId).collect(Collectors.toList());
		FundFromExample c=new FundFromExample();
		c.createCriteria().andIdIn(idList);
		//数据库中的
		List<FundFrom> selectByExample = fundFromService.selectByExample(c);
		//分组求和
		Map<Integer, DoubleSummaryStatistics> uollect = uCsList.parallelStream().collect(Collectors.groupingBy(CapitalSource::getId,Collectors.summarizingDouble(CapitalSource::getPremoney)));
		for(int i=0;i<selectByExample.size();i++) {
			Double dbmoney = selectByExample.get(i).getMoney();
			double sum = uollect.get(selectByExample.get(i).getId()).getSum();
			if(sum>dbmoney) {//前台穿入的錢超過預算的錢
				return false;
			}
		}
		return true; 
	}
}
