package com.felipe.myapplication;

public class Preguntas {
    String id;
    String pregunta;
    String respuesta1;
    String respuesta2;
    String nivel;

    public Preguntas() {
    }

    public Preguntas(String id, String pregunta, String respuesta1, String respuesta2, String nivel) {
        this.id = id;
        this.pregunta = pregunta;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
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

    public String getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel=nivel;


    }

    @Override
    public String toString() {
        return "Preguntas{" +
                "id='" + id + '\'' +
                ", pregunta='" + pregunta + '\'' +
                ", respuesta1='" + respuesta1 + '\'' +
                ", respuesta2='" + respuesta2 + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}