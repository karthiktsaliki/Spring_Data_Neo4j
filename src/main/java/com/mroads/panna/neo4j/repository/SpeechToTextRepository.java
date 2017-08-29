package com.mroads.panna.neo4j.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import com.mroads.panna.neo4j.model.SpeechToText;

@Repository
public interface SpeechToTextRepository extends  GraphRepository<SpeechToText>{
	public List<SpeechToText> findByInterviewId(Integer interviewId);
}
