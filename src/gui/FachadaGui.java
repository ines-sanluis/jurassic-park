/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.FachadaAplicacion;
import java.awt.Frame;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author alumnogreibd
 */
public class FachadaGui {
    FachadaAplicacion fa;
    VPrincipal vp;
    private String tipoUser;
    
    public FachadaGui(FachadaAplicacion fa) {
        this.fa = fa;
        this.vp = null;
        tipoUser = null;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }
    
    public void iniciaLog(){
        VAutentificacion va = new VAutentificacion(vp, true, fa); 
        //vp.setVisible(false); //Ventana principal disponhible se metes os datos ben
        va.setVisible(true); //Intentar de novo 
        String gongFile = "musica.wav";
        try{
    InputStream in = new FileInputStream(gongFile);

    // create an audiostream from the inputstream
    AudioStream audioStream = new AudioStream(in);

    // play the audio clip with the audioplayer class
    AudioPlayer.player.start(audioStream);
        }
        catch(Exception e) {}
    }
    
    public void iniciaVista(){
        vp = new VPrincipal(fa, tipoUser);
        vp.setVisible(true); //Ventana principal disponhible se metes os datos ben7
        
    }
    
    public void muestraExcepcion(String txtExcepcion){
       VAviso va = new VAviso(vp, true, txtExcepcion);
       va.setVisible(true);
    }

    public void iniciaGestionEspecies() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void iniciaGestionDinos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void iniciaGestionInc() {
        VIncidencias vi = new VIncidencias(vp, true, fa);
        vi.setVisible(true);
    }

    public void iniciaGestionEmp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void iniciaGestionAct() {
        VActividades va = new VActividades(vp, true, fa, tipoUser);
        va.setVisible(true);
    }

    public void iniciaGestionEstadisticas() {
        VEstadisticas ve = new VEstadisticas(vp, true, fa);
        ve.setVisible(true);
    }

    public void iniciaGestionGuias(VActividades vp, String a) {
        VGuias vg = new VGuias(vp, true, fa, a);
        vg.setVisible(true);
    }
    
   
    
    
}
