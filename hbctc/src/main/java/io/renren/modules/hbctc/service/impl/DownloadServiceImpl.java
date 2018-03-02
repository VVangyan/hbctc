package io.renren.modules.hbctc.service.impl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.renren.modules.hbctc.service.DownloadService;

@Service
public class DownloadServiceImpl implements DownloadService {
	@Override
	public ResponseEntity<byte[]> download(String path, String filename) throws IOException {
		// 下载文件路径
		File file = new File(path);
		HttpHeaders headers = new HttpHeaders();
		if(file.exists()) {//文件存在
			// 下载显示的文件名，解决中文名称乱码问题
			String downloadFielName = new String(filename.getBytes("UTF-8"), "iso-8859-1");
			// 通知浏览器以attachment（下载方式）打开图片
			headers.setContentDispositionFormData("attachment", downloadFielName);
			// application/octet-stream ： 二进制流数据（最常见的文件下载）。
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
		}
		return new ResponseEntity<byte[]>("<h1 style='color:red;text-align: center;'> error ,没有找到指定资源 !</h1>".getBytes("UTF-8"),headers,HttpStatus.OK);
	}
}