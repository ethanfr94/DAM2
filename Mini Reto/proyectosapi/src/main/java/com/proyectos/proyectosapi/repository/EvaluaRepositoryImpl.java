package com.proyectos.proyectosapi.repository;

import com.proyectos.proyectosapi.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
public class EvaluaRepositoryImpl implements EvaluaRepository {
    private final JdbcTemplate jdbcTemplate;
    private final ProfesorRepository profesorRepository;
    private final ProyectoRepository proyectoRepository;

    public EvaluaRepositoryImpl(JdbcTemplate jdbcTemplate, ProfesorRepository profesorRepository, ProyectoRepository proyectoRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.profesorRepository = profesorRepository;
        this.proyectoRepository = proyectoRepository;
    }

    @Override
    public List<Evalua> findAll() {
        return jdbcTemplate.query("SELECT * FROM evaluan", new EvaluaRepositoryImpl.EvaluaRowMapper());
    }

    @Override
    public Evalua findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM evaluan WHERE id = ?",
                new EvaluaRepositoryImpl.EvaluaRowMapper(), id);
    }

    @Override
    public List<Evalua> findByProfesor(String profesor) {
        return jdbcTemplate.query("SELECT * FROM evaluan WHERE profesor = ?",
                new EvaluaRowMapper(),profesor);
    }

    @Override
    public List<Evalua> findByProyecto(int proyecto) {
        return jdbcTemplate.query("SELECT * FROM evaluan WHERE proyecto = ?",
                new EvaluaRowMapper(),proyecto);
    }

    @Override
    public int save(Evalua evalua) {
        String sql = "INSERT INTO evaluan(calificacion_pers,comentario,proyecto,profesor) "+
                "VALUES (?,?,?,?)";
        return jdbcTemplate.update(sql,evalua.getCalificacion(),
                evalua.getComentario(),evalua.getProyecto().getIdProyecto(),evalua.getProfesor().getIdProfesor());
    }

    @Override
    public int update(Evalua evalua) {
        String sql = "UPDATE evaluan SET calificacion_pers = ?, comentario = ?, proyecto = ?, profesor = ? " +
                "WHERE id = ?";
        return jdbcTemplate.update(sql,evalua.getCalificacion(),
                evalua.getComentario(),evalua.getProyecto().getIdProyecto(),evalua.getProfesor().getIdProfesor(),evalua.getId());
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM evaluan WHERE id = ?";
        return jdbcTemplate.update(sql,id);
    }


    private class EvaluaRowMapper implements RowMapper<Evalua> {

        @Override
        public Evalua mapRow(ResultSet rs, int rowNum) throws SQLException {
            Evalua evalua = new Evalua();
            evalua.setId(rs.getInt("id"));
            evalua.setCalificacion(rs.getFloat("calificacion_pers"));
            evalua.setComentario(rs.getString("comentario"));
            evalua.setProyecto(proyectoRepository.findById(rs.getInt("proyecto")));
            evalua.setProfesor(profesorRepository.findById(rs.getString("profesor")));
            return evalua;
        }
    }
}
