package com.auc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.auc.common.filter.AucFilter;

@MapperScan(basePackages = "com.auc.**.*Impl")
@SpringBootApplication
@EnableScheduling
public class BrAuctionApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(BrAuctionApplication.class, args);
	}
	
	@Override 
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) 
	{ return builder.sources(BrAuctionApplication.class); }
	
	@Bean
	public FilterRegistrationBean setFilterRegistration() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new AucFilter());
		// filterRegistrationBean.setUrlPatterns(Collections.singletonList("/filtered/*")); // list 를 받는 메소드
		filterRegistrationBean.addUrlPatterns("/*"); // string 여러개를 가변인자로 받는 메소드
		
		return filterRegistrationBean;
	}
	

}
