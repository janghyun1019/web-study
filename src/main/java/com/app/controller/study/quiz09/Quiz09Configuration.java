package com.app.controller.study.quiz09;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Quiz09Configuration {

	@Bean
	public CoffeeBean coffeeBean() {
		
		CoffeeBean coffeeBean = new CoffeeBean();
		coffeeBean.setName("민트초코프라페");
		
		return coffeeBean;
	}
	
	@Bean
	public CupBean cupBean(CoffeeBean coffeeBean) {
		return new CupBean(coffeeBean);
	}
	
	@Bean
	public DessertBean dessertBean() {
		DessertBean dessertBean = new DessertBean();
		dessertBean.setName("당근케이크");
		return dessertBean;
	}
	
	@Bean
	PlateBean plateBean(DessertBean dessertBean) {
		PlateBean plateBean = new PlateBean();
		plateBean.setDessertBean(dessertBean);
		return plateBean;
	}
	
}
