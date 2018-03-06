package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.shop.dto.filters.SimpleFilter;
import com.shop.dto.projections.NameAndIdProjection;
import com.shop.entity.Country;
import com.shop.repository.CountryRepository;
import com.shop.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public void save(Country country) {
		countryRepository.save(country);
	}

	@Override
	public Country findOne(Integer id) {
		return countryRepository.findOne(id);
	}

	@Override
	public List<Country> findAll() {
		return countryRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		countryRepository.delete(id);
	}

	@Override
	public Page<Country> findPage(SimpleFilter filter, Pageable pageable) {
		return countryRepository.findAll(findByNameLike(filter), pageable);
	}

	@Override
	public Country findByName(String name) {
		return countryRepository.findByName(name);
	}

	@Override
	public Country findByShortName(String shortName) {
		return countryRepository.findByShortName(shortName);
	}

	private Specification<Country> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch().toLowerCase() + "%");
		};
	}

	@Override
	public List<NameAndIdProjection> findProjections() {
		return countryRepository.findProjections();
	}

}
