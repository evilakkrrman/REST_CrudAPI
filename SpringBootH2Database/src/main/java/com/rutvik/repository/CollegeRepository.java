package com.rutvik.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rutvik.entity.College;

@Repository
public interface CollegeRepository extends CrudRepository <College, Long >{

}
