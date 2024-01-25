package com.rutvik.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rutvik.entity.College;
import com.rutvik.repository.CollegeRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/college")
public class CollegeController 
{
	
	@Autowired
	CollegeRepository collegeRespository;
	
	@PostMapping("/save")
	public String saveCollege(@RequestBody College college)
	{
			collegeRespository.save(college);
		return"College DAta Saved Succesfully";
			
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<College>> getCollege()
	{
		List<College> collegeList =new ArrayList<College>();
		collegeRespository.findAll().forEach(collegeList::add);
		return new ResponseEntity<List<College>>(collegeList, HttpStatus.OK);}
		
		
	
	@DeleteMapping("/delete/{id}")
	public String deleteCollegeById(@PathVariable("id")long id) {
		return"college delete succesfully with id " + id;
		
	}
	@PutMapping("put/{id}")
	public String updateCollegeByID(@PathVariable("id") long id ,@RequestBody College college ) {
		College clg =collegeRespository.findById(id).get();
		if (clg!=null) 
			{
			college.setCollegeId(id);
			collegeRespository.save(college);
			return"college details with"+id+"Updates succesfully";
		}
		else 
		{
			return"id not found";
		}
	}
	
	
}
	
	
	


