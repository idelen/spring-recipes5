package com.apress.springrecipes.shop.config;

import com.apress.springrecipes.shop.object.BannerLoader;
import com.apress.springrecipes.shop.object.Battery;
import com.apress.springrecipes.shop.object.Disc;
import com.apress.springrecipes.shop.object.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:discounts.properties")
@ComponentScan("com.apress.springrecipes.shop.object")
public class ShopConfiguration {

	@Value("${endofyear.discount:0}")
	private double specialEndofyearDiscountField;

	@Value("classpath:banner.txt")
	private Resource banner;

	@Bean
	public Product aaa() {
		Battery p1 = new Battery("AAA", 2.5);
		p1.setRechargeable(true);
		return p1;
	}

	@Bean
	public Product cdrw() {
		Disc p2 = new Disc("CD-RW", 1.5);
		p2.setCapacity(700);
		return p2;
	}

	@Bean
	public Product dvdrw() {
		Disc p2 = new Disc("DVD-RW", 3.0, specialEndofyearDiscountField);
		p2.setCapacity(700);
		return p2;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public BannerLoader bannerLoader() {
		BannerLoader bl = new BannerLoader();
		bl.setBanner(banner);
		return bl;
	}


}
