package com.gestion.fiscalia.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.fiscalia.modelo.Fiscalia;
import com.gestion.fiscalia.repositorio.FiscaliaRepositorio;

@Service
public class FiscaliaServicio {

	// inyectamos el repositorio
	@Autowired
	private FiscaliaRepositorio repositorio;

	public List<Fiscalia> listarFiscalias() {
		return repositorio.findAll();

	}

	public void guardarFiscalia(Fiscalia fiscalia) {

		repositorio.save(fiscalia);
	}

	public Fiscalia obtenerFiscaliaPorId(Integer id) {

		return repositorio.findById(id).get();
	}

	public void eliminarFiscalia(Integer id) {

		repositorio.deleteById(id);
	}

}
