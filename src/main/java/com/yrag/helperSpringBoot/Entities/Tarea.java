package com.yrag.helperSpringBoot.Entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Tarea {

    private Integer id;
    private String nombre;
    private String grupo;
    private String cron;

    public Tarea(Object rs) {
    }

    public Tarea(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.nombre = String.valueOf(rs.getObject("nombre"));
        this.grupo = String.valueOf(rs.getObject("grupo"));
        this.cron = String.valueOf(rs.getObject("cron"));
    }

    public Tarea(String nombre, String grupo, String cron) {
        this.nombre = nombre;
        this.grupo = grupo;
        this.cron = cron;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", grupo='" + grupo + '\'' +
                ", cron='" + cron + '\'' +
                '}';
    }
}
