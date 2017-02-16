package org.seandragon.jfinal.demo.model;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

/**
 * Created by sd on 17/2/16.
 */
public class User  extends Model<User> {
    public static final User dao = new User();

    /**
     * 所有 sql 与业务逻辑写在 Service 中，在此放在 Model 中仅为示例，
     * 不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
     */
    public Page<User> paginate(int pageNumber, int pageSize) {
        return paginate(pageNumber, pageSize, "select *", "from user order by id asc");
    }
}
