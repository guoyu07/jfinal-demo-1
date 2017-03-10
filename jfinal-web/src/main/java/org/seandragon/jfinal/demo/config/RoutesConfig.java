package org.seandragon.jfinal.demo.config;

import com.jfinal.config.Routes;
import org.seandragon.jfinal.demo.controller.RootController;

/**
 * Created by sd on 17/2/16.
 */
public class RoutesConfig extends Routes {
    @Override
    public void config() {
        setBaseViewPath("/WEB-INF/jsp/");//设置视图文件
        add("/", RootController.class);
    }
}
