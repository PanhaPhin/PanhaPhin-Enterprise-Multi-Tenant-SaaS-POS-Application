package com.logibytekh.pos.modal;

import java.time.LocalDateTime;

import com.logibytekh.pos.domain.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Email;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    @Id
    private Long id;

    @Column(nullable=false)
    private String fullName;

    @Column(nullable = false,unique = true)
    @Email(message="Email should be valid")
    private String email;

    private String phone;

    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private UserRole role;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLogin;

    
}
