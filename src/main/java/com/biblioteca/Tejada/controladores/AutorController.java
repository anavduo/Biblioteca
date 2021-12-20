package com.biblioteca.Tejada.controladores;

import com.biblioteca.Tejada.entidades.Autor;
import com.biblioteca.Tejada.servicios.AutorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//@author aduo
@Controller
@RequestMapping("/autor") // localhost:8080/autor
public class AutorController {

    @Autowired
    private AutorService as;

    @GetMapping("/registroAutor")// localhost:8080/autor/registroAutor/
    public String registroAutor() {
        return "registroAutor.html";
    }

    @GetMapping("/Panelautores")// localhost:8080/autor/Panelautores/
    public String panelautores(ModelMap modelo) {
        try {
            List<Autor> listaAutores = as.LitarTodos();
            modelo.addAttribute("autores", listaAutores);
            return "Panelautores.html";
        } catch (Exception e) {
            return "Panelautores.html";
        }
    }

    @GetMapping("/formautor")// localhost:8080/autor/formautor/
    public String formularioAutor() {
        return "formautor.html";
    }

    @PostMapping("/registrarAutor") // localhost:8080/autor/formautor/

    public String registrarAutor(ModelMap modelo, @RequestParam String nombre) throws Exception {
        try {
            as.registrarAutor(nombre);
            modelo.put("exito", "Registro exitoso");
            return formularioAutor() ;
        } catch (Exception e) {
            modelo.put("error", "Problemas al persistir el objeto. " + e.getMessage());
            return formularioAutor() ;
        }
    }

    @GetMapping("/modificar/{id}")// localhost:8080/autor/modificar/
    public String modificarAutor(ModelMap modelo, @PathVariable Integer id) throws Exception {
        try {
            modelo.put("autor", as.getOne(id));
            return "formautor-modif.html";
        } catch (Exception e) {
            modelo.put("error", "Problemas al modificar el autor. " + e.getMessage());
            return  "formautor-modif.html";
        }
    }

    @PostMapping("/autor/modificar/{id}") // localhost:8080/autor/modificar/
    public String modificar(ModelMap modelo, @PathVariable String id, @RequestParam String nombre, @RequestParam Autor autor, RedirectAttributes redirectAttributes) {
        try {
            as.modificarAutor(autor, nombre);
            modelo.put("exito", "Modificacion exitosa");
            redirectAttributes.addFlashAttribute("exito",
                    "Modificacion Exitosa");
            return "redirect:/autor/Panelautores";
        } catch (Exception e) {
            modelo.put("error", "Falto algun dato");
          return panelautores(modelo);
        }
    }
     @GetMapping("/alta/{id}")// localhost:8080/autor/alta/
    public String darAltaAutor(ModelMap modelo, @PathVariable Integer id) throws Exception {
        try {
            modelo.put("autor", as.getOne(id));
            return "Panelautores.html";
        } catch (Exception e) {
            modelo.put("error", "Problemas al dar de alta el autor. " + e.getMessage());
             return "Panelautores.html";
        }
    }

    @PostMapping("/alta/{id}") // localhost:8080/autor/alta/
    public String darAlta(ModelMap modelo, @PathVariable String id, @RequestParam String nombre, @RequestParam Autor autor, RedirectAttributes redirectAttributes) {
        try {
            as.modificarAutor(autor, nombre);
            modelo.put("exito", "Modificacion exitosa");
            redirectAttributes.addFlashAttribute("exito",
                    "Modificacion Exitosa");
            return "redirect:/autor/Panelautores.html";
        } catch (Exception e) {
            modelo.put("error", "Falto algun dato");
          return panelautores(modelo);
        }
    }
}
//@GetMapping("/baja/{id}") public String baja(@PathVariable String id) { try { aService.dropAuthor(id); return "redirect:/autor/lista"; } catch (Exception e) { return "redirect:/"; } } 
