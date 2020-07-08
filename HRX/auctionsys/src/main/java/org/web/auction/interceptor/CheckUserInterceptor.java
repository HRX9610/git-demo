package org.web.auction.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CheckUserInterceptor implements HandlerInterceptor {
	//调用handler之前调用
	//返回值: 
	//1.true 放行 -->当前postHandle()--->当前afterCompletion(),进一步执行后一个拦截器
	//2.false 不放行(拦截) , 不执行postHandle(),postHandle(),后面的拦截器和controller都不执行
	//应用场景： 检测用户是否登录（合法）
	@Override 
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		
		HttpSession session = req.getSession();
		
		//先获取请求路径 ，检查是否是做登录业务
		String path = req.getRequestURI();
		
		if (session.getAttribute("user") != null) { //已经登录, 放行
			System.out.println("用户身份合法......");
			return true;
		} else {
			System.out.println("拦截了一个非法请求！");
			//登录页面
			res.sendRedirect("login");
			return false;
		}
		
	}

    //进入handler方法，调用完，但没返回ModelAndview时调用
	//应用场景： 在公用模块中集中处理ModelAndView的数据,还没有返回视图时!
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView mv)
			throws Exception {
	}

	//完全执行完handler方法时调用，执行的时机比postHandle()迟一些
	//应用场景：记录日志
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

}
