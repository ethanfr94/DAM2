package com.proyectos.proyectosapi.repository;


import com.proyectos.proyectosapi.model.Genero;
import com.proyectos.proyectosapi.model.Profesor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
public class ProfesorRepositoryImpl implements ProfesorRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProfesorRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Profesor> findAll() {
        return jdbcTemplate.query("SELECT * FROM profesores", new ProfesorRowMapper());
    }

    @Override
    public Profesor findById(String id) {
        return  jdbcTemplate.queryForObject("SELECT * FROM profesores where idprofesor=?", new ProfesorRowMapper(), id);
    }

    @Override
    public List<Profesor> findByAdmin(boolean admin) {
        return jdbcTemplate.query("SELECT * FROM profesores WHERE admin=?", new ProfesorRowMapper(), admin==true?1:0);
    }

    @Override
    public Profesor findByNombre(String nombre, String apellidos) {
        return jdbcTemplate.queryForObject("SELECT * FROM profesores WHERE nombre=? and apellidos=?", new ProfesorRowMapper(), nombre, apellidos);
    }

    @Override
    public Profesor findByEmailYContraseña(String email, String contraseña) {
        return jdbcTemplate.queryForObject("SELECT * FROM profesores WHERE email=? and password_encr=md5(?)", new ProfesorRowMapper(), email,contraseña);
    }

    @Override
    public int save(Profesor profesor) {
        UUID uuid = UUID.randomUUID();
        String idConUUID = uuid.toString();
        String sql="INSERT INTO profesores (idprofesor,nombre, apellidos,dni,email,password_encr,telefono,genero,fechaNac,especialidad,activo,admin) VALUES (?,?,?,?,?,md5(?),?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,idConUUID, profesor.getNombre(),profesor.getApellidos(),profesor.getDni(),profesor.getEmail(),profesor.getPassword(),profesor.getTelefono(),profesor.getGenero().name(),profesor.getFechaNac(), profesor.getEspecialidad(),profesor.isActivo(),profesor.isAdmin());
    }

    @Override
    public int update(Profesor profesor) {
        try{
            return jdbcTemplate.update("UPDATE profesores set idprofesor=?, nombre=?, apellidos=?, dni=?,email=?,password_encr=?,telefono=?,genero=?,fechaNac=?,especialidad=?,activo=?,admin=? WHERE idprofesor=?", profesor.getIdProfesor(),profesor.getNombre(),profesor.getApellidos(),profesor.getDni(),profesor.getEmail(),profesor.getPassword(),profesor.getTelefono(),profesor.getGenero().name(),profesor.getFechaNac(),profesor.getEspecialidad(),profesor.isActivo(),profesor.isAdmin(), profesor.getIdProfesor());
        }catch (Exception e){
            return -1;
        }
    }

    @Override
    public int delete(Profesor profesor) {
        return jdbcTemplate.update("DELETE FROM profesores WHERE idprofesor=?",profesor.getIdProfesor());
    }
    private class ProfesorRowMapper implements RowMapper<Profesor> {

        @Override
        public Profesor mapRow(ResultSet rs, int rowNum) throws SQLException {
            Profesor profesor=new Profesor();
            profesor.setIdProfesor(rs.getString("idprofesor"));
            profesor.setNombre(rs.getString("nombre"));
            profesor.setApellidos(rs.getString("apellidos"));
            profesor.setDni(rs.getString("dni"));
            profesor.setEmail(rs.getString("email"));
            profesor.setPassword(rs.getString("password_encr"));
            profesor.setTelefono(rs.getString("telefono"));
            profesor.setGenero(Genero.valueOf(rs.getString("genero")));
            profesor.setFechaNac(rs.getDate("fechaNac").toLocalDate());
            profesor.setEspecialidad(rs.getString("especialidad"));
            profesor.setActivo(rs.getBoolean("activo"));
            profesor.setAdmin(rs.getBoolean("admin"));
            return profesor;
        }
    }
}
