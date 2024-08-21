package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Candidate;
import com.example.demo.service.CandidateService;



@RestController
public class LoginCotroller {

	@Autowired
	CandidateService candidateService;
	
	@GetMapping("/")
	public String home() {
		return "hello world !!";
	}
	
	@GetMapping("/candidate")
	public ResponseEntity<?> getCandidates(){
		return  ResponseEntity.ok(candidateService.findAll());
	}
	
	@GetMapping("/candidate/{id}")
	public ResponseEntity<?> getCandidate(@PathVariable("id") String uid){
		Optional<Candidate> candidate =candidateService.findById(uid);
		
		if(candidate.isEmpty()) {
			return new ResponseEntity<>("Candidate Not Found !! ",HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(candidate.get());
	}
	
	@PostMapping("/candidate")
	public ResponseEntity<Candidate> insertCandidate(@RequestBody Candidate candidate) {
		return  ResponseEntity.ok(candidateService.save(candidate));
	}
	
	
	@DeleteMapping("/candidate/{id}")
	public HttpStatus deleteCandidate(@PathVariable String id) {
		candidateService.deleteById(id);
		return HttpStatus.NO_CONTENT;
	}
	
	@PutMapping("/candidate/{id}")
	public ResponseEntity<Candidate> editCandidate(@PathVariable String id,@RequestBody Candidate candidate) {
		Optional<Candidate> oldCandidate = candidateService.findById(id);
		if(oldCandidate.isEmpty()) {
			candidate.setUserId(id);
			return new ResponseEntity<>(candidateService.save(candidate),HttpStatus.CREATED);
		}
		Candidate old = oldCandidate.get();
		old.setPassword(isNullOrBlank(candidate.getPassword())? old.getPassword():candidate.getPassword() );
		old.setEmail(isNullOrBlank(candidate.getEmail())? old.getEmail():candidate.getEmail());
		
		return new ResponseEntity<>(candidateService.save(old),HttpStatus.OK);
	}
	
	
	  public static boolean isNullOrBlank(String str) {
	        return str == null || str.isBlank();
	    }
	
}
