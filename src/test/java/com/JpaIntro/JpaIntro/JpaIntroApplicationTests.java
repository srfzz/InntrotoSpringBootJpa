package com.JpaIntro.JpaIntro;

import com.JpaIntro.JpaIntro.entities.ProductEntity;
import com.JpaIntro.JpaIntro.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class JpaIntroApplicationTests {
@Autowired
	private  ProductRepository productRepository;


	@Test
	void contextLoads() {
	}
	@Test
	void testRepository() {
	ProductEntity productEntity = ProductEntity.builder().sku("#Prod-11")
			.title("Product001")
			.price(BigDecimal.valueOf(500.00))
			.description("this is prduct description")
			.createdAt(LocalDateTime.now())
		.updatedAt(LocalDateTime.now()).build();
	productRepository.save(productEntity);
	}
@Test
	void testRepositoryFindByTitle()
	{
		List<ProductEntity> list = productRepository.findByQuantityLessThanEqual(4);
		System.out.println(list);
	}

}
