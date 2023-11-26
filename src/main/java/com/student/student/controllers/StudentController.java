package com.student.student.controllers;

import com.student.student.dtos.StudentDTO;
import com.student.student.exceptions.RegistrationException;
import com.student.student.services.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRegistrationService studentRegistrationService;

@PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody StudentDTO studentDTO){
        System.out.println(studentDTO);
        this.studentRegistrationService.saveStudent(studentDTO);
        return new ResponseEntity<>("student trgistred successfully!!", HttpStatus.OK);
}

@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        this.studentRegistrationService.deleteStudent(id);
    return new ResponseEntity<>("student deleted successfully!!", HttpStatus.OK);
}

@PostMapping("/getStudent/{id}")
    public StudentDTO getStudent(@PathVariable Integer id) throws RegistrationException{
        return this.studentRegistrationService.getStudentById(id);
}

@PutMapping("/updateStudent")
    public String updateStudent(@RequestBody StudentDTO studentDTO) throws RegistrationException {
        System.out.println(studentDTO.getStudentid());
        System.out.println(studentDTO.getStudentname());
        return this.studentRegistrationService.updateStudent(studentDTO);
}

}
