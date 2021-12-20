
package com.biblioteca.Tejada.controladores;

//@author aduo

import com.biblioteca.Tejada.entidades.Editorial;
import com.biblioteca.Tejada.misexcepciones.ErrorServicio;
import com.biblioteca.Tejada.servicios.EditorialService;
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

@Controller
@RequestMapping("/editorial") // localhost:8080/autor
public class EditorialController {
  @Autowired
  private EditorialService es;
    @GetMapping("/registroEditorial")// localhost:8080/registroEditorial/
    public String registroEditorial() {
        return "registroEditorial.html";
    }
     @GetMapping("/formEditorial")// localhost:8080/formeditorial/
    public String formularioEditorial() {
        return "formEditorial.html";
    }
     @GetMapping("/Paneleditoriales")// localhost:8080/autor/Paneleditoriales/
    public String paneleditoriales(ModelMap modelo) {
        try {
            List<Editorial> listaEditoriales = es.LitarTodos();
            modelo.addAttribute("editoriales", listaEditoriales);
            return "Paneleditoriales.html";
        } catch (Exception e) {
            return "Paneleditoriales.html";
        }
    }
    @PostMapping("/editorial/registrarEditorial")
    public String registrarEditorial(ModelMap modelo, @RequestParam(required = false) String nombre) throws Exception {
        try {
            es.registrarEditorial(nombre);
            modelo.put("exito", "Exitoso registro!!");
            return formularioEditorial();
        } catch (ErrorServicio e) {
            modelo.put("error", "Problemas al crear la editorial"+ e.getMessage());
            return formularioEditorial();
        }
    }
      @GetMapping("/modificar/{id}")// localhost:8080/editorial/modificar/
    public String modificarEditorial(ModelMap modelo, @PathVariable Integer id) throws Exception {
        try {
            modelo.put("editorial", es.getOne(id));
            return "formEditorial-modif.html";
        } catch (Exception e) {
            modelo.put("error", "Problemas al modificar la editorial. " + e.getMessage());
            return  "formEditorial-modif.html";
        }
    }
     @PostMapping("/autor/modificar/{id}") // localhost:8080/autor/modificar/
    public String modificar(ModelMap modelo, @PathVariable String id, @RequestParam String nombre, @RequestParam Editorial editorial, RedirectAttributes redirectAttributes) {
        try {
            es.modificarEditorial(editorial, nombre);
            modelo.put("exito", "Modificacion exitosa");
            redirectAttributes.addFlashAttribute("exito",
                    "Modificacion Exitosa");
            return "redirect:/editorial/Paneleditoriales";
        } catch (Exception e) {
            modelo.put("error", "Falto algun dato");
          return paneleditoriales(modelo);
        }
    }
    
}
