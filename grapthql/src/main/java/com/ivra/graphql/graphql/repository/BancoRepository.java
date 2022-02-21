package com.ivra.graphql.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivra.graphql.graphql.model.Banco;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Integer> {

}
