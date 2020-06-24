package com.mastertech.agendatelefonica.controller;

import com.mastertech.agendatelefonica.dto.ContatoRequest;
import com.mastertech.agendatelefonica.dto.ContatoResponse;
import com.mastertech.agendatelefonica.mapper.ContatoMapper;
import com.mastertech.agendatelefonica.model.Contato;
import com.mastertech.agendatelefonica.security.UsuarioDto;
import com.mastertech.agendatelefonica.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping("/contato")
    public ContatoResponse createContato(@AuthenticationPrincipal UsuarioDto usuario,
                                         @RequestBody ContatoRequest contatoRequest) {
        Contato contato = ContatoMapper.from(contatoRequest, usuario.getId());
        contato = contatoService.salvarContato(contato);
        return ContatoMapper.to(contato);
    }

    @GetMapping("/contatos")
    public List<ContatoResponse> listarContatos(@AuthenticationPrincipal UsuarioDto usuario) {
        return ContatoMapper.to(contatoService.mostrarContatos(usuario.getId()));
    }
}
