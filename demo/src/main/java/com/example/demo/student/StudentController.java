package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
//Specifying the path to the API endpoints
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    //autowirted will get the studentServive constant to magically injected into the function below
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    //GET API endpoints: String will return a string, list will return a Json list
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    //Api to handle POST request: writing data into the database
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    //Api to handle deleting a student
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    //API to handle update a student into the database
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);
    }

}



