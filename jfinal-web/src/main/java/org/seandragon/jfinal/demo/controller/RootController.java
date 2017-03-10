package org.seandragon.jfinal.demo.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.tx.Tx;
import org.seandragon.jfinal.demo.common.until.PrimaryKeyUtils;
import org.seandragon.jfinal.demo.interceptor.UserInterceptor;
import org.seandragon.jfinal.demo.model.AccoutModel;
import org.seandragon.jfinal.demo.model.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sd on 17/2/16.
 */
@Before(UserInterceptor.class)
public class RootController extends Controller {

    public void index() {
        setAttr("time", System.nanoTime());

        List<String> pkList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            pkList.add(PrimaryKeyUtils.getRandomStrByNanoTime(true));
        }

        setAttr("pk", pkList);

        render("index.jsp");
    }

    @Before(Tx.class)
    public void save() {
        UserModel userModel = getModel(UserModel.class);
        userModel.save();

        AccoutModel accoutModel = new AccoutModel();
        accoutModel.set("accountName", userModel.get("userName"));
        accoutModel.set("password", userModel.get("pwd"));
        accoutModel.save();

        String result = userModel.toString() + accoutModel.toString();

        Integer zero = getParaToInt("zero");
        System.out.println(1 / zero);

        renderJson(result);
    }


    /*//@Before(UserValidator.class)
    public void save() {
        //UserModel userModel = getModel(UserModel.class);
        //userModel.set("createDate", new java.util.Date());
        //boolean saveSuccess = userModel.save();
        //Map result = new HashMap();
        //result.put("IsError", !saveSuccess);
        //result.put("Message", "添加" + (saveSuccess ? "成功" : "失败了") + "了");
        ////result.put("Data", userModel);
        //result.put("NewId", userModel.get("id"));
        //renderJson(result);
        UserService userService = new UserServiceImpl();
        HttpServletRequest request = getRequest();
        UserModel model = getModel(UserModel.class, "");
        UserModel save = userService.save(model);
        System.out.println(save);
        renderJson("123");
    }

    @Before(UserValidator.class)
    public void update() {
        UserModel userModel = getModel(UserModel.class);
        boolean saveSuccess = userModel.update();
        Map result = new HashMap();
        result.put("IsError", !saveSuccess);
        result.put("Message", "更新" + (saveSuccess ? "成功" : "失败了") + "了");
        result.put("Data", userModel);
        renderJson(result);
    }

    public void delete() {
        Map result = new HashMap();
        Integer idValue = getParaToInt("id");
        if (idValue == null || idValue == 0) {
            result.put("status", false);
        } else {
            UserModel.dao.deleteById(idValue);
            result.put("status", true);
        }
        renderJson(result);
    }

    public void search() {
        List<UserModel> userModelList = getModel(UserModel.class).findList();
        String[] attrNames = new String[0];
        if (userModelList.size() > 0) {
            attrNames = userModelList.get(0)._getAttrNames();
        }
        for (UserModel oneUserModel : userModelList) {
            for (String attrName : attrNames) {
                oneUserModel.put("user." + attrName, oneUserModel.get(attrName));
                oneUserModel.remove(attrName);
            }
        }
        // List<UserModel> userModelList = UserModel.dao.find("select * from user where id=%s", searchModel.get("id"));
        Map result = new HashMap();
        result.put("rows", userModelList);
        result.put("results", userModelList.size());
        result.put("hasError", false);
        result.put("error", "");
        renderJson(result);
    }*/
}