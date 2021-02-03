package kr.co.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import kr.co.service.BoardService;
import kr.co.vo.BoardVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject 
	BoardService service;
	
	@RequestMapping(value = "/board/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception{
		logger.info("writeView");
	}
	
	
	
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String write(BoardVO boardVO , MultipartHttpServletRequest request) throws Exception{
		
		Map<String, Object> paramMap = getParameterMap(request);
		
		logger.info("write");
		
		service.write(boardVO);
		
		return "redirect:/";
		
	}
	
	
	
	 public static Map<String, Object> getParameterMap(HttpServletRequest request){
	        Map<String, String[]> paramMap = request.getParameterMap();
	        Map<String, Object> param = new LinkedHashMap<String, Object>();
	        Set<String> keys = paramMap.keySet();
	        return param;
	    }
	}
