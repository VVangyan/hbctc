package io.renren.modules.hbctc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.renren.modules.hbctc.dao.FileUploadPathMapper;
import io.renren.modules.hbctc.entity.FileUploadPath;
import io.renren.modules.hbctc.entity.FileUploadPathExample;
import io.renren.modules.hbctc.service.FileUploadPathService;

@Service
public class FileUploadPathServiceImpl implements FileUploadPathService {

	@Autowired
	private FileUploadPathMapper fileUploadPathMapper;
	
	@Override
	public long countByExample(FileUploadPathExample example) {
		return fileUploadPathMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(FileUploadPathExample example) {
		return fileUploadPathMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return fileUploadPathMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(FileUploadPath record) {
		return fileUploadPathMapper.insert(record);
	}

	@Override
	public int insertSelective(FileUploadPath record) {
		return fileUploadPathMapper.insertSelective(record);
	}

	@Override
	public List<FileUploadPath> selectByExample(FileUploadPathExample example) {
		return fileUploadPathMapper.selectByExample(example);
	}

	@Override
	public FileUploadPath selectByPrimaryKey(Integer id) {
		return fileUploadPathMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(FileUploadPath record, FileUploadPathExample example) {
		return fileUploadPathMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(FileUploadPath record, FileUploadPathExample example) {
		return fileUploadPathMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(FileUploadPath record) {
		return fileUploadPathMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(FileUploadPath record) {
		return fileUploadPathMapper.updateByPrimaryKey(record);
	}

}
