package com.acss.service;

import java.util.List;
import java.util.Map;

public interface IStudentInfoService {

	int saveStudentRecords (Map<String,Object> paramMap);
	
	List<Map<String,Object>> loadStudentRecords (Map<String,Object> paramMap);
}
