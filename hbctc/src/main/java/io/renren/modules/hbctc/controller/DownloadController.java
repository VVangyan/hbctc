package io.renren.modules.hbctc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.renren.common.annotation.SysLog;
import io.renren.modules.hbctc.entity.FileUploadPath;
import io.renren.modules.hbctc.entity.FileUploadPathExample;
import io.renren.modules.hbctc.service.DownloadService;
import io.renren.modules.hbctc.service.FileUploadPathService;

/**
 * 文件下载
 * 
 * @author yan
 */
@Controller
public class DownloadController {

	@Autowired 
	DownloadService downloadService;
	
	@Autowired  
	FileUploadPathService fileUploadPathService;
	@SysLog("文件下载")
	@PostMapping("/download")
	public ResponseEntity<byte[]> download(@RequestParam("filepath") String filepath,@RequestParam("filename") String filename){
		ResponseEntity<byte[]> download=null;
		try {
			download = downloadService.download(filepath, filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return download;
	}

	@SysLog("获取上传文件")
	@GetMapping("/getUploadFiles")
	@ResponseBody
	public List<FileUploadPath> getUploadFiles(@RequestParam("preid") Integer preid){
		FileUploadPathExample example=new FileUploadPathExample();
		example.createCriteria().andPreidEqualTo(preid);
		List<FileUploadPath> selectByExample = fileUploadPathService.selectByExample(example);
		return selectByExample;
	}
	
}
