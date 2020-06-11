package com.retofullstack.microserviciospringboot.service;

import java.util.List;

import com.retofullstack.microserviciospringboot.entity.Cliente;
import com.retofullstack.microserviciospringboot.entity.KpiCliente;

public interface ClienteService {
	public List<Cliente> ListAllClientes();
	public Cliente CreateCliente(Cliente cliente);
	public KpiCliente listKpi(List<Cliente> clientes);
}
