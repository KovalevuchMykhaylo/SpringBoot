package com.shop.controller.adminControllers;

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
import com.shop.entity.Country;
import com.shop.service.CountryService;
import com.shop.validators.CountryValidator;

import static com.shop.util.ParamBuilder.getParams;

@Controller
@RequestMapping("/admin/country")
@SessionAttributes("country")
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@InitBinder("country")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new CountryValidator(countryService));
	}
	
	@ModelAttribute("country")
	public Country getForm() {
		return new Country();
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter() {
		return new SimpleFilter();
	}
	
	
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter")SimpleFilter filter) {
		model.addAttribute("page", countryService.findPage(filter, pageable));
		return"admin/country";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id")Integer id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter")SimpleFilter filter) {
		model.addAttribute("country", countryService.findOne(id));
		return show(model,pageable,filter);
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id")Integer id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter")SimpleFilter filter) {
		countryService.delete(id);
		return"redirect:/admin/country"+getParams(pageable, filter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("country") @Valid Country country, BindingResult br, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter")SimpleFilter filter, SessionStatus status) {
		if(br.hasErrors()) return show(model, pageable, filter);
		countryService.save(country);
		status.setComplete();
		return"redirect:/admin/country"+getParams(pageable, filter);
	}
	
	@RequestMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return"redirect:/admin/country";
	}

}
