package org.seandragon.jfinal.demo.model;

import com.jfinal.kit.JMap;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.SqlPara;

import java.util.List;

/**
 * Created by sd on 17/2/16.
 */
public class User extends Model<User> {
	public static final User dao = new User();

	/**
	 * 所有 sql 与业务逻辑写在 Service 中，在此放在 Model 中仅为示例，
	 * 不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
	 */
	public Page<User> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from user order by id asc");
	}

	public List<User> findList() {
		//User user = this;
		//StringBuffer sql = new StringBuffer();
		//sql.append("select * from user where 1 = 1");
		//if (null != user.get("id") && !"".equals(user.get("id").toString().trim()))
		//	sql.append(" and id = " + user.get("id"));
		//if (null != user.get("userName") && !"".equals(user.get("userName").toString().trim()))
		//	sql.append(" and userName = " + user.get("userName"));
		//if (null != user.get("pwd") && !"".equals(user.get("pwd").toString().trim()))
		//	sql.append(" and pwd = " + user.get("pwd"));
		//if (null != user.get("sex") && !"".equals(user.get("sex").toString().trim()))
		//	sql.append(" and sex = " + user.get("sex"));
		//if (null != user.get("birthDate") && !"".equals(user.get("birthDate").toString().trim()))
		//	sql.append(" and birthDate = '" + user.get("birthDate") + "'");
		//
		//return find(sql.toString());
		return find(getSqlPara("findList"));
	}
}
