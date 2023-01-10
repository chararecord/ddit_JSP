package kr.or.ddit.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class CalculatorController{
	@RequestMapping(method=RequestMethod.GET, value="/calculate")
	public String calForm() {
		return "cal/form";
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////// 1번
//	@RequestMapping(method=RequestMethod.POST, value="/calculate")
	public void calProcessCase1(
			@RequestParam int left
			, @RequestParam int right
			, HttpSession session
			, HttpServletResponse resp) throws StreamWriteException, DatabindException, IOException {
		int result = left + right;
		Map<String, Object> target = Collections.singletonMap("result", result);
//		1. marshalling
//		2. serialization
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), target);
		
//		session.setAttribute("result", result);
//		return "redirect:/calculate";
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////// 2번
//	@RequestMapping(method=RequestMethod.POST, value="/calculate")
	public void calProcessCase2(
			@RequestParam int left
			, @RequestParam int right
			, HttpSession session
			, OutputStream os) throws StreamWriteException, DatabindException, IOException {
		int result = left + right;
		Map<String, Object> target = Collections.singletonMap("result", result);
//		1. marshalling
//		2. serialization
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(os, target);
		
//		session.setAttribute("result", result);
//		return "redirect:/calculate";
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////// 3번
//	@RequestMapping(method=RequestMethod.POST, value="/calculate")
	@ResponseBody
	public Map<String, Object> calProcessCase3(
			@RequestParam int left
			, @RequestParam int right
			, HttpSession session
			, OutputStream os) throws StreamWriteException, DatabindException, IOException {
		int result = left + right;
		Map<String, Object> target = Collections.singletonMap("result", result);
		return target;
//		1. marshalling
//		2. serialization
		
//		session.setAttribute("result", result);
//		return "redirect:/calculate";
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////// 4번
	@RequestMapping(method=RequestMethod.POST, value="/calculate")
	@ResponseBody
	public String calProcessCase4(
			@RequestParam int left
			, @RequestParam int right
			, HttpSession session
			, Model model) throws StreamWriteException, DatabindException, IOException {
		int result = left + right;
		model.addAttribute("result", result);
		return "jsonView";
//		1. marshalling
//		2. serialization
		
//		session.setAttribute("result", result);
//		return "redirect:/calculate";
	}
}
