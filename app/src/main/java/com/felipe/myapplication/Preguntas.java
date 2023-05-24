package com.felipe.myapplication;

public class Preguntas {
    String id;
    String pregunta;
    String nivelRelativo;
    String nivel;

    public Preguntas() {
    }

    public Preguntas(String id, String pregunta, String nivelRelativo, String nivel) {
        this.id = id;
        this.pregunta = pregunta;
        this.nivelRelativo = nivelRelativo;
        this.nivel = nivel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getNivelRelativo() {
        return nivelRelativo;
    }

    public void setNivelRelativo(String nivelRelativo) {
        this.nivelRelativo = nivelRelativo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return pregunta + nivel;

    }
}