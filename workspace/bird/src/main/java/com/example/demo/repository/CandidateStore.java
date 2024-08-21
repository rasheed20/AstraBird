package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Candidate;

public interface CandidateStore extends JpaRepository<Candidate, String>  {

}
