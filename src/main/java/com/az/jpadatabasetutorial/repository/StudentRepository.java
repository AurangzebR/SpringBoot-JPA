package com.az.jpadatabasetutorial.repository;

import com.az.jpadatabasetutorial.entity.Student;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);

    //JPQL
    @Query("select s from Student s where s.emailId= ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId= ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    @Query(name = "SELECT * FROM tbl_student s.firstName from Student s where s.emailId= :emailId",
            nativeQuery = true)
    Student getStudentByEmailId(@Param("emailId") String emailId);


    @Modifying
    @Transactional
    @Query(
            value = "Update tbl_student set first_name=:firstName where email_address=:emailId",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(@Param("firstName") String firstName,@Param("emailId") String emailId);



}

