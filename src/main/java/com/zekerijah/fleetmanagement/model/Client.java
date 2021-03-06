package com.zekerijah.fleetmanagement.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String address;
    private String city;
    private String mobile;
    private String email;
    private String remarks;

    @ManyToOne
    @JoinColumn(name="countryid", insertable=false, updatable=false)
    private Country country;
    private Integer countryid;

    @ManyToOne
    @JoinColumn(name="regionid", insertable=false, updatable=false)
    private Region region;
    private Integer regionid;


}
