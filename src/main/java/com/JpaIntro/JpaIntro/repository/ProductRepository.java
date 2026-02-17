package com.JpaIntro.JpaIntro.repository;

import com.JpaIntro.JpaIntro.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    List<ProductEntity> findByTitle(String title);

       @Query(value="select * from products p where p.quantity<= ?1",nativeQuery = true)
        List<ProductEntity> findByQuantityLessThanEqual(Integer quantity);
}
