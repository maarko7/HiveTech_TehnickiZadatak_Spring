package dev.ms.production.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "phonebook")
public class PhonebookUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "oib", nullable = false, unique = true)
    @Size(min = 11, max = 11, message = "OIB mora sadrzavati 11 znakova.")
    @Pattern(regexp = "\\d+", message = "OIB ne moze sadrzavati nista osim brojeva.")
    private String oib;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "phone_number", nullable = false)
    @Pattern(regexp = "^09\\d{8,9}$", message = "Broj telefona mora početi s '09'.")
    private String phoneNumber;

}
