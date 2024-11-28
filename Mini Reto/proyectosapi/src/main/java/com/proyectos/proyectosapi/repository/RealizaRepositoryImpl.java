package com.proyectos.proyectosapi.repository;

import com.proyectos.proyectosapi.model.Alumno;
import com.proyectos.proyectosapi.model.Proyecto;
import com.proyectos.proyectosapi.model.Realiza;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
public class RealizaRepositoryImpl implements RealizaRepository {
    private final JdbcTemplate jdbcTemplate;
    private final AlumnoRepository alumnoRepository;
    private final ProyectoRepository proyectoRepository;

    public RealizaRepositoryImpl(JdbcTemplate jdbcTemplate, AlumnoRepository alumnoRepository, ProyectoRepository proyectoRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.alumnoRepository = alumnoRepository;
        this.proyectoRepository = proyectoRepository;
    }

    @Override
    public List<Realiza> findAll() {
        return jdbcTemplate.query("SELECT * FROM realizan", new RealizaAlumnoProyectoRowMapper());
    }

    @Override
    public Realiza findById(int id) {
         return jdbcTemplate.queryForObject("SELECT * FROM realizan where id=?", new RealizaAlumnoProyectoRowMapper(), id);
    }

    @Override
    public Realiza findByAlumno(String alumno) {
        return jdbcTemplate.queryForObject("SELECT * FROM realizan where alumno=?", new RealizaAlumnoProyectoRowMapper(), alumno);
    }

    @Override
    public Realiza findByProyecto(int proyecto) {
        return jdbcTemplate.queryForObject("SELECT * FROM realizan where proyecto=?", new RealizaAlumnoProyectoRowMapper(), proyecto);
    }

    @Override
    public int save(Realiza realiza) {
        String sql = "INSERT INTO realizan (calificacion,alumno,proyecto,comentario) VALUES (?,?,?,?)";
        return jdbcTemplate.update(sql,realiza.getCalificacion(),realiza.getAlumno().getIdAlumno(),realiza.getProyecto().getIdProyecto(),realiza.getComentario());
    }

    @Override
    public int update(Realiza realiza) {
        try {
            return jdbcTemplate.update("UPDATE realizan set id=?, calificacion=?, alumno=?, proyecto=?,comentario=? WHERE id= ?", realiza.getId(),realiza.getCalificacion(),realiza.getAlumno().getIdAlumno(),realiza.getProyecto().getIdProyecto(),realiza.getComentario(), realiza.getId());
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int delete(Realiza realiza) {
        return jdbcTemplate.update("DELETE FROM realizan WHERE id=?", realiza.getId());
    }
    private class RealizaAlumnoProyectoRowMapper implements RowMapper<Realiza> {

        @Override
        public Realiza mapRow(ResultSet rs, int rowNum) throws SQLException {
          Realiza realiza = new Realiza();
          realiza.setId(rs.getInt("id"));
          realiza.setCalificacion(rs.getInt("calificacion"));
          realiza.setAlumno(alumnoRepository.findById(rs.getString("alumno")));
          realiza.setProyecto(proyectoRepository.findById(rs.getInt("proyecto")));
          realiza.setComentario(rs.getString("comentario"));
          return realiza;
        }
    }
}
