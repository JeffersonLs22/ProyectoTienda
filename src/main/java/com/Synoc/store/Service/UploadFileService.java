package com.Synoc.store.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
//anotacion para que esta clase sea como servicio
@Service
public class UploadFileService {
	//vamos a declarar una varibale de tipo string para localizar el folder donde estaran almacendas las imagenes de los productos 
	private String folder="images//";

	//parametro tendra multi partfile para guardar las imagenes
	public String saveImages(MultipartFile file) throws IOException {
		//SI NO ESTA VACIO-------------
		if(!file.isEmpty()) {
			//ARRELO DE TIPO BYTE QUE SE LLAMARA BYTES Y SERA FILE. GET BYTES
			byte[] bytes=file.getBytes();
			//UBICACION PARA GUARDAR LAS IMAGENES
			Path path = Paths.get(folder+file.getOriginalFilename());
			//ruta de envio
			//path es la ruta y bytes transforma las imganees en bytes para poder enviar al servidor
			Files.write(path, bytes);
			//hay que retornar el nombre de la imagen que subimos
			return file.getOriginalFilename();
		}
		//QUE PASA SI EL USUARIO NO CARGA LA IMAGEN , VAMOS SUBIR COMO UNA IMAGEN POR DEFECTO , CUANDO NO SEA ASIGNADO RETORNARA UNA IMAGEN POR DEFAULT
		return "default.jpg";
	}
	//METODO PARA ELIMINAR IMAGEN CUANDO ELIMINEMOS UN PRODUTO
	//String del nombre de la imagen
	public void deleteImage(String nombre) {
		//creamos una varible ruta que va guardar la ruta de imagen 
		String ruta="images//";
		//varibale de tipo File y tenga la ruta mas el nombre 
		File file = new File(ruta+nombre);
		//ya con estos eleminamos la imagen cuando eliminemos el producto
		 file.delete();
		
		
		
	}
	
}
