package io.renren.modules.hbctc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import io.renren.common.annotation.SysLog;
import io.renren.common.utils.R;
import io.renren.modules.hbctc.entity.CheckMsg;
import io.renren.modules.hbctc.util.FileUpload;

@RestController
public class UploadController {
	/**
	 * @desc: 上传 zbwj
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@SysLog("上传文件")
	@PostMapping("/uploadFile")
	public R uploadEecel(HttpServletRequest request) throws IllegalStateException, IOException {
		
		String checkMsg = request.getParameter("checkMsg");
		System.out.println(checkMsg);
		
		CheckMsg parseObject = JSON.parseObject(checkMsg, CheckMsg.class);
		
		System.out.println(parseObject);
		
		
		String filePath = FileUpload.uploadFile(request);
		System.out.println("filePath :" + filePath);
		
		return R.ok("上传成功");
	}
}