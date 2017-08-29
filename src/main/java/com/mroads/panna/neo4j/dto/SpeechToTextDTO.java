package com.mroads.panna.neo4j.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Scope("prototype")
@Data
public class SpeechToTextDTO {
	Integer interviewId;
	Integer questionId;
	String text;
}
