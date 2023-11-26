package com.student.student.repositories;


import com.student.student.entities.StudentEntity;
import org.springframework.data.repository.CrudRepository;
public interface StudentRegistrationRepository extends CrudRepository<StudentEntity , Integer>{
}
