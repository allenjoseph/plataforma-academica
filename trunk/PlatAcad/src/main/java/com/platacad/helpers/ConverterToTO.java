/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platacad.helpers;

import com.platacad.entities.Usuario;
import com.platacad.to.UsuarioTO;

/**
 *
 * @author allen
 */
public class ConverterToTO {
    
    public static UsuarioTO convertToUsuarioTO(Usuario user){
        UsuarioTO to = new UsuarioTO();
        to.setCodigo(user.getIdUsuarioPk());
        to.setNombre(user.getNombres());
        to.setNombreCompleto(user.getNombres().concat(" ").concat(user.getApellidoPaterno()).concat(" ").concat(user.getApellidoPaterno()));
        to.setRol(user.getIdRolFk().getDescripcion());
        to.setRolId(user.getIdRolFk().getIdRoPk());
        return to;
    }
}
