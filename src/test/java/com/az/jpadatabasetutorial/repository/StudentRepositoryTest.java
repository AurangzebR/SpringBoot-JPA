package com.az.jpadatabasetutorial.repository;

import com.az.jpadatabasetutorial.entity.Guardian;
import com.az.jpadatabasetutorial.entity.Student;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ContextConfiguration
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
    Student student = Student.builder()
            .firstName("Maaz")
            .lastName("Warraich")
            .emailId("ma@m1.com")
           // .guardianName("Shahmeer")
           // .guardianEmail("sha@s.com")
           // .guardianMobile("6768687878")
        .build();

    studentRepository.save(student);

    }
    @Test
    public void saveStudentwithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("samid")
                .email("samid@s.com")
                .mobile("37897339898789")
                .build();
        Student student = Student.builder()
                .firstName("saad")
                .lastName("Ahmad")
                .emailId("saad@sd.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
List<Student> student =
        studentRepository.findAll();
        System.out.println("student = " + student);
    }

    @Test
    public void getStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("maaz");
        System.out.println("students = " + students);
    }

    @Test
    public void getStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("aa");
        System.out.println("students = " + students);
    }
    

    @Test
    public void getStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("saad@s.com");
        System.out.println("student = " + student);
    }

    @Test
    public void getStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("saad@s.com");
        System.out.println("student = " + firstName);
    }

    @Test
    public void getStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailId("saad@s.com");
        System.out.println("student = " + student);
    } 
    @Test
    public void UpdateStudentNameByEmailId(){

        System.out.println("student = " + studentRepository.updateStudentNameByEmailId("Saad123","saad@s.com"));
    }

}