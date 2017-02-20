package org.seandragon.jfinal.demo.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import org.seandragon.jfinal.demo.model.User;

/**
 * Created by sd on 17/2/16.
 */
public class UserValidator extends Validator {
    @Override
    protected void validate(Controller controller) {
        System.out.println("UserValidator.validate");
        validateRequiredString("user.userName", "userNameMsg", "请输入用户姓名!");
        validateRequiredString("user.pwd", "pwdMsg", "请输入用户密码!");
    }

    @Override
    protected void handleError(Controller controller) {
        System.out.println("UserValidator.handleError");
        controller.keepModel(User.class);
        String actionKey = getActionKey();
        if (actionKey.equals("/user/save"))
            controller.render("add.jsp");
        else if (actionKey.equals("/user/update"))
            controller.render("edit.jsp");
    }
}
