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
        getModel(User.class).save();
        redirect("/user");
    }

    @Before(UserValidator.class)
    public void update() {
        getModel(User.class).update();
        redirect("/user");
    }

    public void delete() {
        User.dao.deleteById(getParaToInt());
        Map result = new HashMap();
        result.put("status", true);
        renderJson(result);
    }

    public void search() {

        User searchModel = getModel(User.class);

        List<User> userList = User.dao.find("select * from user");
        //List<User> userList = User.dao.find("select * from user where id=%s", searchModel.get("id"));
        Map result = new HashMap();
        result.put("rows", userList);
        result.put("results", userList.size());
        result.put("hasError", false);
        result.put("error", "");
        renderJson(userList);
    }
}
