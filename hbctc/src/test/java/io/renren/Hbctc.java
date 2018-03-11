package io.renren;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.renren.modules.hbctc.entity.BuyItemInfo;
import io.renren.modules.hbctc.entity.FileUploadPath;
import io.renren.modules.hbctc.entity.FileUploadPathExample;
import io.renren.modules.hbctc.entity.ProjectRequestForm;
import io.renren.modules.hbctc.entity.ProjectRequestFormExample;
import io.renren.modules.hbctc.entity.ProjectRequestFormExample.Criteria;
import io.renren.modules.hbctc.service.BuyItemInfoService;
import io.renren.modules.hbctc.service.FileUploadPathService;
import io.renren.modules.hbctc.service.NumfactoryService;
import io.renren.modules.hbctc.service.ProjectRequestFormService;
import io.renren.modules.hbctc.service.UserDepartmentService;
import io.renren.modules.sys.controller.AbstractController;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Hbctc {
	@Autowired
	ProjectRequestFormService projectRequestFormService;
	
	@Autowired
	BuyItemInfoService buyItemInfoService;
	
	
	@Autowired  
	FileUploadPathService fileUploadPathService;
	@Autowired  
	UserDepartmentService userDepartmentService;	
    @Test
    public void test() {
		ProjectRequestForm record=new ProjectRequestForm(
    			"dept", 
    			"deptPeo",
    			"deptPeoInfo", 
    			"projectName", 
    			"projectContact", 
    			"projectPeoInfo", 
    			"0", 
    			"moneyWay", 
    			200.02, 
    			100.20, 
    			100.02, 
    			"others",
    			new Date(),
    			new Date(),
    			1,
    			2,
    			2018,
    			1000
    			);
		System.out.println("插入之前："+record.getId());
		int insertSelective = projectRequestFormService.insertSelective(record);
		System.out.println("插入之后："+record.getId());
    	System.out.println("   insertSelective   :"+insertSelective);
    	
    	BuyItemInfo buyItemInfo = new BuyItemInfo(111, "buyItemName", 100, "buyItemUnit", 1000.12, "1", "0", "1", "1",record.getId());
    	BuyItemInfo buyItemInfo2 = new BuyItemInfo(222, "buyItemName1", 200, "buyItemUnit2", 2000.12, "1", "0", "1", "1",record.getId());
    	BuyItemInfo buyItemInfo3 = new BuyItemInfo(222, "buyItemName1", 200, "buyItemUnit2", 2000.12, "1", "0", "1", "1",record.getId());
    	BuyItemInfo buyItemInfo4 = new BuyItemInfo(222, "buyItemName1", 200, "buyItemUnit2", 2000.12, "1", "0", "1", "1",record.getId());
    	BuyItemInfo buyItemInfo5 = new BuyItemInfo(222, "buyItemName1", 200, "buyItemUnit2", 2000.12, "1", "0", "1", "1",record.getId());
    	BuyItemInfo buyItemInfo6 = new BuyItemInfo(222, "buyItemName1", 200, "buyItemUnit2", 2000.12, "1", "0", "1", "1",record.getId());
    	BuyItemInfo buyItemInfo7 = new BuyItemInfo(222, "buyItemName1", 200, "buyItemUnit2", 2000.12, "1", "0", "1", "1",record.getId());
    	BuyItemInfo buyItemInfo8 = new BuyItemInfo(222, "buyItemName1", 200, "buyItemUnit2", 2000.12, "1", "0", "1", "1",record.getId());
    	BuyItemInfo buyItemInfo9 = new BuyItemInfo(222, "buyItemName1", 200, "buyItemUnit2", 2000.12, "1", "0", "1", "1",record.getId());
    	BuyItemInfo buyItemInfo10 = new BuyItemInfo(222, "buyItemName1", 200, "buyItemUnit2", 2000.12, "1", "0", "1", "1",record.getId());
    	List<BuyItemInfo> buyItemInfos=Arrays.asList(
    			buyItemInfo,
    			buyItemInfo2,
    			buyItemInfo3,
    			buyItemInfo4,
    			buyItemInfo5,
    			buyItemInfo6,
    			buyItemInfo7,
    			buyItemInfo8,
    			buyItemInfo9,
    			buyItemInfo10
    			);
    	int batchInsert = buyItemInfoService.batchInsert(buyItemInfos,insertSelective);
    	System.out.println("batchInsert  :"+batchInsert);
    }

    @Autowired
    NumfactoryService numfactoryService;
    @Test
    public void getMaxBH() {
    	Integer selectMaxBH = numfactoryService.selectMaxBH();
    	System.out.println(selectMaxBH);
    }
    
    
    @Test
    public void getList() {
    	PageHelper.startPage(3, 10);
    	List<BuyItemInfo> selectByExample = buyItemInfoService.selectByExample(null);
    	System.out.println("selectByExample  :"+selectByExample);
    /**/	for (BuyItemInfo buyItemInfo : selectByExample) {
			System.out.println(buyItemInfo);
		}
    	System.out.println("-----------------------.....................,,,,,,,,>>>>>>");
    	PageInfo page=new PageInfo(selectByExample,10);
    	
    	System.out.println(page);
    }
    
    
    @Test
    public void getbyquery() {
    	ProjectRequestFormExample example=new ProjectRequestFormExample();
    	Criteria createCriteria = example.createCriteria();
    	createCriteria.andUseridEqualTo(1L);
		List<ProjectRequestForm> selectSomeByExample = projectRequestFormService.selectSomeByExample(example);
		System.out.println(selectSomeByExample);
    }
    
    
    @Test
    public void getUploadPath() {
    	FileUploadPathExample example=new FileUploadPathExample();
    	example.createCriteria().andPreidEqualTo(58);
		List<FileUploadPath> selectByExample = fileUploadPathService.selectByExample(example);
		for (FileUploadPath f : selectByExample) {
			//System.out.println(fileUploadPath);
			System.out.println(f.getFilename());
			System.out.println(f.getPath());
			System.out.println(f.getSuffix());
		}
    }
    
    @Test
    public void getMapResult() {
    	List<HashMap<Object, Object>> selectMapResutl = userDepartmentService.selectMapResutl();
    	for (HashMap<Object, Object> hashMap : selectMapResutl) {
    		System.out.println(hashMap);
		}
    }
}
