package com.student.www.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.www.entity.Batch;

public interface BatchRepo extends JpaRepository<Batch,Integer>{

}
