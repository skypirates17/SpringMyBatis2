package com.acss.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acss.mapper.StudentInfoMapper;
import com.acss.service.IStudentInfoService;

@Service
public class StudentInfoService implements IStudentInfoService {
	
	@Autowired
	StudentInfoMapper studentInfoMapper;
	
	@Override
	public int saveStudentRecords(Map<String,Object> paramMap) {
		int result = studentInfoMapper.insertStudentInfo(paramMap);
		return result;
	}

	@Override
	public List<Map<String,Object>> loadStudentRecords(Map<String,Object> paramMap) {
		List<Map<String,Object>> result = studentInfoMapper.selectStudentInfo(paramMap);
		return result;
	}
}
