package com.acss.service.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.acss.service.IStudentInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/WEB-INF/classes/dispatcher-servlet.xml",
"classpath:/WEB-INF/classes/database-config.xml",
"classpath:/WEB-INF/classes/mapper-config.xml"})
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class TestStudentInfoService {

	private final Logger logger = Logger.getLogger(TestStudentInfoService.class);
	
	@Autowired
	IStudentInfoService studentInfoService;
	
	@Test
	public void testRetrieve() {
		List<Map<String,Object>> recordsList = studentInfoService.loadStudentRecords(null);
		logger.debug("recordsList{} : " + recordsList);
	}
	
	public void testSave() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("STUDENT_NAME", "johnrey");
		map.put("STUDENT_AGE", "45");
		map.put("STUDENT_ADDRESS", "sdfs dfs fdsf");
		logger.debug("map{} : " + map);
		
		studentInfoService.saveStudentRecords(map);
		
		// reload the record to reflect the newly added record in table
		List<Map<String,Object>> recordsList = studentInfoService.loadStudentRecords(null);
		logger.debug("recordsList{} : " + recordsList);
	}
}
