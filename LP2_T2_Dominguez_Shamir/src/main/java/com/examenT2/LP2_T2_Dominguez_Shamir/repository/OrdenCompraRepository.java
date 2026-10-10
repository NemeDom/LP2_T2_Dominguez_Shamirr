package com.examenT2.LP2_T2_Dominguez_Shamir.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.examenT2.LP2_T2_Dominguez_Shamir.model.OrdenCompraDS;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompraDS, Integer> {

	List<OrdenCompraDS> findAllByOrderByNroOrdenDesc();}
