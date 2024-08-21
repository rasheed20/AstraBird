package com.example.demo.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Candidate;
import com.example.demo.repository.CandidateStore;

@Service
public class CandidateService {

	private final CandidateStore candidateStore;
	
	
	@Autowired
	public CandidateService( CandidateStore candidateStore) {
		this.candidateStore = candidateStore;
	}
	
	public Iterable<Candidate> findAll() {
		return candidateStore.findAll();
	}

	public Optional<Candidate> findById(String id) {
		return candidateStore.findById(id);
	}

	public Candidate save(Candidate candidate) {
		if(candidate.getUserId()== null) {			
			candidate.setUserId(UUID.randomUUID().toString());
		}
		candidate.setLastLogin(System.currentTimeMillis());
		System.out.println(candidate.toString());
		return candidateStore.save(candidate);
	}
	
	public void deleteById(String id) {
		candidateStore.deleteById(id);
	}

}
