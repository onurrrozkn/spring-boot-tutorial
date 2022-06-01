package com.example.demoonur.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class StudentSevrvice {

    private final StudentRespository studentRespository;



    public List<Student> getStudents() {
        return studentRespository.findAll();

    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRespository
                .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRespository.save(student);

    }

    public void deletestudent(Long studentId) {
        boolean exists = studentRespository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException(
                    "student  with id"+ studentId + "does not exist");

        }
        studentRespository.deleteById(studentId);



    }

    @Transactional
    public void updateStudent(Long studentId,
                              String name,
                              String email) {
        Student student = studentRespository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id" + studentId + "does not exixst"));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRespository
                    .findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
        }
        student.setEmail(email);
    }
}
