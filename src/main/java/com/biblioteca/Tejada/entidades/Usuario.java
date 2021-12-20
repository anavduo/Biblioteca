
package com.biblioteca.Tejada.entidades;

import com.bibioteca.Tejada.enums.Rol;
import javax.persistence.Entity;

// @author aduo

@Entity
public class Usuario {
private String name;
private String apellido;
private Rol rol;
private String email;
private String clave;


}
