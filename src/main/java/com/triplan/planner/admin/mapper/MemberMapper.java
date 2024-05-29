package com.triplan.planner.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface MemberMapper {
    void updateMemberGrade(Map<String, Object> params);
    void deleteMember(@Param("memId") String memId);
}

