/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import componentes.Bitacora;
import java.util.List;
import DAO.BitacoraDAO;

/**
 *
 * @author 6fantasticos
 */
public class ServicioBitacora {
    
    private List<Bitacora> logs;
    private BitacoraDAO bdao = new BitacoraDAO();

    public ServicioBitacora() {
        this.logs = bdao.getAll();
    }

    public List<Bitacora> getLogs() {
        return logs;
    }

    public void setLogs(List<Bitacora> logs) {
        this.logs = logs;
    }
    
}
