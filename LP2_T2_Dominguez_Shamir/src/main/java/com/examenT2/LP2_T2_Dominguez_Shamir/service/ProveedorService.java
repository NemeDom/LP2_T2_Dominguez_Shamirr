package com.examenT2.LP2_T2_Dominguez_Shamir.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.LP2_T2_Dominguez_Shamir.model.ProveedorDS;
import com.examenT2.LP2_T2_Dominguez_Shamir.repository.ProveedorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorService {
	private final ProveedorRepository proveedorRepository;
	
	public List<ProveedorDS> getAll(){
		return proveedorRepository.findAll();
	}
}
