package com.retofullstack.microserviciospringboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.retofullstack.microserviciospringboot.entity.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
