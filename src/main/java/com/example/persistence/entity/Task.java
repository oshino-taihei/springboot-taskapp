package com.example.persistence.entity;

import jdk.vm.ci.meta.Local;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Task {
    @Id
    private Integer id;
    private String title;
    private String body;
    private Integer status;
    private LocalDate createdOn;
}
