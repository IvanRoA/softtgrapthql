package com.ivra.graphql.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivra.graphql.graphql.model.Colonia;

@Repository
public interface ColoniaRepository extends JpaRepository<Colonia, Long> {

}
