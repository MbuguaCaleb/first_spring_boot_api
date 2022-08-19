package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private  final  StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
     return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {

        var studentOptional =studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("email has been taken");
        }
        studentRepository.save(student);

    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            new IllegalStateException("student with id" + studentId + "does not exist");

        }
        studentRepository.deleteById(studentId);

    }

    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(()-> new IllegalStateException(
                "Student with id" + studentId + "does not Exist"
        ));


        //checking if two objects are equal
        //i use Objects.equals method
        if(name != null && name.length() > 0 && !Objects.equals(student.getName(),name)){
            System.out.println("update name");
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(),email)){
            //checking whether the email exists in the repository so that we do not have the same email twice
            Optional <Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email Taken");
            }
            System.out.println("update email");
            student.setEmail(email);
        }
    }

//    @Transactional
//    public void updateStudent(Student student, Long studentId) {
//
//        //get the student to update
//        var studentToUpdate = studentRepository.findById(studentId);
//        studentToUpdate.get().setName(student.getName());
//        studentToUpdate.get().setEmail(student.getEmail());
//
//        System.out.println("Updated successfully");
//    }
}

