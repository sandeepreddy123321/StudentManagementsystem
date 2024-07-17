package com.student.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.www.dto.BatchDTO;
import com.student.www.dto.BatchSaveDTO;
import com.student.www.dto.BatchUpdateDTO;
import com.student.www.services.BatchService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/batch")
public class BatchController 
{
	@Autowired
	private BatchService batchService;
	
	@PostMapping(path="/save")
	public String saveBatch(@RequestBody BatchSaveDTO batchSaveDTO)
	{
		String batch=batchService.addBatch(batchSaveDTO);
		return batch;
		
	}
	
	@GetMapping("/getAllBatches")
	public List<BatchDTO>getAllBatches()
	{
		List<BatchDTO>allBatches=batchService.getAllBatches();
		return allBatches;
		
	}
	
	@PutMapping(path="/update")
	public String updateBatch(@RequestBody BatchUpdateDTO batchUpdateDTO)
	{
		String batch=batchService.updateBatch(batchUpdateDTO);
		return batch;
		
	}
	@DeleteMapping(path="/delete/{id}")
	public String deleteBatch(@PathVariable(value="id")int id)
	{
		boolean deleteBatch=batchService.deleteBatch(id);
		return "record deleted!!";
	}
}
