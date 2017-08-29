package com.mroads.panna.neo4j.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mroads.panna.neo4j.dto.SpeechToTextDTO;
import com.mroads.panna.neo4j.model.SpeechToText;
import com.mroads.panna.neo4j.repository.SpeechToTextRepository;

@Service
public class SpeechToTextService {
	@Autowired
	SpeechToTextRepository speechToTextRepository;	
	Logger logger = LoggerFactory.getLogger(SpeechToTextService.class);	
	ObjectMapper mapper = new ObjectMapper();

	public List<SpeechToTextDTO> getTransferedText(Integer interviewId){
		List<SpeechToTextDTO> speechToTextDTOList=new ArrayList<>();
		try{
			System.out.println(speechToTextRepository);
			List<SpeechToText> speechToTextList =speechToTextRepository.findByInterviewId(interviewId);
			logger.info(mapper.writeValueAsString(speechToTextList));
			for(int count=0;count<speechToTextList.size();count++){
				SpeechToTextDTO speechToTextDTO=new SpeechToTextDTO();
				BeanUtils.copyProperties(speechToTextList.get(count), speechToTextDTO);
				speechToTextDTOList.add(speechToTextDTO);
			}
		}catch(Exception e){
			logger.error("Exception is",e);
		}
		return speechToTextDTOList;
	}
}
