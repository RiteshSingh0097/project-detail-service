package com.shobhit.project.detail.service.repository;

import com.shobhit.project.detail.service.model.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer> {

    Optional<ProductDetails> findByProductKey(String productKey);
}
