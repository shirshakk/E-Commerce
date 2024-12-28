package com.ecom.ecom.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.ecom.model.ecomModel;
import java.util.List;


@Repository
public interface ecomRepo extends JpaRepository<ecomModel, Integer> {
    List<ecomModel> findByproductCategory(String productCategory);
    List<ecomModel> findByproductBrand(String productBrand);
}
