package com.example.test.demo.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "satellites")
@Data
public class Satellite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "satellite_id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "launch_date")
    private Date launch_date;
    @Column(name = "orbit_type")
    @Enumerated(EnumType.STRING)
    private OrbitType orbit_type;
    // @ManyToMany(mappedBy = "satellites")
    // private List<Satellite> satellites = new ArrayList<>();
}
