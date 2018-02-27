package com.shop.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.shop.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category>{
	
	List<Category> findByParentIsNull();
	
	@Transactional
	@Modifying
	@Query(value="UPDATE category c INNER JOIN category cc on c.id=cc.parent_id SET c.have_childs = true ", nativeQuery=true)
	void validHaveChilds();
	
	Category findByName(String name);

}
