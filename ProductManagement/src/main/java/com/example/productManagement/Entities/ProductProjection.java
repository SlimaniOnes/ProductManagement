package com.example.productManagement.Entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomProd", types = { Product.class })
public interface ProductProjection {
	public String getNomProduct();

}
