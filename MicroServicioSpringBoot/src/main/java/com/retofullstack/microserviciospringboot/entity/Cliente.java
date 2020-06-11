package com.retofullstack.microserviciospringboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter @Setter
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	private int edad;  
	@Column(name = "fec_nac")
	@Temporal(TemporalType.DATE)
	private Date fecnac;
	@Column(name = "fec_mue")
	@Temporal(TemporalType.DATE)
	private Date fecmue;
	
}
