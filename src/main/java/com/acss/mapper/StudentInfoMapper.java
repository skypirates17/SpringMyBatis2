package com.acss.mapper;

import java.util.List;
import java.util.Map;

public interface StudentInfoMapper {

	int insertStudentInfo(Map<String,Object> paramMap);
	
	List<Map<String,Object>> selectStudentInfo(Map<String,Object> paramMap);
}
