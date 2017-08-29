package com.mroads.panna.neo4j.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;

@NodeEntity(label="speechToText")
@Data
public class SpeechToText {
	public SpeechToText(){}
	@GraphId
	Long id;
	Integer interviewId;
	Integer questionId;
	String text;
}
