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
        List<User> userList = User.dao.find("select * from user");
        //Page<User> paginate = User.dao.paginate(1, 99);
        //setAttr("userPage", paginate);
        //renderJson(userList);
        setAttr("userList", userList);
        renderJsp("list.jsp");
    }

    public void add() {
        renderJsp("add.jsp");
    }

    @Before(UserValidator.class)
    public void save() {
        getModel(User.class).save();
        redirect("/user");
    }

    public void edit() {
        setAttr("user", User.dao.findById(getParaToInt()));
        renderJsp("edit.jsp");
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
