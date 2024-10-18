package com.example.PruebaSpring01.Repository;

import com.example.PruebaSpring01.Model.Grupo;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


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
        return jdbcTemplate.queryForObject("select * from grupos where codGrupo = ?", new GrupoRowMapper(), id);
    }

    @Override
    public List<Grupo> findByLocalidad(String localidad) {
        return jdbcTemplate.query("select * from grupos where localidad = ?", new GrupoRowMapper(), localidad);
    }

    @Override
    public int save(Grupo grupo) {
        String sql = "insert into grupos (nombre, localidad, estilo, esGrupo, annoGrab, fechaEstreno, compania) values (?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, grupo.getNombre(), grupo.getLocalidad(), grupo.getEstilo(), grupo.isEsGrupo(), grupo.getAnnoGrab(), grupo.getFechaEstreno(), grupo.getCompania());
    }

    @Override
    public int update(Grupo grupo) {
       try{
           return jdbcTemplate.update("update grupos set nombre = ?, localidad = ?, estilo = ?, esGrupo = ?, annoGrab = ?, fechaEstreno = ?, compania = ? where codGrupo = ?",
                   grupo.getNombre(), grupo.getLocalidad(), grupo.getEstilo(), grupo.isEsGrupo(), grupo.getAnnoGrab(), grupo.getFechaEstreno(), grupo.getCompania(), grupo.getCodGrupo());
       } catch (Exception e){
           return -1;
       }
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("delete from grupos where codGrupo = ?", id);
    }

    @GetMapping("/{id}")//Indica que es un metodo get para obtener datos
    public ResponseEntity<?> getGrupoById(@PathVariable int id){
        Grupo grupo = findById(id);
        if(grupo != null){
            return ResponseEntity.ok(grupo);//Si el grupo existe devolvemos un 200
        }
        else{
            return ResponseEntity.notFound().build();//Si el grupo no existe devolvemos un 404
        }
    }

    @GetMapping("/localidad/{localidad}")//Indica que es un metodo get para obtener datos
    public ResponseEntity<?> getGrupoByLocalidad(@PathVariable String localidad){
        List<Grupo> grupos = findByLocalidad(localidad);
        if(grupos.isEmpty()){
            return ResponseEntity.notFound().build();//Si no hay grupos en la localidad devolvemos un 404
        }
        else{
            return ResponseEntity.ok(grupos);//Si hay grupos en la localidad devolvemos un 200
        }
    }

    @PutMapping("/{id}")//Indica que es un metodo put para actualizar datos
    public ResponseEntity<Grupo> updateGrupo(@PathVariable int id, @RequestBody Grupo grupo){
        Grupo exisitingGrupo = findById(id);
        if(exisitingGrupo != null){
            grupo.setCodGrupo(id);
            update(grupo);
            return ResponseEntity.ok(grupo);//Si el grupo se actualiza devolvemos un 200
        }
        else{
            return ResponseEntity.notFound().build();//Si el grupo no existe devolvemos un 404
        }
    }

    @DeleteMapping("/{id}")//Indica que es un metodo delete para eliminar datos
    public ResponseEntity<Void> deleteGrupo(@PathVariable int id){
        Grupo exisitingGrupo = findById(id);
        if(exisitingGrupo != null){
            deleteById(id);
            return ResponseEntity.noContent().build();//Si el grupo se elimina devolvemos un 204
        }
        else{
            return ResponseEntity.notFound().build();//Si el grupo no existe devolvemos un 404
        }
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
/*
http://localhost:4000/swagger-ui/index.html#/
para ver la documentacion de la api y poder probar los metodos
 */
}




