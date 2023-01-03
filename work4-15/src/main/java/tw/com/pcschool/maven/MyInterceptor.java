package tw.com.pcschool.maven;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class MyInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// preHandle返回 布林
		
		System.out.println("執行 MyInterceptor 的 preHandle 方法");
		response.setStatus(401);
		return false;
	}
	
	
	

}
