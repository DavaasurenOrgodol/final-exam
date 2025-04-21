package com.example.test.demo.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "astronauts")
@Data
public class Astronaut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "astronaut_id")
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "years_of_experience")
    private double yearsOfExperience;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "astronaut_satellite", joinColumns = @JoinColumn(name = "astronaut_id"), inverseJoinColumns = @JoinColumn(name = "satellite_id"))
    private List<Satellite> satellites = new ArrayList<>();

}
