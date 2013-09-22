/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fii.platacad.services.interfaces;

/**
 *
 * @author hp38
 */
public interface UsuarioInterface {
    
    public void Login(String usuarioId, String password);
    public void EnviarMensaje(String mensaje, String usuarioId);
    public void BuscarDocumentoAdministrativo(String documentoId);
    public void DescargarDocumentoAdministrativo(String documentoId);
    public void ListarCursos(String cicloId);
}
