package com.JpaIntro.JpaIntro.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length=20,unique=true )
    private String sku;
    @Column(nullable = false,length=45,unique=true )
    private String title;

    @Column(nullable = false)
    private BigDecimal price;
    private Integer quantity;
    private String description;
    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = false,updatable = true)
    private LocalDateTime updatedAt;

}
