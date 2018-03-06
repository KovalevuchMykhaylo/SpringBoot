package com.shop.controller.adminControllers;

import static com.shop.util.ParamBuilder.getParams;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.shop.dto.filters.SimpleFilter;
import com.shop.entity.Brand;
import com.shop.service.BrandService;
import com.shop.validators.BrandValidator;

@Controller
@RequestMapping("/admin/brand")
@SessionAttributes("brand")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@InitBinder("brand")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new BrandValidator(brandService));
	}
	
	@ModelAttribute("brand")
	public Brand getForm() {
		return new Brand();
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}
	
	
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter")SimpleFilter filter) {
		model.addAttribute("page", brandService.findPage(filter, pageable));
		return"admin/brand";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id")Integer id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter")SimpleFilter filter) {
		model.addAttribute("brand", brandService.findOne(id));
		return show(model,pageable,filter);
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id")Integer id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter")SimpleFilter filter) {
		brandService.delete(id);
		return"redirect:/admin/brand"+getParams(pageable, filter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("brand") @Valid Brand brand, BindingResult br, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter")SimpleFilter filter, SessionStatus status) {
		if(br.hasErrors()) return show(model, pageable, filter);
		brandService.save(brand);
		status.setComplete();
		return"redirect:/admin/brand"+getParams(pageable, filter);
	}
	
	@RequestMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return"redirect:/admin/brand";
	}

}
