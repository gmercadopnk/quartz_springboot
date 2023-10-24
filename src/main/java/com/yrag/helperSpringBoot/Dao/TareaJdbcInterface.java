package com.yrag.helperSpringBoot.Dao;

import java.util.List;
import java.util.Map;

public interface TareaJdbcInterface {

    List<Map<String, Object>> listAll();
    boolean save(String nombre, String grupo, String cron);
}
