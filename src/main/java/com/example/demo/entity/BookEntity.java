package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "books")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class BookEntity {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String bookName;
    @NotBlank
    private String authorName;
    @NotBlank
    private String isbn;


}
