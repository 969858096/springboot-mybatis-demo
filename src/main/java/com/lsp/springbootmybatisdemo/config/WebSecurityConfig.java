package com.lsp.springbootmybatisdemo.config;

import com.lsp.springbootmybatisdemo.impl.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2019-12-20 10:42
 * @version:1.0
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启方法权限控
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置拦截规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/page1/**").hasRole("admin1")
                .antMatchers("/page2/**").hasRole("admin2")
                .antMatchers("/page3/**").hasRole("admin3");
        // 配置登录功能
        http.formLogin().usernameParameter("userName")
                .passwordParameter("passWord")
                .loginPage("/home");
        // 注销成功跳转首页
        http.logout().logoutSuccessUrl("/home");
        //开启记住我功能
        http.rememberMe().rememberMeParameter("remeber");
    }


    /**
     * 自定义认证数据源
     */
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(userDetailService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public UserDetailServiceImpl userDetailService (){
        return new UserDetailServiceImpl() ;
    }
    /**
     * 密码加密
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

     /*
     * 硬编码几个用户
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("spring").password("123456").roles("LEVEL1","LEVEL2")
                .and()
                .withUser("summer").password("123456").roles("LEVEL2","LEVEL3")
                .and()
                .withUser("autumn").password("123456").roles("LEVEL1","LEVEL3");
    }
    */

}
