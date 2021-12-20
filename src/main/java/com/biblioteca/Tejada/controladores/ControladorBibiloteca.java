package com.biblioteca.Tejada.controladores;

//@author aduo
///
////return "redirect:/perro/lista"; 
import com.biblioteca.Tejada.misexcepciones.ErrorServicio;
import com.biblioteca.Tejada.servicios.AutorService;
import com.biblioteca.Tejada.servicios.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/") // localhost:8080/
public class ControladorBibiloteca {

    @Autowired
    private AutorService as;
    
    @Autowired
    private EditorialService es;

    @GetMapping("/") // localhost:8080/
    public String index() {
        return "index.html";
    }
   @GetMapping("/") // localhost:8080/
    public String login() {
        return "login.html";
    }
   @GetMapping("/") // localhost:8080/
    public String registro() {
        return "registro.html";
    }

}

