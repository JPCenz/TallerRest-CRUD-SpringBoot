package com.jpcenzano.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpcenzano.app.dto.ProductoDTO;
import com.jpcenzano.app.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	ProductoService productoService;
	
	@GetMapping
	public List<ProductoDTO> getAll() {
		return productoService.getAll();
	}
	
	@GetMapping("/{id}")
	public ProductoDTO getById(@PathVariable String id) {
		return productoService.getById(Integer.valueOf(id));
	}
	
	@PostMapping()
	public ProductoDTO crear(@RequestBody ProductoDTO dto) {
		return productoService.create(dto);
	}
	
	@PutMapping("/{id}")
	public ProductoDTO update(@PathVariable Integer id, @RequestBody ProductoDTO dto) {
		dto.setId(id);
		return productoService.Update(dto);
	}
	
	@PatchMapping("/{id}")
	public ProductoDTO updatePartial(@PathVariable Integer id, @RequestBody ProductoDTO dto) {
		dto.setId(id);
		return productoService.updatePartial(dto);
	}
  
  	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		productoService.delete(id);
	}



}
