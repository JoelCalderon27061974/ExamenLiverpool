package com.mx.liverpool.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.liverpool.dao.ArticuloDAO;
import com.mx.liverpool.entity.Articulo;

@RestController
@RequestMapping("articulos")
public class ArticulosREST {
	
	@Autowired
	private ArticuloDAO articuloDAO;
	
	@GetMapping
	public ResponseEntity<List<Articulo>> getArticulos(){
		List <Articulo>  contigo = articuloDAO.findAll();
		
		return ResponseEntity.ok(contigo);
	}
	
	@RequestMapping(value="{articuloId}")
	public ResponseEntity<Articulo> getArticuloById(@PathVariable("articuloId") Long articuloId){
		Optional<Articulo>  optionalArticulo = articuloDAO.findById(articuloId);
		
		if(optionalArticulo.isPresent()) {
			return ResponseEntity.ok(optionalArticulo.get()); 
		}else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Articulo> createArticulo(@RequestBody Articulo articulo){
		Articulo newArticulo = articuloDAO.save(articulo);
		
		return ResponseEntity.ok(newArticulo);	
		
	}
	
	@DeleteMapping(value="{articuloId}")
	public ResponseEntity<Void> deleteArticulo(@PathVariable("articuloId") Long articuloId){
		articuloDAO.deleteById(articuloId);
		
		return ResponseEntity.ok(null);	
		
	}
	
	@PutMapping
	public ResponseEntity<Articulo> updateArticulo(@RequestBody Articulo articulo){
	
		Optional<Articulo>  optionalArticulo = articuloDAO.findById(articulo.getId());
		if(optionalArticulo.isPresent()) {
			Articulo updateArticulo =optionalArticulo.get();
//			updateArticulo.setNombre(articulo.getNombre()); //SE COLOCA ASI YA QUE INDICAN EN EL EXAMEN QUE NO SE ACTUALICE 
			updateArticulo.setDescripcion(articulo.getDescripcion());
//			updateArticulo.setPrecio(articulo.getPrecio()); //SE COLOCA ASI YA QUE INDICAN EN EL EXAMEN QUE NO SE ACTUALICE 
			updateArticulo.setModelo(articulo.getModelo());
			articuloDAO.save(updateArticulo);
			return ResponseEntity.ok(optionalArticulo.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}

}
