package com.example.demoonur.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "api/v1/student")
public class StudentController {

    private final StudentSevrvice studentSevrvice;

    @Autowired
    public StudentController(StudentSevrvice studentSevrvice) {
        this.studentSevrvice = studentSevrvice;
    }


    @GetMapping
    public List<Student> getStudents() {
        return studentSevrvice.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentSevrvice.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(
            @PathVariable("studentId") Long studentId) {
        studentSevrvice.deletestudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentSevrvice.updateStudent(studentId, name, email);
    }
}
