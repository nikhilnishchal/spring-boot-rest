package com.niknis.cms.security.jwt;


import static com.niknis.cms.security.jwt.SecurityConstants.HEADER_STRING;
import static com.niknis.cms.security.jwt.SecurityConstants.SECRET;
import static com.niknis.cms.security.jwt.SecurityConstants.TOKEN_PREFIX;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;


public class JWTAuthorizationFilter  extends BasicAuthenticationFilter {
    public JWTAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }
    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        try{
        /*	String header = req.getHeader(HEADER_STRING);
        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, response);
            return;
        }*/
        Authentication authentication = getAuthentication(req);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, response);
    }catch(ExpiredJwtException expiredJWTException){
		//  e.printStackTrace();
		  SecurityContextHolder.getContext()
	        .setAuthentication(null);
		  response.setContentType("application/json; charset=UTF-8");
	      PrintWriter printout = response.getWriter();
	      List<String> key = new ArrayList<String>();
	      List<String> val = new ArrayList<String>();
	      key.add("Status");val.add("Fail");
	      key.add("Message");val.add("JWT Token Expired!Please Login Again");
	      printout.print(getResponce(key, val));
	      printout.flush();
	  }catch (SignatureException misMatchJWTException) {
		// TODO: handle exception
		  SecurityContextHolder.getContext()
	        .setAuthentication(null);
		  response.setContentType("application/json; charset=UTF-8");
	      PrintWriter printout = response.getWriter();
	      List<String> key = new ArrayList<String>();
	      List<String> val = new ArrayList<String>();
	      key.add("Status");val.add("Fail");
	      key.add("Message");val.add("JWT Token Invalid");
	      printout.print(getResponce(key, val));
	      printout.flush();
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println("exception occured::"+e.toString());
		e.printStackTrace();
		 SecurityContextHolder.getContext()
	        .setAuthentication(null);
		  response.setContentType("application/json; charset=UTF-8");
	      PrintWriter printout = response.getWriter();
	      List<String> key = new ArrayList<String>();
	      List<String> val = new ArrayList<String>();
	      key.add("Status");val.add("Fail");
	      key.add("Message");val.add("Error During JWT Token Validation.");
	      printout.print(getResponce(key, val));
	      printout.flush();
	}
    }
    private Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }
    
    public static String getResponce(List<String> key,List<String> value){
		JSONObject responce = new JSONObject();
	   try{
			Iterator<String> i1= key.iterator();
		    Iterator<String> i2= value.iterator();
			
		    while(i1.hasNext() && i2.hasNext()){
		    	responce.put(i1.next(), i2.next());
		    }
		    return responce.toString();
	   }catch(Exception e){
		   try {
			   		responce.put("Error", "Error while Creating responce: "+e.toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	   }
		return "";
		
	}
	
	public static String getResponce(String key,String val){
		JSONObject responce = new JSONObject();
		try {
			responce.put(key, val);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responce.toString();
	}
}
