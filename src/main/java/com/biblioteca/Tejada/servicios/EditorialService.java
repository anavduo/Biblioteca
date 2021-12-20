package com.biblioteca.Tejada.servicios;

// @author aduo
import com.biblioteca.Tejada.entidades.Editorial;
import com.biblioteca.Tejada.misexcepciones.ErrorServicio;
import com.biblioteca.Tejada.repositorios.EditorialRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialService {

    @Autowired
    private EditorialRepo editorialRepo;
  
   @Transactional
    public void registrarEditorial(String nombre) throws ErrorServicio {
        validarEditorial(nombre);
        Editorial editorial = new Editorial();
        Editorial editorialAux= editorialRepo.buscarEditorialPorNombre(nombre);
        if (editorial!=null) {
            editorial.setNombre(nombre);
            editorial.setAlta(true);
            editorialRepo.save(editorial);
        } else {
            throw new ErrorServicio("No se encontró una editorial con ese ID");
        }
    }

    public void validarEditorial(String nombre) throws ErrorServicio {
        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("El nombre de la editorial no puede ser nulo");
        }
    }
      public void modificarEditorial(Editorial editorial, String nombre) throws ErrorServicio {
        editorial= editorialRepo.buscarEditorialPorNombre(editorial.getNombre());
        if (editorial != null) {
            editorial.setNombre(nombre);
           editorial.setAlta(true);
            editorialRepo.save(editorial);
        } else {
            throw new ErrorServicio("No se encontró una editorial con ese nombre");
        }
    }
       public void eliminarEditorial(Editorial editorial) throws ErrorServicio {
        editorial= editorialRepo.buscarEditorialPorNombre(editorial.getNombre());
        if (editorial != null) {
           editorial.setAlta(false);
            editorialRepo.save(editorial);
        } else {
            throw new ErrorServicio("No se encontró una editorial con ese nombre");
        }
    }
        @Transactional //(readOnly = true)
    public Editorial getOne(Integer id){
        return editorialRepo.getOne(id);
    }

    public List<Editorial> LitarTodos() {
        return editorialRepo.findAll();
    }
}
