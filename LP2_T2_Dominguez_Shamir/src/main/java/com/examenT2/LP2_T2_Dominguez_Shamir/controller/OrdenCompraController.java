package com.examenT2.LP2_T2_Dominguez_Shamir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examenT2.LP2_T2_Dominguez_Shamir.model.OrdenCompraDS;
import com.examenT2.LP2_T2_Dominguez_Shamir.service.OrdenCompraService;
import com.examenT2.LP2_T2_Dominguez_Shamir.service.ProveedorService;
import com.examenT2.LP2_T2_Dominguez_Shamir.util.Alert;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("orden")
public class OrdenCompraController {

	private final OrdenCompraService ordencompraService;

	private final ProveedorService proveedorService;

	@GetMapping("listado")
	public String listado(Model model) {

		model.addAttribute("lstOrdenCompra", ordencompraService.getAll());
		return "orden/listado";
	}

	@GetMapping("nuevo")
	public String create(Model model) {

		model.addAttribute("ordenCompra", new OrdenCompraDS());
		model.addAttribute("lstProveedor", proveedorService.getAll());
		return "orden/nuevo";
	}

	@PostMapping("registrar")
	public String registrar(@ModelAttribute OrdenCompraDS ordenCompraDS, RedirectAttributes flash) {

		var response = ordencompraService.create(ordenCompraDS);

		var alert = Alert.sweetToast(response.mensaje(), "success", 5000);

		flash.addFlashAttribute("alert", alert);

		return "redirect:/orden/listado";
	}

	@GetMapping("edicion/{id}")
	public String edicion(@PathVariable Integer id, Model model) {

		model.addAttribute("ordenCompra", ordencompraService.getOne(id));
		model.addAttribute("lstProveedor", proveedorService.getAll());
		return "orden/edicion";
	}

	@PostMapping("guardar")
	public String guardar(@ModelAttribute OrdenCompraDS ordenCompraDS, RedirectAttributes flash) {

		var response = ordencompraService.update(ordenCompraDS);

		var alert = Alert.sweetToast(response.mensaje(), "success", 5000);

		flash.addFlashAttribute("alert", alert);

		return "redirect:/orden/listado";
	}
}
