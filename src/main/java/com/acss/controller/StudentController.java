package com.acss.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.acss.service.IStudentInfoService;

@Controller
public class StudentController {

	private final Logger logger = Logger.getLogger(StudentController.class);
	
	@Autowired
	IStudentInfoService studentInfoService;
	
	@RequestMapping(value = {"/Registration.htm"}, method = {RequestMethod.GET})
	public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response) {
		List<Map<String,Object>> recordsList = studentInfoService.loadStudentRecords(null);
		logger.info("recordsList{} : " + recordsList);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("recordsList", recordsList);
		
		return mv;
	}
	
	@RequestMapping(value = {"/Registration.htm"}, method = {RequestMethod.POST})
	public ModelAndView doPost(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("STUDENT_NAME", request.getParameter("STUDENT_NAME"));
		map.put("STUDENT_AGE", request.getParameter("STUDENT_AGE"));
		map.put("STUDENT_ADDRESS", request.getParameter("STUDENT_ADDRESS"));
		logger.debug("map{} : " + map);
		
		studentInfoService.saveStudentRecords(map);
		
		// reload the record to reflect the newly added record in table
		List<Map<String,Object>> recordsList = studentInfoService.loadStudentRecords(null);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("recordsList", recordsList);
		
		return mv;
	}
}
