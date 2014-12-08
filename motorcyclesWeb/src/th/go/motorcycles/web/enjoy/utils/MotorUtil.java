package th.go.motorcycles.web.enjoy.utils;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import th.go.motorcycles.app.enjoy.utils.EnjoyUtils;

public class MotorUtil extends EnjoyUtils {
	private HttpServletRequest  request;
    private HttpServletResponse response;
    
    
    public MotorUtil() {
        
    }
    
    public MotorUtil(HttpServletRequest  request, HttpServletResponse response) {
        this.request    = request;
        this.response   = response;
    }
     
    public void writeMSG(String msg){
        PrintWriter            print                   = null;
        try{
           response.setContentType("text/html");
           print = this.response.getWriter();
           print.write(msg);
        }catch (Exception e) {
           e.printStackTrace();
        }
   }
    
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public HttpServletResponse getResponse() {
        return response;
    }
}
