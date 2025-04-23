package com.yjkj.framework.rbac.myAct.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.myAct.model.MyAct;
import com.yjkj.framework.rbac.myAct.service.impl.MyActServiceImpl;
import com.yjkj.framework.rbac.myAct.service.inte.MyActService;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;

@Controller
@RequestMapping("/myAct")
public class MyActController {
	
	@Autowired
	private MyActService myActService = new MyActServiceImpl();
	

	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,MyAct MyAct,HttpSession session) {
		try {
		pager = this.myActService.informationLoad(pager,MyAct,session);
		model.addAttribute("myActList", pager);
		return "jsp/MyActTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadUser")
	public String informationLoadUser(Pager pager,Model model,MyAct MyAct,HttpSession session) {
		try {
			UserInfo userInfo = (UserInfo) session.getAttribute("User");
			MyAct.setUser_id(userInfo.getId());
		pager = this.myActService.informationLoad(pager,MyAct,session);
		model.addAttribute("pager", pager);
		return "jsp/foreground/AttendTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadPartner")
	public String informationLoadPartner(Pager pager,Model model,MyAct MyAct,HttpSession session) {
		try {
		pager = this.myActService.informationLoad(pager,MyAct,session);
		model.addAttribute("pager", pager);
		return "jsp/foreground/PartnerTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(MyAct MyAct,Model model) {
		
		try {
			MyAct = this.myActService.informationLoadOne(MyAct);
			model.addAttribute("myAct", MyAct);
			return "jsp/MyAct";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationLoadOneFore")
	public String informationLoadOneFore(MyAct MyAct,Model model) {
		
		try {
			MyAct = this.myActService.informationLoadOne(MyAct);
			model.addAttribute("myAct", MyAct);
			return "jsp/";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(MyAct MyAct,Model model) {
		
		try {
			
			this.myActService.informationAdd(MyAct);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAddFore")
	public String informationAddFore(MyAct MyAct,Model model) {
		
		try {
			
			this.myActService.informationAdd(MyAct);
			return "redirect:../request/welcome";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationDelete")
	public String informationDelete(MyAct MyAct,Model model) {
		
		try {
			this.myActService.informationDelete(MyAct);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationDeleteFore")
	public String informationDeleteFore(MyAct MyAct,Model model) {
		
		try {
			this.myActService.informationDelete(MyAct);
			return "redirect:../request/welcome";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(MyAct MyAct,Model model) {
		
		try {
			this.myActService.informationUpade(MyAct);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
