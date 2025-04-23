package com.yjkj.framework.rbac.act.web;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.act.model.Act;
import com.yjkj.framework.rbac.act.service.impl.ActServiceImpl;
import com.yjkj.framework.rbac.act.service.inte.ActService;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;

@Controller
@RequestMapping("/act")
public class ActController {
	
	@Autowired
	private ActService actService = new ActServiceImpl();
	

	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Act Act,HttpSession session) {
		try {
		pager = this.actService.informationLoad(pager,Act,session);
		model.addAttribute("actList", pager);
		model.addAttribute("act", Act);
		return "jsp/ActTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadCustom")
	public String informationLoadCustom(Pager pager,Model model,Act Act,HttpSession session) {
		try {
			Act.setType("1");
		pager = this.actService.informationLoad(pager,Act,session);
		model.addAttribute("pager", pager);
		model.addAttribute("act", Act);
		return "jsp/foreground/CustomActTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	@RequestMapping("/informationLoadCompany")
	public String informationLoadCompany(Pager pager,Model model,Act Act,HttpSession session) {
		try {
			Act.setType("2");
		pager = this.actService.informationLoad(pager,Act,session);
		model.addAttribute("pager", pager);
		model.addAttribute("act", Act);
		return "jsp/foreground/CompanyActTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadUser")
	public String informationLoadUser(Pager pager,Model model,Act Act,HttpSession session) {
		try {
		UserInfo userInfo = (UserInfo) session.getAttribute("User");
		Act.setUser_id(userInfo.getId());
		pager = this.actService.informationLoad(pager,Act,session);
		Act.setType("2");
		model.addAttribute("pager", pager);
		model.addAttribute("act", Act);
		return "jsp/foreground/MyActTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Act Act,Model model) {
		
		try {
			Act = this.actService.informationLoadOne(Act);
			model.addAttribute("act", Act);
			return "jsp/Act";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationLoadLook")
	public String informationLoadLook(Act Act,Model model) {
		
		try {
			Act = this.actService.informationLoadOne(Act);
			model.addAttribute("act", Act);
			return "jsp/foreground/ActLook";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/customAct")
	public String customAct(Act Act,Model model) {
		
		try {
			Act = this.actService.informationLoadOne(Act);
			model.addAttribute("act", Act);
			return "jsp/foreground/CustomAct";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/companyAct")
	public String companyAct(Act Act,Model model) {
		
		try {
			Act = this.actService.informationLoadOne(Act);
			model.addAttribute("act", Act);
			return "jsp/foreground/CompanyAct";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationLoadOneFore")
	public String informationLoadOneFore(Act Act,Model model) {
		
		try {
			Act = this.actService.informationLoadOne(Act);
			model.addAttribute("act", Act);
			return "jsp/foreground/Act";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(Act Act,MultipartFile[] file,HttpServletRequest request,Model model) {
		
		try {
			
			this.actService.informationAdd(Act,file,request);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAddF")
	public String informationAddF(Act Act,MultipartFile[] file,HttpServletRequest request,Model model) {
		
		try {
			
			this.actService.informationAdd(Act,file,request);
			return "redirect:../request/welcome";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationDelete")
	public String informationDelete(Act Act,Model model) {
		
		try {
			this.actService.informationDelete(Act);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationDeleteFore")
	public String informationDeleteFore(Act Act,Model model) {
		
		try {
			this.actService.informationDelete(Act);
			return "redirect:../request/welcome";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Act Act,MultipartFile[] file,HttpServletRequest request,Model model) {
		
		try {
			this.actService.informationUpade(Act,file,request);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdateF")
	public String informationUpdateF(Act Act,MultipartFile[] file,HttpServletRequest request,Model model) {
		
		try {
			this.actService.informationUpade(Act,file,request);
			return "redirect:../request/welcome";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
