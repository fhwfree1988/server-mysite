package com.project.site.Modules.Product.model.entity;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.*;

import java.time.OffsetDateTime;

@Entity
//@Document
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long Id;

    @Column
    private int Cost;

    //@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm")
    @Column(nullable = false)
    private OffsetDateTime submitionDate;

    //@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm")
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

    @Column
    private boolean isActive;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;


    @PrePersist
    public void prePersist() {
        submitionDate = OffsetDateTime.now();
        lastUpdated = submitionDate;
    }

    @PreUpdate
    public void preUpdate() {
        lastUpdated = OffsetDateTime.now();
    }

}
