package com.retofullstack.microserviciospringboot.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retofullstack.microserviciospringboot.entity.Cliente;
import com.retofullstack.microserviciospringboot.entity.KpiCliente;
import com.retofullstack.microserviciospringboot.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository ClienteRepository;
	
	private double promedades = 0.00;
	private int cantedades = 0;
	private int sumedades = 0;
	private double rango = 0.00;
	private double varianza = 0.00;
	private double desestandar = 0.00;
	private Date fecmuerte;
	LocalDate fecactual = LocalDate.now();
	LocalDate fecnueva;	
	private int anosmaxadias;
	
	@Override
	public List<Cliente> ListAllClientes() {
		// TODO Auto-generated method stub
		return ClienteRepository.findAll();
	}

	@Override
	public Cliente CreateCliente(Cliente cliente) {
		//Años maximos que puede vivir una persona exagerando en dias
		anosmaxadias = 120*360;
		anosmaxadias = anosmaxadias - cliente.getEdad()*360;
		fecnueva = fecactual.plusDays((long) Math.floor(Math.random() * (anosmaxadias - 1) + 1));
		fecmuerte = Date.from(fecnueva.atStartOfDay(ZoneId.systemDefault()).toInstant());
		cliente.setFecmue(fecmuerte);
		// TODO Auto-generated method stub
		return ClienteRepository.save(cliente);
	}

	@Override
	public KpiCliente listKpi(List<Cliente> clientes) {
		KpiCliente kpicliente = new KpiCliente();
		//Reseteando variables
		promedades = 0.00;
		cantedades = 0;
		sumedades = 0;
		rango = 0.00;
		varianza = 0.00;
		desestandar = 0.00;
		//Obtener promedio de Edades y desviación Estandar		
		//Obteniendo el promedio de edades
		cantedades = clientes.size();
		clientes.forEach((cliente) -> sumedades += cliente.getEdad());
		promedades = (double) Math.round((sumedades / cantedades)*100)/100;
		kpicliente.setPromedad(promedades);
		//Obteniendo la desviacion estandar
		clientes.forEach((cliente) -> {
		rango = Math.pow((cliente.getEdad() - promedades), 2);
		varianza += rango;
		});
		varianza = varianza / cantedades;
		desestandar = (double) Math.round(Math.sqrt(varianza)*100)/100;
		kpicliente.setDesestandar(desestandar);
		
		return kpicliente;
	}
}
