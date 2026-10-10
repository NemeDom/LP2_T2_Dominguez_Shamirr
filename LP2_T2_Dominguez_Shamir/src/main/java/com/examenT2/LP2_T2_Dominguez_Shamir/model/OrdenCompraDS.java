package com.examenT2.LP2_T2_Dominguez_Shamir.model;


import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_orden_compra")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class OrdenCompraDS {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nro_orden")
	private Integer nroOrden;
	
	@Column(name="fecha_entrega")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaEntrega;
	
	@Column(name = "monto")
	private BigDecimal monto;
	

	@Column(name="estado")
	private String estado;

	@Column(name="direccion_entrega")
	private String direccionEntrega;
	
	@ManyToOne
	@JoinColumn(name = "id_producto")
	private ProveedorDS proveedor;
	

}
