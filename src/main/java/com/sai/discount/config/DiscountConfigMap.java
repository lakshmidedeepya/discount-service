package com.sai.discount.config;

import java.util.HashMap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.sai.discount.model.ProductCategory;

import lombok.Data;
@Configuration
@ConfigurationProperties(prefix="discountdata")
@Component
@Data
public class DiscountConfigMap {
	public HashMap<ProductCategory, Double> map=new HashMap<ProductCategory, Double>();
}
