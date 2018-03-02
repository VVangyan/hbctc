package io.renren.modules.hbctc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
