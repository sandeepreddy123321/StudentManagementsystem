package com.student.www.services.IMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.www.dto.BatchDTO;
import com.student.www.dto.BatchSaveDTO;
import com.student.www.dto.BatchUpdateDTO;
import com.student.www.entity.Batch;
import com.student.www.entity.Course;
import com.student.www.repo.BatchRepo;
import com.student.www.repo.CourseRepo;
import com.student.www.services.BatchService;

@Service
public class BatchServiceIMPL implements BatchService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private BatchRepo batchRepo;

    @Override
    @Transactional
    public String addBatch(BatchSaveDTO batchSaveDTO) {
        Optional<Course> courseOptional = courseRepo.findById(batchSaveDTO.getCourseid());
        
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            Batch batch = new Batch(
                    batchSaveDTO.getBatchname(),
                    batchSaveDTO.getStartdate(),
                    course
            );
            batchRepo.save(batch);
            return batch.getBatchname();
        } else {
            // Handle the case where the course_id does not exist
            throw new IllegalArgumentException("Invalid course_id: " + batchSaveDTO.getCourseid());
        }
    }
		@Override
		public List<BatchDTO> getAllBatches() {
		    List<Batch> getBatches = batchRepo.findAll();
		    List<BatchDTO> batchDTOList = new ArrayList<>();

		    for (Batch batch : getBatches) {
		        if (batch != null) {
		            BatchDTO batchDTO = new BatchDTO(
		                batch.getBatchid(),
		                batch.getBatchname(),
		                batch.getCourse(),
		                batch.getStartdate()
		            );
		            batchDTOList.add(batchDTO);
		        } else {
		            // Log if a null batch is encountered
		            System.out.println("Encountered null batch");
		        }
		    }

		    // Log the batchDTOList to verify its contents
		    System.out.println("BatchDTO List: " + batchDTOList);

		    return batchDTOList;
		}
		@Override
		public String updateBatch(BatchUpdateDTO batchUpdateDTO) {
			// TODO Auto-generated method stub
			if(batchRepo.existsById(batchUpdateDTO.getBatchid()))
			{
				Batch batch=batchRepo.getById(batchUpdateDTO.getBatchid());
				batch.setBatchname(batchUpdateDTO.getBatchname());
				batch.setCourse(courseRepo.getById(batchUpdateDTO.getCourseid()));
				batch.setStartdate(batchUpdateDTO.getStartdate());
				batchRepo.save(batch);
				return batch.getBatchname();
			}
			else 
			{
				System.out.println("batch Id is not found");
			}
			
			return null;
		}
		@Override
		public boolean deleteBatch(int id) {
			// TODO Auto-generated method stub
			if(batchRepo.existsById(id))
			{
				batchRepo.deleteById(id);
			}
			else 
			{
				System.out.println("Student id not found!");
			}
			return false;
		}

	}
