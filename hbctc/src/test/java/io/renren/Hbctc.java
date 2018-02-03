package io.renren;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.renren.modules.hbctc.entity.BuyItemInfo;
import io.renren.modules.hbctc.entity.ProjectRequestForm;
import io.renren.modules.hbctc.service.BuyItemInfoService;
import io.renren.modules.hbctc.service.NumfactoryService;
import io.renren.modules.hbctc.service.ProjectRequestFormService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Hbctc {
	@Autowired
	ProjectRequestFormService projectRequestFormService;
	
	@Autowired
	BuyItemInfoService buyItemInfoService;
	
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
    	int batchInsert = buyItemInfoService.batchInsert(buyItemInfos);
    	System.out.println("batchInsert  :"+batchInsert);
    }

    @Autowired
    NumfactoryService numfactoryService;
    @Test
    public void getMaxBH() {
    	Integer selectMaxBH = numfactoryService.selectMaxBH();
    	System.out.println(selectMaxBH);
    }
}
