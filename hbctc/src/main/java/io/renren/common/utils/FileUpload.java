package io.renren.common.utils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @author:yan
 * @date :2017年12月21日
 * @desc : 文件上传
 */
public class FileUpload {
	public static String uploadFile(HttpServletRequest request) throws IllegalStateException, IOException {
		String path = null;
		long startTime = System.currentTimeMillis();
		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					path = "C:/uploadExcel/" + file.getOriginalFilename();
					
					File file2 = new File(path);
				    // 如果路径不存在,则创建  
		            if (!file2.getParentFile().exists()) {  
		            	file2.getParentFile().mkdirs();  
		            }  
		            file2.createNewFile(); 
					// 上传
					file.transferTo(file2);
				}

			}

		}
		long endTime = System.currentTimeMillis();
		System.out.println("方法三的运行时间：" + String.valueOf(endTime - startTime) + "ms");
		return path;
	}

	public static boolean checkExcelExt(String ext) {
		String realExt = ext.toLowerCase();
		if (("xls".equals(realExt)) || ("xlsx".equals(realExt))) {
			return true;
		}
		return false;
	}
}
