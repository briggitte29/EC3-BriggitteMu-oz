package com.brig.cita.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.brig.cita.DTO.HospitalDTORequest;
import com.brig.cita.DTO.HospitalDTOResponse;
import com.brig.cita.models.Hospital;
import com.brig.cita.repository.HospitalRepository;

@Service
public class HospitalServicioImpl implements HospitalServicio {

	public HospitalRepository repositorio;
	
	@Override
	public void guardarHospital(HospitalDTORequest hospital) {
		
		Hospital h= new Hospital();
		h.setNombre(hospital.getNombreDTO());
		h.setIdHospital(hospital.getIdHospitalDTO());
		h.setDescripcion(hospital.getDescripcionDTO());
		h.setDistrito(hospital.getDistritoDTO());
		
		repositorio.save(h);

	}

	@Override
	public void editarHospital(HospitalDTORequest hospital) {
		
		Hospital h= new Hospital();
		h.setNombre(hospital.getNombreDTO());
		h.setIdHospital(hospital.getIdHospitalDTO());
		h.setDescripcion(hospital.getDescripcionDTO());
		h.setDistrito(hospital.getDistritoDTO());
		
		repositorio.saveAndFlush(h);

	}

	@Override
	public void eliminarHospital(Integer id) {
		
		repositorio.deleteById(id);

	}

	@Override
	public List<HospitalDTOResponse> listarHospital() {
		
		List<HospitalDTOResponse> lista= new ArrayList<HospitalDTOResponse>();
		HospitalDTOResponse h =null;
		
		for(Hospital hospital: repositorio.findAll()) {
			
			h= new HospitalDTOResponse();
			
			h.setNombreDTO(hospital.getNombre());
			h.setIdHospitalDTO(hospital.getIdHospital());
			h.setDescripcionDTO(hospital.getDescripcion());
			h.setDistritoDTO(hospital.getDistrito());
			
			lista.add(h);
			
		}
		
		return lista;
	}

	@Override
	public HospitalDTOResponse obtenerHospitalId(Integer id) {
			
		Hospital hospital=repositorio.findById(id).orElse(null);
		HospitalDTOResponse h= new HospitalDTOResponse();
		
		h.setNombreDTO(hospital.getNombre());
		h.setIdHospitalDTO(hospital.getIdHospital());
		h.setDescripcionDTO(hospital.getDescripcion());
		h.setDistritoDTO(hospital.getDistrito());
		
		return h;
	}

}
