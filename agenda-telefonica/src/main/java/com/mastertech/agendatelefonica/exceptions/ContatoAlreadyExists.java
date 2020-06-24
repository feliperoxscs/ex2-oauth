package com.mastertech.agendatelefonica.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "O contato informado já existe!")
public class ContatoAlreadyExists extends RuntimeException {
}
