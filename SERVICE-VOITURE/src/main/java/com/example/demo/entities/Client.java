package com.example.demo.entities;

import jakarta.persistence.Entity;
import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private Long id;
    private String nom;
    private Float age;


    public Long getId() {
        return id;
    }


}