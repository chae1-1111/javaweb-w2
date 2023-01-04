package org.zerock.w2.filter;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.service.MemberService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Log4j2
@WebFilter(urlPatterns = {"/todo/*"})
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Login check filter.......");

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        HttpSession session = req.getSession();

        if(session.getAttribute("loginInfo") != null){
            chain.doFilter(request, response);
            return;
        }

        Cookie cookie = findCookie(req.getCookies(), "remember-me");

        if(cookie == null) {
            resp.sendRedirect("/login");
            return;
        }

        String uuid = cookie.getValue();

        try {
            MemberDTO memberDTO = MemberService.INSTANCE.getByUUID(uuid);

            log.info("자동로그인 사용자 조회 결과: "+ memberDTO);

            if(memberDTO == null) {
                throw new Exception("Cookie value is invalid");
            }

            session.setAttribute("loginInfo",memberDTO);
            chain.doFilter(request, response);

        } catch (Exception e ) {
            e.printStackTrace();
            resp.sendRedirect("/login");
        }


    }

    private Cookie findCookie(Cookie[] cookies, String name) {

        if(cookies == null || cookies.length == 0) {
            return null;
        }

        Optional<Cookie> result = Arrays.stream(cookies)
                .filter(ck -> ck.getName().equals(name))
                .findFirst();

        return result.isPresent() ? result.get() : null;
    }
}
