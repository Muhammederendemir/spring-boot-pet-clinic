package com.springbootpetclinic.web;

import com.springbootpetclinic.model.Owner;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PetClinicRestControllerTest {
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
    }

    @Test
    public void testOwnerById() {
        ResponseEntity<Owner> response = restTemplate.getForEntity("http://localhost:8080/rest/owner/1", Owner.class);

        MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
        MatcherAssert.assertThat(response.getBody().getFirstName(), Matchers.equalTo("Muhammed"));
    }

    @Test
    public void testOwnerByLastName() {
        ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8080/rest/owner?ln=Demir", List.class);
        MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
        List<Map<String, String>> body = response.getBody();
        List<String> firstNames = body.stream().map(e -> e.get("firstName")).collect(Collectors.toList()); //Listenin icerisindeki map elemanına ulaşarak
        // herbır map'in içerisinden lastName eriserek bir string listesine ekliyoruz.

        MatcherAssert.assertThat(firstNames, Matchers.containsInAnyOrder("Muhammed"));//Listenin içerisinde var mı sorusu
    }

    @Test
    public void testGetOwners() {
        ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8080/rest/owners", List.class);
        MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
        List<Map<String, String>> body = response.getBody();
        List<String> firstNames = body.stream().map(e -> e.get("firstName")).collect(Collectors.toList());//Listenin icerisindeki map elemanına ulaşarak
        // herbır map'in içerisinden lastName eriserek bir string listesine ekliyoruz.

        MatcherAssert.assertThat(firstNames, Matchers.containsInAnyOrder("Muhammed,Ahmet,Yunus,Bekir"));//Listenin içerisinde var mı sorusu
    }

    @Test
    public void testCreateOwner() {
        Owner owner = new Owner();
        owner.setFirstName("Mustafa");
        owner.setLastName("Karacuha");
        URI location = restTemplate.postForLocation("http://localhost:8080/rest/owner", owner);// nesneyi sunucu tarafında insert ediyoruz

        Owner owner1 = restTemplate.getForObject(location, Owner.class);//yeni oluşan owner nesnesine erisiyoruz.
        System.out.println(owner1.toString());

        MatcherAssert.assertThat(owner1.getFirstName(), Matchers.equalTo(owner.getFirstName()));
        MatcherAssert.assertThat(owner1.getLastName(), Matchers.equalTo(owner.getLastName()));

    }
}
