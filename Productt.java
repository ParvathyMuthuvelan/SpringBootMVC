package com.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.NumberFormat;

public class Productt {
	@NotNull(message = "NotNull.product.productPrice")
	@NumberFormat(pattern="[0-9]+(\\\\.){0,1}[0-9]*")
	//@Pattern(regexp = "[0-9]+(\\.){0,1}[0-9]*",message="price should be a number")
	private Double productPrice;
	private String productType;

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

}
