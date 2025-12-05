    package com.logibytekh.pos.modal;

    import jakarta.persistence.Embeddable;
    import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

    @Data
    @Embeddable
    @Builder
    public class StoreContact {
        private String address;
        private String phone;


        @Email(message = "invalid email format")
        private String email;

        
    }
