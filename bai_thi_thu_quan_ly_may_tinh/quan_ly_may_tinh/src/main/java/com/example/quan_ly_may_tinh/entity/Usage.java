package com.example.quan_ly_may_tinh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usage_table")
public class Usage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;

    @ManyToOne
    @JoinColumn(name = "computer_id")
    private Computer computer;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
