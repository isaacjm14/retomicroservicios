package com.retofullstack.microserviciospringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retofullstack.microserviciospringboot.entity.Cliente;
import com.retofullstack.microserviciospringboot.entity.KpiCliente;
import com.retofullstack.microserviciospringboot.service.ClienteService;

@RestController
@RequestMapping(value = "/")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;	

	@PostMapping(value = "/creacliente")
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){
		Cliente clienteCreado = clienteService.CreateCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreado);
	}
	
	@GetMapping(value = "/listclientes")
	public ResponseEntity<List<Cliente>> listCliente(){
		List<Cliente> clientes = clienteService.ListAllClientes();
		if(clientes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping(value = "/kpideclientes")
	public ResponseEntity<KpiCliente> listKpi(){
		List<Cliente> clientes = clienteService.ListAllClientes();
		KpiCliente kpicliente = clienteService.listKpi(clientes);
		
		if(clientes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}		
		
		return ResponseEntity.ok(kpicliente);
	}
}
