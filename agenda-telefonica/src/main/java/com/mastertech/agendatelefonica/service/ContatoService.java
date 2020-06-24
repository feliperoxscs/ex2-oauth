package com.mastertech.agendatelefonica.service;

import com.mastertech.agendatelefonica.exceptions.ContatoAlreadyExists;
import com.mastertech.agendatelefonica.model.Contato;
import com.mastertech.agendatelefonica.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public Contato salvarContato(Contato contato) {
        Optional<Contato> contatoByTelefone = contatoRepository.findByTelefone(contato.getTelefone());
        if (contatoByTelefone.isPresent()){
            throw new ContatoAlreadyExists();
        }
        contatoRepository.save(contato);
        return contato;
    }

    public List<Contato> mostrarContatos(Integer id) {
        return contatoRepository.findByUsuarioId(id);
    }
}
