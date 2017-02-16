package org.seandragon.jfinal.demo.config;

import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import org.seandragon.jfinal.demo.model.User;

/**
 * Created by sd on 17/2/16.
 */
public class DemoConfig extends JFinalConfig {

    @Override
    public void configConstant(Constants constants) {
        // 加载少量必要配置，随后可用PropKit.get(...)获取值
        PropKit.use("db.txt");
        constants.setDevMode(PropKit.getBoolean("devMode", true));
        constants.setViewType(ViewType.JSP);
    }

    @Override
    public void configRoute(Routes routes) {
        routes.add(new RoutesConfig());
    }

    @Override
    public void configEngine(Engine engine) {
    }

    private DruidPlugin createDruidPlugin() {
        return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
    }

    @Override
    public void configPlugin(Plugins plugins) {
        //druid 插件
        DruidPlugin druidPlugin = createDruidPlugin();
        plugins.add(druidPlugin);

        // 配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
        plugins.add(arp);
        arp.addMapping("user", User.class);
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {
    }

    @Override
    public void configHandler(Handlers handlers) {
    }
}
