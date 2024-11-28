package com.proyectos.proyectosapi.repository;

import com.proyectos.proyectosapi.model.Proyecto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
public class ProyectoRepositoryImpl implements ProyectoRepository{
    private final JdbcTemplate jdbcTemplate;
    private final ProfesorRepository profesorRepository;
    private final CicloRepository cicloRepository;

    public ProyectoRepositoryImpl(JdbcTemplate jdbcTemplate, ProfesorRepository profesorRepository, CicloRepository cicloRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.profesorRepository = profesorRepository;
        this.cicloRepository = cicloRepository;
    }
    @Override
    public List<Proyecto> findAll() {
        return jdbcTemplate.query("SELECT * FROM proyectos", new ProyectoCicloTutorRowMapper());
    }

    @Override
    public List<Proyecto> findByTipo(String tipo) {
        return jdbcTemplate.query("SELECT * FROM proyectos where tipo=?", new ProyectoCicloTutorRowMapper(), tipo);
    }

    @Override
    public Proyecto findByNombre(String nombre) {
        return jdbcTemplate.queryForObject("SELECT * FROM proyectos where nombre=?", new ProyectoCicloTutorRowMapper(), nombre);
    }

    @Override
    public Proyecto findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM proyectos where idproyecto=?", new ProyectoCicloTutorRowMapper(), id);
    }

    @Override
    public int save(Proyecto proyecto) {
        String sql = "INSERT INTO proyectos (nombre, tipo,resumen,anno_acad,fecha_pres,comentarios,ciclo, tutor ) VALUES (?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,proyecto.getNombre(), proyecto.getTipo(), proyecto.getResumen(), proyecto.getAnnoAcad(), proyecto.getFechaPres(),
                proyecto.getComentarios(), proyecto.getCiclo().getCodCiclo(), proyecto.getTutor().getIdProfesor());
    }

    @Override
    public int update(Proyecto proyecto) {
        try {
            return jdbcTemplate.update("UPDATE proyectos set idproyecto=?, nombre=?, tipo=?, resumen=?,anno_acad=?,fecha_pres=?, comentarios=?, ciclo=?, tutor=?  WHERE idproyecto= ?", proyecto.getIdProyecto(), proyecto.getNombre(), proyecto.getTipo(), proyecto.getResumen(), proyecto.getAnnoAcad(),
                    proyecto.getFechaPres(), proyecto.getComentarios(), proyecto.getCiclo().getCodCiclo(), proyecto.getTutor().getIdProfesor(), proyecto.getIdProyecto());
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int delete(Proyecto proyecto) {
        return jdbcTemplate.update("DELETE FROM proyectos WHERE idproyecto=?",proyecto.getIdProyecto());
    }

    private class ProyectoCicloTutorRowMapper implements RowMapper<Proyecto> {

        @Override
        public Proyecto mapRow(ResultSet rs, int rowNum) throws SQLException {
            Proyecto proyecto = new Proyecto();
            proyecto.setIdProyecto(rs.getInt("idproyecto"));
            proyecto.setNombre(rs.getString("nombre"));
            proyecto.setTipo((rs.getString("tipo")));
            proyecto.setResumen(rs.getString("resumen"));
            proyecto.setAnnoAcad(rs.getInt("anno_acad"));
            proyecto.setFechaPres(rs.getDate("fecha_pres")!=null?rs.getDate("fecha_pres").toLocalDate():null);
            proyecto.setLogo(rs.getString("logo"));
            proyecto.setMemoria(rs.getString("memoria"));
            proyecto.setArchivos(rs.getString("archivos"));
            proyecto.setComentarios(rs.getString("comentarios"));
            proyecto.setCiclo(cicloRepository.findById(rs.getString("ciclo")));
            proyecto.setTutor(profesorRepository.findById(rs.getString("tutor")));
            return proyecto;
        }
    }
}
