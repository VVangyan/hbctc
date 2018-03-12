package io.renren.modules.hbctc.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import io.renren.modules.hbctc.entity.UserDepartment;
import io.renren.modules.hbctc.entity.UserDepartmentExample;

@Mapper
public interface UserDepartmentMapper {
    long countByExample(UserDepartmentExample example);

    int deleteByExample(UserDepartmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserDepartment record);

    int insertSelective(UserDepartment record);

    List<UserDepartment> selectByExample(UserDepartmentExample example);
    
    List<HashMap<Object,Object>> selectMapResutl();
    
    HashMap<String,Object> selectIsMiddleDeptMap(@Param("userid") Integer userid);

    UserDepartment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserDepartment record, @Param("example") UserDepartmentExample example);

    int updateByExample(@Param("record") UserDepartment record, @Param("example") UserDepartmentExample example);

    int updateByPrimaryKeySelective(UserDepartment record);

    int updateByPrimaryKey(UserDepartment record);
}