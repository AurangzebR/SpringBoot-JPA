package com.az.jpadatabasetutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_student", uniqueConstraints = @UniqueConstraint(
        name="emailid_unique",columnNames = "email_address"
))
public class Student {


    @Id
    @SequenceGenerator(name = "Student_sequence", sequenceName = "Student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO , generator ="Student_sequence" )
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(name = "email_address",nullable = false)
    private String emailId;
    @Embedded
    private Guardian guardian;
}
