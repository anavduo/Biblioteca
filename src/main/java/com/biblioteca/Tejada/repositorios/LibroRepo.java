
package com.biblioteca.Tejada.repositorios;

import com.biblioteca.Tejada.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// @author aduo

@Repository
public interface LibroRepo extends JpaRepository<Libro, Integer>{
 @Query("SELECT l FROM Libro l WHERE l.titulo= :titulo ")
public Libro buscarLibroPorTitulo(@Param("titulo")String titulo);
}
