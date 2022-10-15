package com.gestion.fiscalia.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.fiscalia.Servicio.FiscaliaServicio;
import com.gestion.fiscalia.modelo.Fiscalia;

@CrossOrigin(originPatterns = {"http://localhost:3000"}) //acceso a datos React
@RestController
public class FiscaliaController {

	
	//Api rest
	@Autowired
	private FiscaliaServicio servicio;
	
	@GetMapping("api/fiscalias")
	public List<Fiscalia> listarFiscalias(){
		return servicio.listarFiscalias();
	}
	
	@GetMapping("api/fiscalias/{id}")
	public ResponseEntity<Fiscalia> obtenerFiscalia(@PathVariable Integer id) {
		try {
			Fiscalia fiscalia = servicio.obtenerFiscaliaPorId(id);
			return new ResponseEntity<Fiscalia>(fiscalia,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Fiscalia>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("api/fiscalias")
	@ResponseStatus(HttpStatus.CREATED)
	public void guardarFiscalias(@RequestBody Fiscalia fiscalia) {
		servicio.guardarFiscalia(fiscalia);
	}
	
	@PutMapping("api/fiscalias/{id}")
	public ResponseEntity<?> actualizarFiscalia(@RequestBody Fiscalia fiscalia, @PathVariable Integer id){
		try {
			
			Fiscalia fiscaliaActual = servicio.obtenerFiscaliaPorId(id);
			
			fiscaliaActual.setNombre(fiscalia.getNombre());
			fiscaliaActual.setMunicipio(fiscalia.getMunicipio());
			fiscaliaActual.setDireccion(fiscalia.getDireccion());
			fiscaliaActual.setTelefono(fiscalia.getTelefono());
			
			
			servicio.guardarFiscalia(fiscaliaActual);
			return new ResponseEntity<Fiscalia>(HttpStatus.OK);
			
		}catch(Exception excepcion){
			return new ResponseEntity<Fiscalia>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("api/fiscalias/{id}")
	public void EliminarFiscalia(@PathVariable Integer id) {
		servicio.eliminarFiscalia(id);
	}
	
}
