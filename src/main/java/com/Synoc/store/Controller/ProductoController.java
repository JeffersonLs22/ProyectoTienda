package com.Synoc.store.Controller;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Synoc.store.Model.Producto;
import com.Synoc.store.Model.Usuario;
import com.Synoc.store.Service.ProductoService;
import com.Synoc.store.Service.UploadFileService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	//ESTO VA CREARSE ATRAVES DE UNA CLASE LLAMADA LOGERFACTORY ---------------------
	
	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
	//es un objeto---------------------------
	@Autowired
	private ProductoService productoService;
	@Autowired
	private UploadFileService upload;
	

	
	
	@GetMapping("")
//parametro un obsjeto de tipo MODEL esto pasara un informacion desde el BACKEND HACIA LA VISTA
	public String Show(Model model) {
		//INVOCAMOS AL METODO ARTIBUTE HACEMO REFERENCIA A PRODUCTOS, LUEGO LA LISTA DE PRODUCTO SERVICE FINDALL
		model.addAttribute("productos",productoService.findAll());
		return "producto/manager";
	}
	
	
//redireccionamos a producto y va a cargar la vista show
//vamos a recibir un objeto de tipo producto e importamos la clase
	@PostMapping("/save")//EL "IMG" ESTA EN LA PAGINA CREATE--------------------------
	public String save(Producto producto ,@RequestParam("img") MultipartFile file) throws IOException {
		//esta linea de cosigo es para un pruba en la consola, del toString en producto
		LOGGER.info("Esto es el objeto producto {} ",producto);
		//DEL PRODUCTO SERVICE QUE TIENE COMO AUTOWIRED USAMOS EL METODO GUARDAR
		Usuario u=new Usuario(1, "","", "","", "", "", "", "");
		producto.setUsuario(u);
//LINEA DE CODIGO PARA GUARDAR LAS IMAGENES------------------------------------------------------------------
		if(producto.getId()== null) {//esta validaciones cuadno se crea un producto----siemrpe sera ull------
			String nombreimagen= upload.saveImages(file);
			producto.setImagen(nombreimagen);
		}else {
			
		}
		
		
		
		//METODO PARA GUARDAR EL PRODUCTO
		productoService.save(producto);
		//METODO PARA REDIRECCIONAR  LA PAGINA AL GUARDAR
		return "redirect:/producto";
		
		
		
		
		
	}
	
	@GetMapping("/edit/{id}")
	//AÑADIMOS COMO OBSJETO TIPO MODEL PARA el bakend
	public String edith(@PathVariable Integer id,Model model) {
		Producto producto = new Producto();
		Optional<Producto> optionalProducto=productoService.get(id);
		producto= optionalProducto.get();
		
		LOGGER.info("Prodcto bucado: {}",producto);
		//ESTO NOS VA ENVIAR ALA VISTA TODO EL OBSJETO QUE LO HA BUSCADO
		
		model.addAttribute("producto",producto);
		return "productos/edit";
	}
	//METODO POST , ES UN REDIRECT QUE AL MOMENTO DE ACTUALIZAR VA A REDIRECCIONAR A PRODUCTOS
	//ESTE METODO VA A RECIBIR COMO PARAMETRO UN OBJETO DE TIPO PRODUCTO
	@PostMapping("/update")
	public String update(Producto producto,@RequestParam("img") MultipartFile file) throws IOException {
		
		
		Producto p = new Producto();
		p= productoService.get(producto.getId()).get();
		if(file.isEmpty()) {//cuando editamos elproducto pero no cambiamos el imagen 
			
			producto.setImagen(p.getImagen());
			}else {
				if(!p.getImagen().equals("default.jpg")) {
					
					upload.deleteImage(p.getImagen());
				}
				
				String nombreimagen= upload.saveImages(file);
				producto.setImagen(nombreimagen);
			}
		producto.setUsuario(p.getUsuario());
		productoService.update(producto);
		return "redirect:/productos";
	}
	
	//la terminacion de url que nos va traer un id para obtener el id que queremos eliminar
	@GetMapping("/delete/{id}")
	//variable de integer id
	//esto va tener una anotacion phatvarubale que haga el mapeo de la variable que viene en la url y que la pase  en id
	public String delete(@PathVariable Integer id) {
		
		Producto p = new Producto();
		p=productoService.get(id).get();
		//si la imagen que esta n es el default
		//esto es para elimnar cuando la imagen no sea por defecto
		if(!p.getImagen().equals("default.jpg")) {
			
			upload.deleteImage(p.getImagen());
		}
		
	//	ahora ponemos el producto service y le ponemos el id
		productoService.delete(id);
		return "redirect:/productos";
	}

}
