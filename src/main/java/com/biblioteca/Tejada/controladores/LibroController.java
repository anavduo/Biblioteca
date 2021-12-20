
package com.biblioteca.Tejada.controladores;

// @author aduo

import com.biblioteca.Tejada.entidades.Libro;
import com.biblioteca.Tejada.misexcepciones.ErrorServicio;
import com.biblioteca.Tejada.servicios.LibroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/libro") // localhost:8080/libro
public class LibroController {

  @Autowired
  private LibroService ls;
    @GetMapping("/registroLibro")// localhost:8080/libro/registroLibro/
    public String registroLibro() {
        return "registroLibro.html";
    }
     @GetMapping("/formLibro")// localhost:8080/libro/formLibro/
    public String formularioLibro() {
        return "formLibro.html";
    }
     @GetMapping("/PanelLibro")// localhost:8080/libro/PanelLibros/
    public String panelLibro(ModelMap modelo) {
        try {
            List<Libro> listaLibros = ls.LitarTodos();
            modelo.addAttribute("libros", listaLibros);
            return "PanelLibros.html";
        } catch (Exception e) {
            return "PanelLibros.html";
        }
    }
//    @PostMapping("/editorial/registrarEditorial")
//    public String registrarEditorial(ModelMap modelo, @RequestParam(required = false) String titulo) throws Exception {
//        try {
//            ls.registrarLibro(titulo);
//            modelo.put("exito", "Exitoso registro!!");
//            return formularioLibro();
//        } catch (ErrorServicio e) {
//            modelo.put("error", "Problemas al crear el libro"+ e.getMessage());
//            return formularioLibro();
//        }
//    }
//      @GetMapping("/modificar/{id}")// localhost:8080/libro/modificar/
//    public String modificarEditorial(ModelMap modelo, @PathVariable Integer id) throws Exception {
//        try {
//            modelo.put("libro", ls.getOne(id));
//            return "formeditorial-modif.html";
//        } catch (Exception e) {
//            modelo.put("error", "Problemas al modificar la editorial. " + e.getMessage());
//            return  "formeditorial-modif.html";
//        }
//    }
}
