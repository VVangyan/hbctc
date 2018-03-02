package io.renren.modules.hbctc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import io.renren.modules.hbctc.entity.FileUploadPath;
import io.renren.modules.hbctc.entity.FileUploadPathExample;

public interface FileUploadPathService {
    long countByExample(FileUploadPathExample example);

    int deleteByExample(FileUploadPathExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FileUploadPath record);

    int insertSelective(FileUploadPath record);

    List<FileUploadPath> selectByExample(FileUploadPathExample example);

    FileUploadPath selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FileUploadPath record, @Param("example") FileUploadPathExample example);

    int updateByExample(@Param("record") FileUploadPath record, @Param("example") FileUploadPathExample example);

    int updateByPrimaryKeySelective(FileUploadPath record);

    int updateByPrimaryKey(FileUploadPath record);
}