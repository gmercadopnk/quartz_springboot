package com.yrag.helperSpringBoot.Dao;

import com.yrag.helperSpringBoot.Entities.Tarea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class TareaJdbcDao implements TareaJdbcInterface {

    private static final Logger log = LoggerFactory.getLogger(TareaJdbcDao.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TareaJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> listAll() {
        log.debug("Listado de tareas");
        StringBuilder sql = new StringBuilder("SELECT a.* FROM tarea a");

        return jdbcTemplate.queryForList(sql.toString());
    }

    @Override
    public boolean save(String nombre, String grupo, String cron) {
        log.debug("Intentando guardar");
        Tarea tarea = new Tarea(nombre, grupo, cron);
        StringBuilder sql = new StringBuilder("INSERT INTO tarea (nombre, grupo, cron) VALUES (");
        sql
                .append("'").append(tarea.getNombre()).append("',")
                .append("'").append(tarea.getGrupo()).append("',")
                .append("'").append(tarea.getCron()).append("'")
                .append(")")
        ;

        jdbcTemplate.execute(sql.toString());

        return false;
    }
}