package filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class LogFileFilter implements Filter {

   PrintWriter writer;
   
   public void init(FilterConfig config) throws ServletException{
      String filename = config.getInitParameter("filename");
      
      if(filename==null)
         throw new ServletException("로그 파일의 이름을 찾을 수 없습니다.");
      
      try {
         writer = new PrintWriter(new FileWriter(filename,true), true);
         }catch(IOException e) {
            throw new ServletException("로그 파일을 열 수 없습니다.");
         }
   }

   public void doFilter(ServletRequest request, ServletResponse response,
         FilterChain chain) throws java.io.IOException, ServletException{
      
      writer.println("접속한 클라이언트 IP : " + request.getRemoteAddr());
      long start = System.currentTimeMillis();
      writer.println(" 접근한 URL 경로 : " + getURLPath(request));
      writer.println(" 요청 처리 시작 시각 :" + getCurrentTime());
      chain.doFilter(request, response);
      
      long end = System.currentTimeMillis();
      writer.println(" 요청 처리 종료 시각 : " + getCurrentTime());
      writer.println(" 요청 처리 소요 시간 : " + (end-start) + "ms ");
      writer.println(" ===========================================");
   }
   public void destroy() {
      writer.close();
   }
   
   private String getURLPath(ServletRequest request) {
      HttpServletRequest req;
      String currentPath = "";
      String queryString = "";
      if(request instanceof HttpServletRequest) {
         req = (HttpServletRequest) request;
         currentPath = req.getRequestURI();
         queryString = req.getQueryString();
         queryString = queryString == null ? "" : "?" + queryString;
         
         }
      return currentPath + queryString;
      }
      private String getCurrentTime() {
         DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         Calendar calendar = Calendar.getInstance();
         calendar.setTimeInMillis(System.currentTimeMillis());
         return formatter.format(calendar.getTime());
   }
   
   

}