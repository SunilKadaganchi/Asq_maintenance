package dev.sunil.Asq.maintenance.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        //get the token from the request
        String token = getToken(request);
        //check the token either it is valid or not
        if(StringUtils.hasText(token) && jwtTokenProvider.validateToken(token)) {
            //load the user and set the Authentication
            String email = jwtTokenProvider.getEmailFromToken(token);
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request,response);


    }

    private String getToken(HttpServletRequest request){
        String token = request.getHeader("Authorization");

        if(StringUtils.hasText(token)  && (token.startsWith("Bearer "))){
            token = token.substring(7);
            return token;
        }
        return null;
    }
}
