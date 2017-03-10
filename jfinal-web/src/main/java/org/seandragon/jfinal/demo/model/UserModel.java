package org.seandragon.jfinal.demo.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * Created by sd on 17/3/10.
 */
public class UserModel extends Model<UserModel> {
    public static UserModel dao = new UserModel();
}
