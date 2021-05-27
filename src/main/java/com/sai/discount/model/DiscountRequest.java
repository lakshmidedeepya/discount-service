package com.sai.discount.model;

import java.io.Serializable;


import com.sai.discount.model.ProductCategory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DiscountRequest implements Serializable{
	private static final long serialVersionUID = 5093689614568882151L;
	public ProductCategory category;
	public double mrp;
}
