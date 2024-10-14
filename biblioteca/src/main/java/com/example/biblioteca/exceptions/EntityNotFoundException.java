package com.example.biblioteca.exceptions;

public class EntityNotFoundException extends RuntimeException {

    private Integer numeroRegraNegocio;

    public EntityNotFoundException(String mensagem, Integer numeroRegraNegocio) {
        super(mensagem);
        this.numeroRegraNegocio = numeroRegraNegocio;
    }

    public Integer getNumeroRegraNegocio() {
        return numeroRegraNegocio;
    }

    public void setNumeroRegraNegocio(Integer numeroRegraNegocio) {
        this.numeroRegraNegocio = numeroRegraNegocio;
    }
}