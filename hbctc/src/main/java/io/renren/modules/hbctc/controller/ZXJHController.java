package io.renren.modules.hbctc.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.renren.common.utils.R;
import io.renren.modules.hbctc.entity.Agency;
import io.renren.modules.hbctc.entity.Numfactory;
import io.renren.modules.hbctc.entity.ProjectRequestForm;
import io.renren.modules.hbctc.entity.ProjectRequestFormExample;
import io.renren.modules.hbctc.service.AgencyService;
import io.renren.modules.hbctc.service.BuyItemInfoService;
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

	@GetMapping("/getAgency")
	public List<Agency> getAgency() {
		List<Agency> agencys = agencyService.selectByExample(null);
		return agencys;
	}

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

}
