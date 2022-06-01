package com.example.demoonur.student;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@AllArgsConstructor
public class StudentController {

    private final StudentSevrvice studentSevrvice;




    @GetMapping
    public List<Student> getStudents() {
        return studentSevrvice.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentSevrvice.addNewStudent(student);
    }

    @DeleteMapping("{studentId}")
    public void deleteStudent(
            @PathVariable("studentId") Long studentId) {
        studentSevrvice.deletestudent(studentId);
    }

    @PutMapping("{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentSevrvice.updateStudent(studentId, name, email);
    }
}
