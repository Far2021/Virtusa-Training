package com.example.Register.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Register.domain.Register;
import com.example.Register.repository.RegisterRepository;

@Service
public class StudentService {
 
	@Autowired
	private RegisterRepository repo;
	
	public List<Register> listAll(){
		return repo.findAll();
	}
	
	public void save(Register std) {
		repo.save(std);
		
	}
	
	public Register get(long id) {
		return repo.findById(id).get();
		
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
	
	
}
