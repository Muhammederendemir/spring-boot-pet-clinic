package com.springbootpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data                            //getter setter toString metotlar için
@AllArgsConstructor             //tüm field ile constructor
@NoArgsConstructor
public class Pet {
    private Long id;
    private String name;
    private Date birthDate;
    private Set<Pet> pets = new HashSet<>();

}
