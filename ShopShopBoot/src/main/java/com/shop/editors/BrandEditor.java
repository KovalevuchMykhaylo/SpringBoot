package com.shop.editors;

import java.beans.PropertyEditorSupport;

import com.shop.entity.Brand;
import com.shop.service.BrandService;

public class BrandEditor extends PropertyEditorSupport{
	
	private final BrandService brandService;

	public BrandEditor(BrandService brandService) {
		this.brandService = brandService;
	}
	
	 @Override
	    public void setAsText(String text) throws IllegalArgumentException {
	        Brand brand = brandService.findOne(Integer.valueOf(text));
	        setValue(brand);
	    }

}
