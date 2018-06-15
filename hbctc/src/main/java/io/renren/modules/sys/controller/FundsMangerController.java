package io.renren.modules.sys.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuxueli.poi.excel.ExcelImportUtil;

import io.renren.common.utils.FileUpload;
import io.renren.common.utils.R;
import io.renren.modules.hbctc.entity.FundFrom;
import io.renren.modules.hbctc.service.FundFromService;

/**
 * 资金来源
 * 
 * @author yan
 *
 */
@RestController
@RequestMapping("/sys/funds")
public class FundsMangerController extends AbstractController {
	@Autowired
	FundFromService fundFromService;
	
	@GetMapping("/fundsList")
	public R fundsList(@RequestParam Map<String, Object> params) {
		System.out.println("params  :" + params);

		Integer pn = Integer.parseInt(params.get("page") + "");
		PageHelper.startPage(pn, 10);
		List<FundFrom> fundList = fundFromService.selectByExample(null);
		PageInfo page = new PageInfo(fundList, 10);
		return R.ok().put("page", page);
	}
	
	@Transactional
	@PostMapping("/uploadFile")
	public R uploadEecel(HttpServletRequest request) throws IllegalStateException, IOException {
		try {
			String filePath = FileUpload.uploadFile(request);
			List<Object> fundFromList = ExcelImportUtil.importExcel(FundFrom.class, filePath);
			
			System.out.println("filePath :" + filePath);
			System.out.println("fundFromList :" + fundFromList);
			fundFromService.batchInsert(fundFromList);
		} catch (Exception e) {
			System.err.println("上传出错");
			e.printStackTrace();
		}
		return R.ok().put("msg", "上传成功！");
	}
}
