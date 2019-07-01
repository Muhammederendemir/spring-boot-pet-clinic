package com.springbootpetclinic;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "petclinic")
//uygulamanın bu prefix ile başlayan property tanımlarının bu sınıfltaki propertylerle eşleşeçeğini belirtmiş oluyor
public class PetClinicProperties {
    private boolean displayOwnersWithPets = false;

    public boolean isDisplayOwnersWithPets() {
        return displayOwnersWithPets;
    }

    public void setDisplayOwnersWithPets(boolean displayOwnersWithPets) {
        this.displayOwnersWithPets = displayOwnersWithPets;
    }
}
