package com.example.biblioteca.configs;

import com.example.biblioteca.exceptions.*;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class ExceptionHandlerMapper {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ProblemDetail> handle(EntityNotFoundException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(404);
        problemDetail.setTitle("Erro: ID Inexistente");
        problemDetail.setDetail(ex.getMessage());

        problemDetail.setProperty("dataHoraErro", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm")));
        problemDetail.setProperty("numeroRegraNegocio", ex.getNumeroRegraNegocio());

        return ResponseEntity.of(problemDetail).build();
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ProblemDetail> handle(BadRequestException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(400);
        problemDetail.setTitle("Erro: Dados do Livro Incorretos");
        problemDetail.setDetail(ex.getMessage());

        problemDetail.setProperty("dataHoraErro", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm")));
        problemDetail.setProperty("numeroRegraNegocio", ex.getMessage());

        return ResponseEntity.of(problemDetail).build();
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ProblemDetail> handle(ConflictException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(409);
        problemDetail.setTitle("Erro: Duplicação de Item Proibida");
        problemDetail.setDetail(ex.getMessage());

        problemDetail.setProperty("dataHoraErro", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm")));
        problemDetail.setProperty("numeroRegraNegocio", ex.getNumeroRegraNegocio());

        return ResponseEntity.of(problemDetail).build();
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<ProblemDetail> handle(UnprocessableEntityException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(422);
        problemDetail.setTitle("Erro: Solicitação Não Processada");
        problemDetail.setDetail(ex.getMessage());

        problemDetail.setProperty("dataHoraErro", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm")));
        problemDetail.setProperty("numeroRegraNegocio", ex.getNumeroRegraNegocio());

        return ResponseEntity.of(problemDetail).build();
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ProblemDetail> handle(InternalServerErrorException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(500);
        problemDetail.setTitle("Erro: Servidor Indisponível");
        problemDetail.setDetail(ex.getMessage());

        problemDetail.setProperty("dataHoraErro", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm")));
        problemDetail.setProperty("numeroRegraNegocio", ex.getNumeroRegraNegocio());

        return ResponseEntity.of(problemDetail).build();
    }
}