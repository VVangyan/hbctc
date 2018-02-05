package io.renren.modules.hbctc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import io.renren.modules.hbctc.entity.ProjectRequestForm;
import io.renren.modules.hbctc.entity.ProjectRequestFormExample;

public interface ProjectRequestFormService {
    long countByExample(ProjectRequestFormExample example);

    int deleteByExample(ProjectRequestFormExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectRequestForm record);

    int insertSelective(ProjectRequestForm record);

    List<ProjectRequestForm> selectByExample(ProjectRequestFormExample example);
    
    List<ProjectRequestForm> selectSomeByExample(ProjectRequestFormExample example);
    
    ProjectRequestForm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectRequestForm record, @Param("example") ProjectRequestFormExample example);

    int updateByExample(@Param("record") ProjectRequestForm record, @Param("example") ProjectRequestFormExample example);

    int updateByPrimaryKeySelective(ProjectRequestForm record);

    int updateByPrimaryKey(ProjectRequestForm record);
}
