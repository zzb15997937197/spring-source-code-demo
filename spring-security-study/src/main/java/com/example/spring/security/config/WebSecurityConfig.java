package com.example.spring.security.config;

import com.example.spring.security.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {



    @Autowired
    private CustomUserDetailsService userDetailsService;


    /**
     * AuthenticationManagerBuilder的作用，认证管理器，主要给要访问的请求进行认证并控制访问
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //给密码加密
        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return s.equals(charSequence.toString());
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
// 如果有允许匿名的url，填在下面
// .antMatchers().permitAll()
                .anyRequest().authenticated()
                .and()
// 设置登陆页
                .formLogin().loginPage("/login")
// 设置登陆成功页
                .defaultSuccessUrl("/").permitAll()
// 自定义登陆用户名和密码参数，默认为username和password
// .usernameParameter("username")
// .passwordParameter("password")
                .and()
                .logout().permitAll();

// 关闭CSRF跨域
        http.csrf().disable();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
// 设置拦截忽略文件夹，可以对静态资源放行,使用antMatchers对资源目录进行放行，*号可以匹配多个
        web.ignoring().antMatchers("/css/**", "/js/**");
    }


}