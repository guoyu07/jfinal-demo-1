package org.seandragon.jfinal.demo.config;

import com.jfinal.config.Routes;
import org.seandragon.jfinal.demo.controller.RootController;
import org.seandragon.jfinal.demo.controller.admin.UserController;

/**
 * Created by sd on 17/2/16.
 */
public class RoutesConfig extends Routes {
    @Override
    public void config() {
        add("/", RootController.class);
        add("/admin/user", UserController.class);
    }
}
