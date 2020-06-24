package com.mastertech.agendatelefonica.mapper;

import com.mastertech.agendatelefonica.dto.ContatoRequest;
import com.mastertech.agendatelefonica.dto.ContatoResponse;
import com.mastertech.agendatelefonica.model.Contato;

import java.util.ArrayList;
import java.util.List;

public class ContatoMapper {

    public static Contato from(ContatoRequest contatoRequest, Integer id){
        Contato contato = new Contato();
        contato.setNome(contatoRequest.getNome());
        contato.setTelefone(contatoRequest.getTelefone());
        contato.setUsuarioId(id);
        return contato;
    }

    public static ContatoResponse to(Contato contato) {
        ContatoResponse contatoResponse = new ContatoResponse();
        contatoResponse.setId(contato.getId());
        contatoResponse.setNome(contato.getNome());
        contatoResponse.setTelefone(contato.getTelefone());
        return contatoResponse;
    }
    
    public static List<ContatoResponse> to(List<Contato> contatos) {
        List<ContatoResponse> contatoResponses = new ArrayList<>();
        for (Contato contato : contatos) {
            ContatoResponse contatoResponse = new ContatoResponse();
            contatoResponse.setId(contato.getId());
            contatoResponse.setTelefone(contato.getTelefone());
            contatoResponse.setNome(contato.getNome());
            contatoResponses.add(contatoResponse);
        }
        return contatoResponses;
    }
}
