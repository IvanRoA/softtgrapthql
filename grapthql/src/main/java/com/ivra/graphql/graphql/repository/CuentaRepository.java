package com.ivra.graphql.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivra.graphql.graphql.model.Cuenta;

import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Long>{

}
