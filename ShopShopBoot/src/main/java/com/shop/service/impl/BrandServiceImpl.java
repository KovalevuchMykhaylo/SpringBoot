package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.shop.dto.filters.SimpleFilter;
import com.shop.dto.projections.NameAndIdProjection;
import com.shop.entity.Brand;
import com.shop.repository.BrandRepository;
import com.shop.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{

	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public void save(Brand brand) {
		brandRepository.save(brand);
	}

	@Override
	public Brand findOne(Integer id) {
		return brandRepository.findOne(id);
	}

	@Override
	public List<Brand> findAll() {
		return brandRepository.findAll();
	}

	@Override
	public Page<Brand> findPage(SimpleFilter filter, Pageable pageable) {
		return brandRepository.findAll(findByNameLike(filter), pageable);
	}

	@Override
	public Brand findByName(String name) {
		return brandRepository.findByName(name);
	}

	@Override
	public void delete(Integer id) {
		brandRepository.delete(id);
	}
	
	private Specification<Brand> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch().toLowerCase() + "%");
		};
	}

	@Override
	public List<NameAndIdProjection> findProjections() {
		return brandRepository.findProjections();
	}

}
