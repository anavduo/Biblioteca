package com.biblioteca.Tejada.repositorios;

// @author aduo
import com.biblioteca.Tejada.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepo extends JpaRepository<Autor, Integer> {

    @Query("SELECT a FROM Autor a WHERE a.nombre= :nombre ")
    public Autor buscarAutorPorNombre(@Param("nombre") String nombre);
}
