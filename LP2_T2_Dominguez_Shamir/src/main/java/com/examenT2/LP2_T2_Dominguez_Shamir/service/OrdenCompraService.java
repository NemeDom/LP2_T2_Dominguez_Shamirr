package com.examenT2.LP2_T2_Dominguez_Shamir.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.LP2_T2_Dominguez_Shamir.dto.ResultadoResponse;
import com.examenT2.LP2_T2_Dominguez_Shamir.model.OrdenCompraDS;
import com.examenT2.LP2_T2_Dominguez_Shamir.repository.OrdenCompraRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdenCompraService {
	private final OrdenCompraRepository ordencompraRepository;

	public List<OrdenCompraDS> getAll() {
		return ordencompraRepository.findAllByOrderByNroOrdenDesc();
	}

	public ResultadoResponse create(OrdenCompraDS ordenCompraDS) {

		try {

			var registrado = ordencompraRepository.save(ordenCompraDS);

			var mensaje = String.format("Orden con Numero %d registrado", registrado.getNroOrden());

			return new ResultadoResponse(true, mensaje);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transaccion");
		}
		
		
	}
	public OrdenCompraDS getOne(Integer id) {
		return ordencompraRepository.findById(id).orElse(null);
	}

	public ResultadoResponse update(OrdenCompraDS ordenCompraDS) {

		try {

			var registrado = ordencompraRepository.save(ordenCompraDS);

			var mensaje = String.format("Orden con Numero %d actualizado", registrado.getNroOrden());

			return new ResultadoResponse(true, mensaje);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transaccion");
		}
	}
}
