package com.info.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AuthFilter
 */
public class AuthFilter implements Filter {

  /**
   * Default constructor.
   */
  public AuthFilter() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @see Filter#destroy()
   */
  public void destroy() {
    // TODO Auto-generated method stub
  }

  /**
   * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
   */
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) request;
    String path = req.getRequestURI();

    System.out.println("你访问的资源路径是：" + req.getRequestURI());

    if (req.getSession().getAttribute("session_key") != null) {
      chain.doFilter(request, response);
      return;
    } else {

      if (path.indexOf("/userManager/") != -1) {
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.sendRedirect(req.getContextPath() + "/error.html");
        return;
      }

      chain.doFilter(request, response);
    }

  }

  /**
   * @see Filter#init(FilterConfig)
   */
  public void init(FilterConfig fConfig) throws ServletException {
    // TODO Auto-generated method stub
  }

}
