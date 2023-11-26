package com.student.student.services;

import com.student.student.dtos.StudentDTO;
import com.student.student.exceptions.RegistrationException;

public interface StudentRegistrationService {

    public void saveStudent(StudentDTO studentDTO);
    public void deleteStudent(int id);
    public StudentDTO getStudentById(int id) throws RegistrationException;
    public String updateStudent(StudentDTO studentDTO);



}
