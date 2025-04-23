package com.yjkj.framework.rbac.real.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.real.model.Real;
import com.yjkj.framework.rbac.real.service.impl.RealServiceImpl;
import com.yjkj.framework.rbac.real.service.inte.RealService;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;
import com.yjkj.framework.rbac.userInfo.service.impl.UserInfoServiceImpl;
import com.yjkj.framework.rbac.userInfo.service.inte.UserInfoService;

@Controller
@RequestMapping("/real")
public class RealController {
	
	@Autowired
	private RealService realService = new RealServiceImpl();
	
	@Autowired
	private UserInfoService UserInfoService = new UserInfoServiceImpl();
	

	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Real Real,HttpSession session) {
		try {
		Real.setStatus("2");
		pager = this.realService.informationLoad(pager,Real,session);
		model.addAttribute("realList", pager);
		return "jsp/RealCheckTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Real Real,Model model) {
		
		try {
			Real = this.realService.informationLoadOne(Real);
			model.addAttribute("real", Real);
			return "jsp/Real";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationLoadOneFore")
	public String informationLoadOneFore(Real Real,Model model) {
		
		try {
			Real = this.realService.informationLoadOne(Real);
			model.addAttribute("real", Real);
			return "jsp/foreground/Real";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(Real Real,Model model) {
		
		try {
			
			this.realService.informationAdd(Real);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationDelete")
	public String informationDelete(Real Real,Model model) {
		
		try {
			this.realService.informationDelete(Real);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Real Real,Model model) {
		
		try {
			this.realService.informationUpade(Real);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/success")
	public String success(Real Real,Model model,HttpSession session) {
		
		try {
			Real.setStatus("1");
			this.realService.informationUpade(Real);
			UserInfo userInfo = (UserInfo) session.getAttribute("User");
			session.removeAttribute("User");
			userInfo = this.UserInfoService.queryOne(userInfo.getId());
			session.setAttribute("User", userInfo);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/failed")
	public String failed(Real Real,Model model,HttpSession session) {
		
		try {
			Real.setStatus("3");
			this.realService.informationUpade(Real);
			UserInfo userInfo = (UserInfo) session.getAttribute("User");
			session.removeAttribute("User");
			userInfo = this.UserInfoService.queryOne(userInfo.getId());
			session.setAttribute("User", userInfo);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdateF")
	public String informationUpdateF(Real Real,Model model,HttpSession session) {
		
		try {
			this.realService.informationUpade(Real);
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
