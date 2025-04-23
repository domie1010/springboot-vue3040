package com.yjkj.framework.rbac.userInfo.web;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.roleInfo.model.RoleInfo;
import com.yjkj.framework.rbac.roleInfo.service.impl.RoleInfoServiceImpl;
import com.yjkj.framework.rbac.roleInfo.service.inte.RoleInfoService;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;
import com.yjkj.framework.rbac.userInfo.service.impl.UserInfoServiceImpl;
import com.yjkj.framework.rbac.userInfo.service.inte.UserInfoService;


@Controller
@RequestMapping("/user")
public class UserInfoController {
	@Autowired
	private UserInfoService uis = new UserInfoServiceImpl();
	
	@Autowired
	private RoleInfoService ris = new RoleInfoServiceImpl();
	
	@RequestMapping("/login")
	public String login(UserInfo user,Model model,HttpSession session){
		try{	
			
			UserInfo userInfo = this.uis.login(user.getLoginName(),user.getLoginPassword());
			session.setAttribute("Admin", userInfo);
			return "redirect:../request/index";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("messageLogin", e.getMessage());
			model.addAttribute("loginName", user.getLoginName());
			model.addAttribute("loginPassword", user.getLoginPassword());
			return "jsp/Login";
		}
		
	}
	@RequestMapping("/loginF")
	public String loginF(UserInfo user,Model model,HttpSession session){
		try{	
			
			UserInfo userInfo = this.uis.login(user.getLoginName(),user.getLoginPassword());
			session.setAttribute("User", userInfo);
			return "redirect:../request/welcome";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("messageLogin", e.getMessage());
			model.addAttribute("loginName", user.getLoginName());
			model.addAttribute("loginPassword", user.getLoginPassword());
			return "redirect:../request/welcome";
		}
		
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session){
			session.removeAttribute("Admin");
			return "jsp/Login";
	}
	@RequestMapping("/logoutF")
	public String logoutF(HttpSession session){
			session.removeAttribute("User");
			return "redirect:../request/welcome";
	}
	@RequestMapping("/logoutAdmin")
	public String logoutAdmin(HttpSession session){
			session.removeAttribute("Admin");
			return "jsp/LoginAdmin";
	}
	@RequestMapping("/userAdd")
	public String userAdd(UserInfo user,Model model){
			try{
				this.uis.userAdd(user);
				return "jsp/Success";
			}catch (RuntimeException e) {
				model.addAttribute("message", e.getMessage());
				return "jsp/Failed";
			}
	}
	@RequestMapping("/userAddF")
	public String userAddF(UserInfo user,Model model){
			try{
				this.uis.userAdd(user);
				return "jsp/foreground/Welcome";
			}catch (RuntimeException e) {
				model.addAttribute("message", e.getMessage());
				return "jsp/Failed";
			}
	}
	@RequestMapping("/userUpdate")
	public String userUpdate(UserInfo user,Model model){
			try{
				this.uis.userUpdate(user);
				return "jsp/Success";
			}catch (RuntimeException e) {
				model.addAttribute("message", e.getMessage());
				return "jsp/Failed";
			}
	}
	
	@RequestMapping("/success")
	public String success(UserInfo user,Model model){
			try{
				user.setFlag("1");
				this.uis.userUpdate(user);
				return "jsp/Success";
			}catch (RuntimeException e) {
				model.addAttribute("message", e.getMessage());
				return "jsp/Failed";
			}
	}
	
	@RequestMapping("/userUpdateF")
	public String userUpdateF(UserInfo user,Model model){
			try{
				this.uis.userUpdate(user);
				return "jsp/foreground/Welcome";
			}catch (RuntimeException e) {
				e.printStackTrace();
				model.addAttribute("message", e.getMessage());
				return "jsp/Failed";
			}
	}
	@RequestMapping("/userDelete")
	public String userDelete(String id,Model model){
			try{
				this.uis.userDelete(id);
				return "jsp/Success";
			}catch (RuntimeException e) {
				model.addAttribute("message", e.getMessage());
				return "jsp/Failed";
			}
	}
	@RequestMapping("/queryOne")
	public String queryOne(String id,Model model){
		try{
			UserInfo user = this.uis.queryOne(id);
			List<RoleInfo> list = this.ris.query();
			model.addAttribute("role", list);
			model.addAttribute("user", user);
			return "jsp/User";
		}catch (RuntimeException e) {
			model.addAttribute("messageLogin", e.getMessage());
			return "redirect:query";
		}
	}
	
	@RequestMapping("/queryOwn")
	public String queryOwn(String id,Model model,HttpSession session){
		try{
			
			UserInfo user = (UserInfo) session.getAttribute("User");
			List<RoleInfo> list = this.ris.query();
			model.addAttribute("role", list);
			model.addAttribute("user", user);
			return "jsp/User";
		}catch (RuntimeException e) {
			model.addAttribute("messageLogin", e.getMessage());
			return "redirect:query";
		}
	}
	
	@RequestMapping("/query")
	public String query(Pager pager,UserInfo user,Model model){
		try{
		model.addAttribute("pager", this.uis.Query(pager, user));
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/UserTable";
	}
	
	@RequestMapping("/queryCompany")
	public String queryCompany(Pager pager,UserInfo user,Model model){
		try{
			user.setRoleId("3");
			user.setFlag("1");
		model.addAttribute("pager", this.uis.Query(pager, user));
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/CompanyTable";
	}
	@RequestMapping("/queryOneFore")
	public String queryOneFore(String id,Model model){
		try{
			UserInfo user = this.uis.queryOne(id);
			List<RoleInfo> list = this.ris.query();
			model.addAttribute("role", list);
			model.addAttribute("user", user);
			return "jsp/foreground/information";
		}catch (RuntimeException e) {
			model.addAttribute("messageLogin", e.getMessage());
			return "redirect:query";
		}
	}
	@RequestMapping("/queryOneCompany")
	public String queryOneCompany(String id,Model model){
		try{
			UserInfo user = this.uis.queryOne(id);
			List<RoleInfo> list = this.ris.query();
			model.addAttribute("role", list);
			model.addAttribute("user", user);
			return "jsp/foreground/Company";
		}catch (RuntimeException e) {
			model.addAttribute("messageLogin", e.getMessage());
			return "redirect:query";
		}
	}
	@RequestMapping("/queryCompanyCheck")
	public String queryCompanyCheck(Pager pager,UserInfo user,Model model){
		try{
			user.setRoleId("3");
			user.setFlag("0");
		model.addAttribute("pager", this.uis.Query(pager, user));
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/CompanyCheckTable";
	}
	
	@RequestMapping("/queryCustom")
	public String queryCustom(Pager pager,UserInfo user,Model model){
		try{
			user.setRoleId("2");
		model.addAttribute("pager", this.uis.Query(pager, user));
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/CustomTable";
	}
}
