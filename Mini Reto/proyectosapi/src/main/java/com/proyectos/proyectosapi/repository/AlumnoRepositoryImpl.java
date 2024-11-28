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
public class AlumnoRepositoryImpl implements AlumnoRepository{
    private final JdbcTemplate jdbcTemplate;
    private final CicloRepository cicloRepository;

    public AlumnoRepositoryImpl(JdbcTemplate jdbcTemplate, CicloRepository cicloRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.cicloRepository = cicloRepository;
    }

    @Override
    public List<Alumno> findAll() {
        return jdbcTemplate.query("SELECT * FROM ALUMNOS INNER JOIN CICLOS ON ALUMNOS.CICLO_ACTUAL=CICLOS.CODCICLO", new AlumnoCursoRowMapper());
    }

    @Override
    public Alumno findByDni(String dni) {
        return jdbcTemplate.queryForObject("SELECT * FROM ALUMNOS INNER JOIN CICLOS  ON ALUMNOS.CICLO_ACTUAL=CICLOS.CODCICLO where dni=?", new AlumnoCursoRowMapper(),dni);
    }

    @Override
    public Alumno findByEmail(String email) {
        return jdbcTemplate.queryForObject("SELECT * FROM ALUMNOS INNER JOIN CICLOS ON ALUMNOS.CICLO_ACTUAL=CICLOS.CODCICLO where email=?", new AlumnoCursoRowMapper(),email);
    }

    @Override
    public Alumno findById(String idAlumno) {
        return jdbcTemplate.queryForObject("SELECT * FROM ALUMNOS INNER JOIN CICLOS ON ALUMNOS.CICLO_ACTUAL=CICLOS.CODCICLO where idalumno=?", new AlumnoCursoRowMapper(),idAlumno);
    }

    @Override
    public int save(Alumno alumno) {
        UUID uuid = UUID.randomUUID();
        String idConUUID = uuid.toString();
        String sql="INSERT INTO alumnos (idalumno,nombre, apellidos,dni,email,password_encr,telefono,genero,fechaNac,activo,ciclo_actual) VALUES (?,?,?,?,?,md5(?),?,?,?,?,?)";
        return jdbcTemplate.update(sql,idConUUID,alumno.getNombre(),alumno.getApellidos(),alumno.getDni(),alumno.getEmail(),alumno.getPassword(),alumno.getTelefono(),alumno.getGenero().name(),alumno.getFechaNac(),alumno.isActivo(),alumno.getCicloActual().getCodCiclo());
    }

    @Override
    public int update(Alumno alumno) {
        try{
            return jdbcTemplate.update("UPDATE alumnos set idalumno=?, nombre=?, apellidos=?, dni=?,email=?,password_encr=?,telefono=?,genero=?,fechaNac=?,activo=?,ciclo_actual=? WHERE idalumno=?", alumno.getIdAlumno(),alumno.getNombre(),alumno.getApellidos(),alumno.getDni(),alumno.getEmail(),alumno.getPassword(),alumno.getTelefono(),alumno.getGenero().name(),alumno.getFechaNac(),alumno.isActivo(),alumno.getCicloActual().getCodCiclo(), alumno.getIdAlumno());
        }catch (Exception e){
            return -1;
        }
    }

    @Override
    public int delete(Alumno alumno) {
       return jdbcTemplate.update("DELETE FROM alumnos WHERE idalumno=?", alumno.getIdAlumno());
    }
    private class AlumnoCursoRowMapper implements RowMapper<Alumno> {

        @Override
        public Alumno mapRow(ResultSet rs, int rowNum) throws SQLException {
            Alumno alumno = new Alumno();
            alumno.setIdAlumno(rs.getString("idalumno"));
            alumno.setNombre(rs.getString("nombre"));
            alumno.setApellidos(rs.getString("apellidos"));
            alumno.setDni(rs.getString("dni"));
            alumno.setEmail(rs.getString("email"));
            alumno.setPassword(rs.getString("password_encr"));
            alumno.setTelefono(rs.getString("telefono"));
            alumno.setGenero(Genero.valueOf(rs.getString("genero")));
            alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
            alumno.setActivo(rs.getBoolean("activo"));
            alumno.setCicloActual(cicloRepository.findById(rs.getString("ciclo_actual")));
            return alumno;
        }
    }
}
