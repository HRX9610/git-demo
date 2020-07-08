package org.web.auction.shiro;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override  // 先校验验证码
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        //生成的随机数
        String validateCode = req.getParameter("valideCode");
        //用户输入 的验证码
        String randNum = (String)session.getAttribute("vrifyCode");

        if (validateCode != null && randNum != null && !validateCode.equals(randNum)) {
            request.setAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, "InValidateCode");
            return true;  //不再 调用Realm  ---> login controller
        }

        return super.onAccessDenied(request, response);  // 执行默认操作  ： 调用realm
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
                                     ServletResponse response) throws Exception {
        WebUtils.getAndClearSavedRequest(request);
        WebUtils.redirectToSavedRequest(request, response, "/queryAuctions");
        return false;
    }
}
