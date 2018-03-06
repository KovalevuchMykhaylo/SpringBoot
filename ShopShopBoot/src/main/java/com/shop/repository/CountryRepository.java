package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.shop.dto.projections.NameAndIdProjection;
import com.shop.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>, JpaSpecificationExecutor<Country>{

	Country findByName(String name);

	Country findByShortName(String shortName);
	
	@Query("select b.id as id, b.name as name from Country b")
	List<NameAndIdProjection> findProjections();

}
