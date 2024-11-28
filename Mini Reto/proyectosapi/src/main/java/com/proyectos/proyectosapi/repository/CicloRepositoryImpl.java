package com.proyectos.proyectosapi.repository;

import com.proyectos.proyectosapi.model.Ciclo;
import com.proyectos.proyectosapi.model.Etapa;
import com.proyectos.proyectosapi.model.Familia;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CicloRepositoryImpl implements CicloRepository{
    private final JdbcTemplate jdbcTemplate;


    public CicloRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Ciclo> findAll() {
        return jdbcTemplate.query("SELECT * FROM CICLOS", new CicloRowMapper());
    }

    @Override
    public Ciclo findById(String codCiclo) {
        return jdbcTemplate.queryForObject("SELECT * FROM CICLOS  where codciclo=?", new CicloRowMapper(),codCiclo);
    }

    @Override
    public List<Ciclo> findByEtapa(Etapa etapa) {
        return  jdbcTemplate.query("SELECT * FROM CICLOS WHERE etapa=?",  new CicloRowMapper(),etapa.name());
    }

    private class CicloRowMapper implements RowMapper<Ciclo> {

        @Override
        public Ciclo mapRow(ResultSet rs, int rowNum) throws SQLException {
            Ciclo ciclo = new Ciclo();
            ciclo.setCodCiclo(rs.getString("codciclo"));
            ciclo.setNombre(rs.getString("nombre"));
            ciclo.setEtapa(Etapa.valueOf(rs.getString("etapa")));
            ciclo.setTitulo(rs.getString("titulo"));
            ciclo.setCurriculo(rs.getString("curriculo"));
            ciclo.setFamilia(Familia.valueOf(rs.getString("familia")));
            return ciclo;
        }
    }

}
