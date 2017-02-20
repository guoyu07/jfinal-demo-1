package org.seandragon.jfinal.demo.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.log.Log4jLog;

/**
 * Created by sd on 17/2/16.
 */
public class UserInterceptor implements Interceptor {

	Log4jLog log = Log4jLog.getLog(UserInterceptor.class);

	@Override
	public void intercept(Invocation invocation) {
		log.info("before\t" + invocation.getActionKey());
		invocation.invoke();
		log.warn("after\t" + invocation.getActionKey());
	}
}
