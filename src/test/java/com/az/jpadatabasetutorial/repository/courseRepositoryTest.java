package com.az.jpadatabasetutorial.repository;

import com.az.jpadatabasetutorial.entity.Course;
import com.az.jpadatabasetutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class courseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Test
    public void getAllCourses(){
        List<Course> courses = repository.findAll();


    }

    @Test
    public void setCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Sadaf")
                .lastName("Shaziya")
                .build();
        Course course = Course.builder()
                .title("English")
                .credit(6)
                .teacher(teacher)
                .build();
        repository.save(course);
    }

    @Test
    public void paggingCourses(){

        Pageable firstPageWithThreeCourses = PageRequest.of(1,1);
        Pageable secondPageWithTwoCOurses = PageRequest.of(2,1);
        List<Course> courses = repository.findAll(firstPageWithThreeCourses).getContent();

        System.out.println("Total Elements = " + repository.findAll(firstPageWithThreeCourses).getTotalElements());
        System.out.println("Total Pages = " + repository.findAll(firstPageWithThreeCourses).getTotalPages());
        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSort(){
        Pageable sortByTitle = PageRequest.of(1,2, Sort.by("title"));
        Pageable sortByCredit = PageRequest.of(1,2,Sort.by("credit").descending());
        Pageable sortByTitleAndCredit = PageRequest.of(1,1,Sort.by("title").descending().and(Sort.by("credit")));
        List<Course> courses = repository.findAll(sortByTitleAndCredit).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void pageThroughRepository(){
        Pageable pageable = PageRequest.of(1,2);
        List<Course> courses = repository.findByTitleContaining("D",pageable).getContent();
        System.out.println("courses = " + courses);
    }
}