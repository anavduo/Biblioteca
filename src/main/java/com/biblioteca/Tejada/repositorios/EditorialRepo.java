
package com.biblioteca.Tejada.repositorios;

// @author aduo

import com.biblioteca.Tejada.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepo extends JpaRepository<Editorial, Object>{
     @Query("SELECT e FROM Editorial e WHERE e.nombre= :nombre ")
public Editorial buscarEditorialPorNombre(@Param("nombre")String nombre);
}
