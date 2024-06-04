package com.Platform.Courses.domain.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

@Entity(name = "messages")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_message")
    private Long idMessage;
    @Lob
    @Column(name = "message_content", nullable = false)
    private String messageContent;
    @Column(name = "sent_date", nullable = false)
    @CreationTimestamp
    private LocalDateTime sentDate;

    @ManyToOne
    @JoinColumn(name = "fk_id_sender", referencedColumnName = "id_user")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "fk_id_receiver", referencedColumnName = "id_user")
    private User receiver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_course", referencedColumnName = "id_course")
    private Course course;

}
