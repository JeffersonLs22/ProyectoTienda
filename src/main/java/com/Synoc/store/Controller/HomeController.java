package com.Synoc.store.Controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Synoc.store.Model.Producto;
import com.Synoc.store.Service.ProductoService;

@Controller
@RequestMapping("/")
public class HomeController {
	private final Logger log = LoggerFactory.getLogger(HomeController.class);	
	
	
	
	
	//ESTO ES PARA QUE NOS PERMITA OBTENER TODOS LOS PRODUCTOS
	//autowire es para injectar un contenedor del framework
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("productos", productoService.findAll());
		
		return "usuario/home";
	}
	@GetMapping("productohome/{id}")
	public String productoHome(@PathVariable Integer id,Model model) {
		log.info("Id Enviado como parametro {}",id);
		Producto producto = new Producto();
		Optional<Producto> productoOptional= productoService.get(id);
		producto = productoOptional.get();
		
		model.addAttribute("producto",producto);
		return "usuario/productohome";
		
	}
	@PostMapping("/cart")
	public String addcart() {
		
		return "usuario/carrito";
	}
	
	
	
	
	
}
