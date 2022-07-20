package com.Synoc.store.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Synoc.store.Model.Producto;
import com.Synoc.store.Repository.ProductoRepository;

//IMPLEMENTAMOS EL INTERFACE DE PRODUCTOSERVICE-------------
@Service
public class ProductoServiceImpl implements ProductoService{
	
	
	
	//USAMOS LA ANOTACION AUTOWIRE PARA INYECTAR EL PRODUCTOREPOSITORY
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public Producto save(Producto producto) {
		//AQUI VAMOS UTILIZAR EL productoRepository . SAVE Y PASAMOS EL  .save(producto)
		return productoRepository.save(producto);
	}

	@Override
	public Optional<Producto> get(Integer id) {
		//AQUI VAMOS UTILIZAR EL productoRepository . FIND ID PARA BUSAR Y PONEMOS EL ID
		return productoRepository.findById(id);
	}

	@Override
	public void update(Producto producto) {
		
		//ESTE METODO ES PARA ACTUALIZAR EL PRODUCTO
		 productoRepository.save(producto);
		
	}

	@Override
	public void delete(Integer id) {
		//METODO PARA ELIMINAR POR EL ID
	productoRepository.deleteById(id);
		
	}

	@Override
	public List<Producto> findAll() {
		//UTILIZAMOS EL OBJETO PRODUCTO REPOSITORY Y HACEMOS EL USO DEL FINDALL();
		return productoRepository.findAll();
	}

	
}
