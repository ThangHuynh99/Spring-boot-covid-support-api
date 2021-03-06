//package com.spring.covidsupport.filter;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Configuration
//public class CorsFilter implements Filter {
//  private static final String ONE_HOUR = "3600";
//
//  @Override
//  public void init(FilterConfig filterConfig) throws ServletException {}
//
//  @Override
//  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//      throws IOException, ServletException {
//    HttpServletResponse response = (HttpServletResponse) res;
//    response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
//    response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
//    response.setHeader("Access-Control-Max-Age", ONE_HOUR);
//    response.setHeader("Access-Control-Request-Headers", "authorization,content-type");
//    response.setHeader(
//        "Access-Control-Allow-Headers",
//        "X-Requested-With,Origin,Content-Type, Accept, x-device-user-agent, Content-Type");
//
//    if (req instanceof HttpServletRequest) {
//      HttpServletRequest httpServletRequest = (HttpServletRequest) req;
//      if (httpServletRequest.getHeader(HttpHeaders.ORIGIN) != null
//          && httpServletRequest.getMethod().equals(HttpMethod.OPTIONS.name())
//          && httpServletRequest.getHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD) != null) {
//
//        return;
//      }
//    }
//    chain.doFilter(req, res);
//  }
//}
