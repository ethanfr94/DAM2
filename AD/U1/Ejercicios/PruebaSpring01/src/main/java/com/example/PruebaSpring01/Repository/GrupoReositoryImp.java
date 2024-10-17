package com.example.PruebaSpring01.Repository;

import com.example.PruebaSpring01.Model.Grupo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class GrupoReositoryImp implements GrupoRepository{
    
    private final JdbcTemplate jdbcTemplate;

    public GrupoReositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate; //Inyeccion de dependencias
    }


    @Override
    public List<Grupo> findAll() {
        return jdbcTemplate.query("select * from grupos", new GrupoRowMapper());
    }

    @Override
    public Grupo findById(int id) {
        return null;
    }

    @Override
    public Grupo findByLocalidad(String localidad) {
        return null;
    }

    @Override
    public int save(Grupo grupo) {
        String sql = "insert into grupos (nombre, localidad, estilo, esGrupo, annoGrab, fechaEstreno, compania) values (?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, grupo.getNombre(), grupo.getLocalidad(), grupo.getEstilo(), grupo.isEsGrupo(), grupo.getAnnoGrab(), grupo.getFechaEstreno(), grupo.getCompania());
    }

    @Override
    public int update(Grupo grupo) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    private static class GrupoRowMapper implements RowMapper<Grupo>{ //Clase interna para mapear los datos de la base de datos a un objeto
        @Override
        public Grupo mapRow(ResultSet rs, int rowNum) throws SQLException {
            Grupo grupo = new Grupo();
            grupo.setCodGrupo(rs.getInt("codGrupo"));
            grupo.setNombre(rs.getString("nombre"));
            grupo.setLocalidad(rs.getString("localidad"));
            grupo.setEstilo(rs.getString("estilo"));
            grupo.setEsGrupo(rs.getBoolean("esGrupo"));
            grupo.setAnnoGrab(rs.getInt("annoGrab"));

            LocalDate fechaEstreno = rs.getDate("fechaEstreno").toLocalDate() != null ? rs.getDate("fechaEstreno").toLocalDate() : null;
            grupo.setFechaEstreno(fechaEstreno);

            grupo.setCompania(rs.getString("compania"));
            return grupo;
        }
    }

}




