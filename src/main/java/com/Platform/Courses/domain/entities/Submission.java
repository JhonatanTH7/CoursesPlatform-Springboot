package com.Platform.Courses.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "submissions")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_submission")
    private Long idSubmission;
    @Lob
    @Column(nullable = false)
    private String content;
    @Column(name = "submission_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime submissionDate;
    @Column(nullable = false)
    private BigDecimal grade;

    @ManyToOne
    @JoinColumn(name = "fk_id_assignment", referencedColumnName = "id_assignment")
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name = "fk_id_student", referencedColumnName = "id_user")
    private User student;

}
