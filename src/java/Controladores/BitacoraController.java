/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Servicios.ServicioBitacora;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import componentes.Bitacora;

/**
 *
 * @author freexploit
 */

@ManagedBean(name = "bitacoraController")
@RequestScoped
public class BitacoraController implements Serializable {

	private static final long serialVersionUID = 1L;

    private List<Bitacora> logs;
    private ServicioBitacora sb = new ServicioBitacora();

	public BitacoraController() {
        super();
    }


    public List<Bitacora> getLogs() {
        if (logs == null){
            this.logs = sb.getLogs();
        }
        return this.logs;
    }

    public void setLogs(List<Bitacora> logs) {
        this.logs = logs;
    }

	
}
