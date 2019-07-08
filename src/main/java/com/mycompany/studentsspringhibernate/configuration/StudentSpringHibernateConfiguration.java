package com.mycompany.studentsspringhibernate.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
// auti i klasi den einai kati sygkekrimeno (model,view,controller)
// einai apla configuration class
// antistoixo tou web.xml !!!!!!!!!!!!
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mycompany.studentsspringhibernate")
public class StudentSpringHibernateConfiguration {
	
	@Bean(name="studentsSpringHibernate")
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

}