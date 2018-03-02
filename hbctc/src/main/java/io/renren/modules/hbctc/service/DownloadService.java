package io.renren.modules.hbctc.service;

import org.springframework.http.ResponseEntity;

public interface DownloadService {
	ResponseEntity<byte[]> download(String path,String filename) throws Exception;
}
