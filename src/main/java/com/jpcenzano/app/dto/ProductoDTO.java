package com.jpcenzano.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProductoDTO implements Cloneable{
	private Integer id;
	private String nombre;
	private Double precio;
	private Integer stock;
	
	
	
	public void updateData(ProductoDTO source) {
		this.nombre = source.getNombre();
		this.precio = source.getPrecio();
		this.stock = source.getStock();
		
	}
	
	
	
}
