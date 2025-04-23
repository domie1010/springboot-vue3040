package com.yjkj.framework.rbac.personal.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.personal.service.impl.PersonalServiceImpl;
import com.yjkj.framework.rbac.personal.model.Personal;
import com.yjkj.framework.rbac.personal.service.inte.PersonalService;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;
import com.yjkj.framework.rbac.userInfo.service.impl.UserInfoServiceImpl;
import com.yjkj.framework.rbac.userInfo.service.inte.UserInfoService;

@Controller
@RequestMapping("/personal")
public class PersonalController {
	
	@Autowired
	private PersonalService personalService = new PersonalServiceImpl();
	
	@Autowired
	private UserInfoService UserInfoService = new UserInfoServiceImpl();

	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Personal Personal,HttpSession session) {
		try {
		pager = this.personalService.informationLoad(pager,Personal,session);
		model.addAttribute("personalList", pager);
		return "jsp/PersonalTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Personal Personal,Model model) {
		
		try {
			Personal = this.personalService.informationLoadOne(Personal);
			model.addAttribute("personal", Personal);
			return "jsp/Personal";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationLoadOneFore")
	public String informationLoadOneFore(Personal Personal,Model model) {
		
		try {
			Personal = this.personalService.informationLoadOne(Personal);
			model.addAttribute("personal", Personal);
			return "jsp/foreground/Personal";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(Personal Personal,Model model) {
		
		try {
			
			this.personalService.informationAdd(Personal);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationDelete")
	public String informationDelete(Personal Personal,Model model) {
		
		try {
			this.personalService.informationDelete(Personal);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Personal Personal,Model model) {
		
		try {
			this.personalService.informationUpade(Personal);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdateF")
	public String informationUpdateF(Personal Personal,Model model,HttpSession session) {
		
		try {
			this.personalService.informationUpade(Personal);
			UserInfo userInfo = (UserInfo) session.getAttribute("User");
			session.removeAttribute("User");
			userInfo = this.UserInfoService.queryOne(userInfo.getId());
			session.setAttribute("User", userInfo);
			return "redirect:../request/welcome";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
