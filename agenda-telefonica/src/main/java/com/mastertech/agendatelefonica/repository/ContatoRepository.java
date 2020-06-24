package com.mastertech.agendatelefonica.repository;

import com.mastertech.agendatelefonica.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    Optional<Contato> findByTelefone(String telefone);
    List<Contato> findByUsuarioId(Integer id);
}
