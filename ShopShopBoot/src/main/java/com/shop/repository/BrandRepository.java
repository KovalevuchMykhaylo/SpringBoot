package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.shop.dto.projections.NameAndIdProjection;
import com.shop.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>, JpaSpecificationExecutor<Brand>{

	Brand findByName(String name);
	
	@Query("select b.id as id, b.name as name from Brand b")
	List<NameAndIdProjection> findProjections();
}
