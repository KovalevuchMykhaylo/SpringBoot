package com.shop.controller.userControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import org.apache.tomcat.util.codec.binary.Base64;
import com.shop.entity.User;
import com.shop.service.UserService;
import com.shop.util.UserUtil;

@Controller
@RequestMapping("/user/profile")
public class UserProfileController {
	
	@Autowired
	private UserService userService;

	@RequestMapping
	public String show(Model model) {
		User user = UserUtil.getSignedUpUser();
		if(user.getFileData()!=null) {
			String encodeFileToBase64 = new String(Base64.encodeBase64(user.getFileData()));
			model.addAttribute("imgFromDb", encodeFileToBase64);
		}
		model.addAttribute("user", user);
		return "user/profile";
	}
	
	@PostMapping("/newAvatar")
	public String saveFileToDatabase(@RequestParam("fileUpload") MultipartFile file, SessionStatus status) throws IOException {
		if(!file.isEmpty() && file != null) {
			User user = UserUtil.getSignedUpUser();
			user.setFileName(file.getOriginalFilename());
			user.setFileData(file.getBytes());
			userService.save(user);
			status.setComplete();
		}
		return "redirect:/user/profile";
	}
}
