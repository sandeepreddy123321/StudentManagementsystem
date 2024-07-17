package com.student.www.services;

import java.util.List;

import com.student.www.dto.BatchDTO;
import com.student.www.dto.BatchSaveDTO;
import com.student.www.dto.BatchUpdateDTO;

public interface BatchService {

	String addBatch(BatchSaveDTO batchSaveDTO);

	List<BatchDTO> getAllBatches();

	String updateBatch(BatchUpdateDTO batchUpdateDTO);

	boolean deleteBatch(int id);

}
