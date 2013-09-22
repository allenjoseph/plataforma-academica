/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fii.platacad.services.interfaces.implement;

import edu.fii.platacad.services.interfaces.UsuarioInterface;

/**
 *
 * @author hp38
 */
public class UsuarioAdministrativo implements UsuarioInterface{

    @Override
    public void Login(String usuarioId, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EnviarMensaje(String mensaje, String usuarioId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void BuscarDocumentoAdministrativo(String documentoId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DescargarDocumentoAdministrativo(String documentoId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ListarCursos(String cicloId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
