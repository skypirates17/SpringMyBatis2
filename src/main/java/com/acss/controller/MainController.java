package com.acss.controller;

import java.net.UnknownHostException;
import java.util.ArrayList;
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
public class MainController {

	private final Logger logger = Logger.getLogger(MainController.class);
	
	@Autowired
	IStudentInfoService studentInfoService;

	@RequestMapping(value = { "/index.htm" }, method = { RequestMethod.GET })
	public ModelAndView doGet(HttpServletRequest request,
			HttpServletResponse response) throws UnknownHostException {

		List<Map<String,Object>> recordsList = new ArrayList<Map<String,Object>>();
		recordsList = studentInfoService.loadStudentRecords(null);
		
		logger.info("recordsList{} : " + recordsList);
		
		return new ModelAndView("index").addObject("recordsList", recordsList);
	}
}
