package com.n11.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class Customer extends BaseEntity{


    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;

    public Customer(String firstName, String lastName, String email, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", timeOfCreation=" + super.getTimeOfCreation() +
                ", timeOfUpdate=" + super.getTimeOfUpdate() +
                '}';
    }
}