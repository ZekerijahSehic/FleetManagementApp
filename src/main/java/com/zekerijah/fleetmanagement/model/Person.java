package com.zekerijah.fleetmanagement.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstname;
    private String lastname;
    private String gender;
    private String maritalStatus;
    private String city;
    private String address;
    private String mobile;
    private String email;
    private String photo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name="countryid", insertable=false, updatable=false)
    private Country country;
    private Integer countryid;

    @ManyToOne
    @JoinColumn(name="regionid", insertable=false, updatable=false)
    private Region region;
    private Integer regionid;




}
