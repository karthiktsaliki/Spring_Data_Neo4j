package com.mroads.panna.neo4j.controller;

import java.util.List;

import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mroads.panna.neo4j.dto.SpeechToTextDTO;
import com.mroads.panna.neo4j.service.SpeechToTextService;


@Controller
@RequestMapping(value="/speechToTextService")
public class SpeechToTextController {
	ObjectMapper mapper = new ObjectMapper();
	Logger logger = LoggerFactory.getLogger(SpeechToTextController.class);	
	@Autowired
	SpeechToTextService speechToTextService;
	@ResponseBody
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public  String getTransferedTextForInterview() throws Exception{
		return "Working!!";
	}
	@ResponseBody
	@RequestMapping(value="/getTransferedTextForInterview",method=RequestMethod.POST)
	public  ResponseEntity<List<SpeechToTextDTO>> getTransferedTextForInterview(@RequestBody String inputData) throws Exception{
		JSONObject input=new JSONObject(inputData);
		Integer interviewId=input.getInt("interviewId");
		logger.info("Inside getTransferedTextForInterview for interviewId:"+interviewId);
		List<SpeechToTextDTO> speechToTextDTOList;
		speechToTextDTOList=speechToTextService.getTransferedText(interviewId);
		logger.info("Sending response for Interview Id is:"+mapper.writeValueAsString(speechToTextDTOList));		
		return new ResponseEntity<List<SpeechToTextDTO>>(speechToTextDTOList,HttpStatus.OK);
	}
}
