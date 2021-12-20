
package com.biblioteca.Tejada.servicios;

// @author aduo

import com.biblioteca.Tejada.entidades.Libro;
import com.biblioteca.Tejada.repositorios.LibroRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {
    @Autowired
    private LibroRepo libroRepo;


    public List<Libro> LitarTodos() {
        return libroRepo.findAll();
    }
       @Transactional //(readOnly = true)
    public Libro getOne(Integer id){
        return libroRepo.getOne(id);
    }
}
