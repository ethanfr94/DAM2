package com.example.PruebaSpring01.Repository;

import com.example.PruebaSpring01.Model.Cancion;
import com.example.PruebaSpring01.Model.Grupo;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CancionRepositoryImp implements CancionRepository {

    private final JdbcTemplate jdbcTemplate;

    public CancionRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Cancion> findAll() {
        return jdbcTemplate.query("select * from canciones", new CancionRowMapper());
    }

    @Override
    public Cancion findByNumCancion(int id) {
        return jdbcTemplate.queryForObject("select * from canciones where numCancion = ?", new CancionRowMapper(), id);
    }

    @Override
    public List<Cancion> findByGrupo(int grupo) {
        return jdbcTemplate.query("select * from canciones where grupo = ?", new CancionRowMapper(), grupo);
    }

    @Override
    public int save(Cancion cancion) {
        String sql = "insert into canciones (numCancion, titulo, duracion, grupo, total_votos) values (?,?,?,?,?)";
        return jdbcTemplate.update(sql, cancion.getNumCancion(), cancion.getTitulo(), cancion.getDuracion(), cancion.getGrupo().getCodGrupo(), cancion.getTotal_votos());
    }

    @Override
    public int update(Cancion cancion) {
       try{
              return jdbcTemplate.update("update canciones set titulo = ?, duracion = ?, grupo = ?, total_votos = ? where numCancion = ?",
                     cancion.getTitulo(), cancion.getDuracion(), cancion.getGrupo().getCodGrupo(), cancion.getTotal_votos(), cancion.getNumCancion());
         } catch (Exception e){
              return -1;
       }
    }

    @Override
    public int deleteByNumCancion(int id) {
        return jdbcTemplate.update("delete from canciones where numCancion = ?", id);
    }

    @GetMapping("/{numCancion}")
    public ResponseEntity<?> getCancionByNumCancion(@PathVariable int numCancion){
        Cancion cancion = findByNumCancion(numCancion);
        if(cancion != null){
            return ResponseEntity.ok(cancion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/grupo/{grupo}")
    public ResponseEntity<?> getCancionByGrupo(@PathVariable int grupo){
        List<Cancion> canciones = findByGrupo(grupo);
        if(canciones.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(canciones);
        }
    }

    @PostMapping("/{numCancion}")
    public ResponseEntity<Cancion> updateCancion(@PathVariable int numCancion, @RequestBody Cancion cancion){
        Cancion existingCancion = findByNumCancion(numCancion);
        if(existingCancion != null){
            cancion.setNumCancion(numCancion);
            update(cancion);
            return ResponseEntity.ok(cancion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{numCancion}")
    public ResponseEntity<Void> deleteCancion(@PathVariable int numCancion){
        Cancion existingCancion = findByNumCancion(numCancion);
        if(existingCancion != null){
            deleteByNumCancion(numCancion);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private static class CancionRowMapper implements RowMapper<Cancion> {
        @Override
        public Cancion mapRow(ResultSet rs, int rowNum) throws SQLException {
            Grupo grupo = new Grupo();
            Cancion cancion = new Cancion();
            cancion.setNumCancion(rs.getInt("numCancion"));
            cancion.setTitulo(rs.getString("titulo"));
            cancion.setDuracion(rs.getInt("duracion"));
            grupo.setCodGrupo(rs.getInt("grupo"));
            cancion.setGrupo(grupo);
            cancion.setTotal_votos(rs.getInt("total_votos"));
            return cancion;
        }
    }
}
