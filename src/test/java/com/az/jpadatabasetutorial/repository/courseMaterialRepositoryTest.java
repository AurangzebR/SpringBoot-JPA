package com.az.jpadatabasetutorial.repository;

import com.az.jpadatabasetutorial.entity.Course;
import com.az.jpadatabasetutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class courseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    CourseMaterial courseMaterial= CourseMaterial.builder()
            .url("www.science.com")
            .course(Course.builder()
            .title("Science")
            .credit(3)
            .build())
            .build();

    @Test
    public void saveCourseMaterial(){
        repository.save(courseMaterial);

    }

    @Test
    public void fetchCourseMaterial(){
         Long Id= Long.valueOf(5);
         CourseMaterial courseMaterial1=repository.findById(Id).get();
        System.out.println("courseMaterial1 = " + courseMaterial1);

    }

}