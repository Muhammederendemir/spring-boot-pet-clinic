package com.springbootpetclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.HashSet;
import java.util.Set;

@Data                            //getter setter toString metotlar için
@AllArgsConstructor             //tüm field ile constructor
@NoArgsConstructor
@Entity
@Table(name = "t_owner")
@XmlRootElement
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "petClinicSenGen")
    @SequenceGenerator(name = "petClinicSenGen", sequenceName = "petclinic_sequence")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @XmlTransient//haric birakmak için
    @JsonIgnore
    public Set<Pet> getPets() {
        return pets;
    }

}
