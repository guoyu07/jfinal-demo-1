package org.seandragon.jfinal.demo.controller.admin;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import org.seandragon.jfinal.demo.interceptor.UserInterceptor;
import org.seandragon.jfinal.demo.model.User;
import org.seandragon.jfinal.demo.validator.UserValidator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sd on 17/2/16.
 */
@Before(UserInterceptor.class)
public class UserController extends Controller {

	public void index() {
		redirect("/");
	}

	@Before(UserValidator.class)
	public void save() {
		User user = getModel(User.class);
		user.set("createDate", new java.util.Date());
		boolean saveSuccess = user.save();
		Map result = new HashMap();
		result.put("IsError", !saveSuccess);
		result.put("Message", "添加" + (saveSuccess ? "成功" : "失败了") + "了");
		//result.put("Data", user);
		result.put("NewId", user.get("id"));
		renderJson(result);
	}

	@Before(UserValidator.class)
	public void update() {
		User user = getModel(User.class);
		boolean saveSuccess = user.update();
		Map result = new HashMap();
		result.put("IsError", !saveSuccess);
		result.put("Message", "更新" + (saveSuccess ? "成功" : "失败了") + "了");
		result.put("Data", user);
		renderJson(result);
	}

	public void delete() {
		Map result = new HashMap();
		Integer idValue = getParaToInt("id");
		if (idValue == null || idValue == 0) {
			result.put("status", false);
		} else {
			User.dao.deleteById(idValue);
			result.put("status", true);
		}
		renderJson(result);
	}

	public void search() {
		List<User> userList = User.dao.find("select * from user");
		String[] attrNames = new String[0];
		if (userList.size() > 0) {
			attrNames = userList.get(0)._getAttrNames();
		}
		for (User oneUser : userList) {
			for (String attrName : attrNames) {
				oneUser.put("user." + attrName, oneUser.get(attrName));
				oneUser.remove(attrName);
			}
		}
		//List<User> userList = User.dao.find("select * from user where id=%s", searchModel.get("id"));
		Map result = new HashMap();
		result.put("rows", userList);
		result.put("results", userList.size());
		result.put("hasError", false);
		result.put("error", "");
		renderJson(result);
	}
}
