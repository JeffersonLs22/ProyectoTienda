package com.Synoc.store.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Synoc.store.Model.Producto;
//HACEMOS UN ESTENDS DE JPA REPOSITORY  Y VAMOS A DECIRLE A QUE TABLA VA A USARSER ESE REPOSITRY QUE SERA METODO CRUD
//DE PRODUCTO  Y QUE TIPO DE DATOS SERA EL UPDATE O DELETE QUE SERA "INTEGER"

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {
	
	
	

}
