package com.lsp.springbootmybatisdemo.config;

import com.lsp.springbootmybatisdemo.entity.Permission;
import com.lsp.springbootmybatisdemo.handler.MyAuthenticationFailureHandler;
import com.lsp.springbootmybatisdemo.handler.MyAuthenticationSuccessHandler;
import com.lsp.springbootmybatisdemo.impl.MyUserDetailService;
import com.lsp.springbootmybatisdemo.impl.PermissonImpl;
import com.lsp.springbootmybatisdemo.mapper.PermissionMapper;
import com.lsp.springbootmybatisdemo.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2019-12-20 10:42
 * @version:1.0
 **/
@Component
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyAuthenticationFailureHandler failureHandler;
    @Autowired
    private MyAuthenticationSuccessHandler successHandler;
    @Autowired
    private PermissonImpl permissionMapper;
    @Autowired
    private MyUserDetailService myUserDetailService;

    //--------------------------------------------------动态连接数据库的认证授权-----------------------------------------------------

    // 配置认证用户信息和权限
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(new PasswordEncoder() {

            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                String encode = MD5Util.encode((String) rawPassword);//把用户提交的密码进行加密
               encodedPassword=encodedPassword.replace("\r\n", "");//从数据库中获取的密码含有\r\n,去掉
                return encodedPassword.equals(encode);//返回比较结果
            }

            public String encode(CharSequence rawPassword) {
                return MD5Util.encode((String) rawPassword);
            }
        });
    }

    // 配置拦截请求资源
    protected void configure(HttpSecurity http) throws Exception {
        List<Permission> listPermission = permissionMapper.findAllPermission();
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests = http
                .authorizeRequests();
        for (Permission permission : listPermission) {
            authorizeRequests.antMatchers(permission.getUrl()).hasAnyAuthority(permission.getPermTag());
        }
        authorizeRequests.antMatchers("/login").permitAll()//允许所有请求请求该接口
                        .antMatchers("/failure").permitAll()//允许所有请求请求该接口
                        .antMatchers("/**").fullyAuthenticated().and()//拦截所有请求
                        .formLogin().loginPage("/login")//自定义登陆页面
                        .successHandler(successHandler).failureHandler(failureHandler).and()//登陆成功 登陆失败跳转
                        .csrf().disable();//去掉token

    }




    //--------------------------------------------------写死的权限认证授权-----------------------------------------------------
    /**
     * 自定义认证数据源
     */
   /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("admin").password("123456").authorities("showOrder","addOrder","updateOrder","deleteOrder");
        auth.inMemoryAuthentication().withUser("user").password("123456").authorities("addOrder");
    }
    //设置拦截
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()//不拦截登陆页面，允许所有的请求通过
                .antMatchers("/failure").permitAll()//不拦截登陆页面，允许所有的请求通过
                .antMatchers("/showOrder").hasAnyAuthority("showOrder")//配置权限路径以及权限名
                .antMatchers("/addOrder").hasAnyAuthority("addOrder")//配置权限路径以及权限名
                .antMatchers("/updateOrder").hasAnyAuthority("updateOrder")//配置权限路径以及权限名
                .antMatchers("/deleteOrder").hasAnyAuthority("deleteOrder")//配置权限路径以及权限名
                .antMatchers("/**").fullyAuthenticated().and().formLogin().loginPage("/login")//拦截所有资源,配置登录页面
                .successHandler(successHandler).failureHandler(failureHandler)//配置登录成功与失败的跳转
                .and().csrf().disable();//禁掉跨站token
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }*/



}
