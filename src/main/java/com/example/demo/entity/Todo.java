package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Task must be set")
    @Size(min = 4, message = "Task should be not less than 4 characters")
    private String task;

    @NotNull(message = "Due Date must be set")
    @FutureOrPresent(message = "Due Date must be in the present or the future")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate dueDate;

    private boolean isCompleted;
    private LocalDate dateCompleted;
    private LocalDate dateCreated;


    @PrePersist
    private void init() {
        setDateCreated(LocalDate.now());
    }
}
