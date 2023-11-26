package com.student.student.services.impl;

import com.student.student.dtos.StudentDTO;
import com.student.student.entities.StudentEntity;
import com.student.student.exceptions.RegistrationException;
import com.student.student.repositories.StudentRegistrationRepository;
import com.student.student.services.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.OptionalInt;

@Service
public class StudentRegistrationServiceImpl implements StudentRegistrationService {


    @Autowired
    public StudentRegistrationRepository studenRegistrationRepository;

    @Override
    public void saveStudent(StudentDTO studentDTO) {
        StudentEntity studentEntity = StudentEntity.builder()
                .studentname(studentDTO.getStudentname())
                .build();
       this.studenRegistrationRepository.save(studentEntity);
    }

    public void deleteStudent(int id){
        this.studenRegistrationRepository.deleteById(id);
    }


    public StudentDTO getStudentById(int id) throws RegistrationException {
        Optional<StudentEntity> student =this.studenRegistrationRepository.findById(id);
        if(!student.isPresent()){
            throw new RegistrationException("student is not found in database with id "+ id);
        }
        StudentEntity studentEntity = student.get();
        return StudentDTO.builder()
                .studentname(studentEntity.getStudentname())
                .build();


    }

    public String updateStudent(StudentDTO studentDTO){

        StudentEntity studentEntity = StudentEntity.builder()
                .studentname(studentDTO.getStudentname())
                .studentid(studentDTO.getStudentid()
        ).build();
        System.out.println(studentDTO);
        this.studenRegistrationRepository.save(studentEntity);
        return "userupdated";
    }


}
