package com.jpcenzano.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jpcenzano.app.dto.ProductoDTO;

@Service
public class ProductoService {
	private static List<ProductoDTO> productos;
	private static Integer contador;
	
	static {
		productos = new ArrayList<>();
		productos.add(new ProductoDTO(1,"Televisor",3567.89,20));
		productos.add(new ProductoDTO(2,"Televisor",3567.89,20));
		productos.add(new ProductoDTO(3,"Televisor",3567.89,20));
		productos.add(new ProductoDTO(4,"Televisor",3567.89,20));
		productos.add(new ProductoDTO(5,"Televisor",3567.89,20));
		contador = productos.size();
	}
	
	public List<ProductoDTO> getAll(){
		return productos;
	}
	
	public ProductoDTO getById(Integer id) {
		ProductoDTO dto = null;
		for(ProductoDTO bean : productos) {
			if(bean.getId() == id) {
				dto = bean;
				break;
			}
		}
		return dto;
	}
	
	public  ProductoDTO create (ProductoDTO dto) {
		dto.setId(++contador);
		productos.add(dto);
		return dto;
	}
	
	public ProductoDTO Update(ProductoDTO dto) {
		ProductoDTO obj = null;
		for(ProductoDTO bean: productos) {
			if(bean.getId() == dto.getId()) {
				bean.updateData(dto);
				obj = bean;
				break;
			}
		}
		return obj;
	}
	
	
	public ProductoDTO updatePartial(ProductoDTO dto) {
		ProductoDTO obj = null;
		for(ProductoDTO bean: productos) {
			if(bean.getId() == dto.getId()) {
				if(!dto.getNombre().isBlank()) bean.setNombre(dto.getNombre());
				if(dto.getPrecio()!=null) bean.setPrecio(dto.getPrecio());
				if(dto.getStock()!=null) bean.setStock(dto.getStock());
				obj = bean;
				break;
			}
		}
		return obj;
	}
	
	public void delete(Integer id) {
		for(ProductoDTO bean: productos) {
			if(bean.getId() == id) {
				productos.remove(bean);
				break;
			}
		}
	}

}

