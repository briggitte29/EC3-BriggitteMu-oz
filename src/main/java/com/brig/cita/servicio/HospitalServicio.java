package com.brig.cita.servicio;

import java.util.List;

import com.brig.cita.DTO.HospitalDTORequest;
import com.brig.cita.DTO.HospitalDTOResponse;

public interface HospitalServicio {

	public void guardarHospital(HospitalDTORequest hospital);
	public void editarHospital(HospitalDTORequest hospital);
	
	public void eliminarHospital(Integer id);
	
	public List<HospitalDTOResponse> listarHospital();
	public HospitalDTOResponse obtenerHospitalId(Integer id);
}
