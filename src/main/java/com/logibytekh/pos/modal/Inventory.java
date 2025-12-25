package com.logibytekh.pos.modal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;





@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(optional= false)
    @JoinColumn(name = "branch_id")
    private Branch branch;
    

    @ManyToOne(optional = false)    
    @JoinColumn(name = "product_id")
    private Product product;


    @Column(nullable = false)
    private Integer quantity;

    private LocalDateTime lastUpdate;
    

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        lastUpdate = LocalDateTime.now();
    }

    
}
