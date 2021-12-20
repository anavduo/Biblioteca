package com.biblioteca.Tejada.servicios;

// @author aduo
import com.biblioteca.Tejada.entidades.Autor;
import com.biblioteca.Tejada.misexcepciones.ErrorServicio;
import com.biblioteca.Tejada.repositorios.AutorRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    @Autowired
    private AutorRepo autorRepo;

    @Transactional
    public void registrarAutor(String nombre) throws ErrorServicio {
        validarAutor(nombre);
        Autor autor = new Autor();

        if (autor != null) {
            autor.setNombre(nombre);
            autor.setAlta(true);
            autorRepo.save(autor);
        } else {
            throw new ErrorServicio("No se encontró un autor con ese ID");
        }

    }

    public void validarAutor(String nombre) throws ErrorServicio {
        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("El nombre del autor no puede ser nulo");
        }
        Autor autorE = autorRepo.buscarAutorPorNombre(nombre);
        if (autorE != null) {
            throw new ErrorServicio("Ya existe un autor con ese nombre");
        }
    }

    @Transactional
    public void modificarAutor(Autor autor, String nombre) throws ErrorServicio {
        autor = autorRepo.buscarAutorPorNombre(autor.getNombre());
        if (autor != null) {
            autor.setNombre(nombre);
            autor.setAlta(true);
            autorRepo.save(autor);
        } else {
            throw new ErrorServicio("No se encontró un autor con ese nombre");
        }
    }

    @Transactional
    public void eliminarAutor(Autor autor) throws ErrorServicio {
        autor = autorRepo.buscarAutorPorNombre(autor.getNombre());
        if (autor != null) {
            autor.setAlta(false);
            autorRepo.save(autor);
        } else {
            throw new ErrorServicio("No se encontró un autor con ese nombre");
        }
    }

    @Transactional //(readOnly = true)
    public Autor getOne(Integer id) {
        return autorRepo.getOne(id);
    }

    public List<Autor> LitarTodos() {
        return autorRepo.findAll();
    }
}
