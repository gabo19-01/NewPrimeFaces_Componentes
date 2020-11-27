/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package Controladores;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.UnselectEvent;

@ManagedBean(name = "checkBoxController")
@javax.faces.bean.RequestScoped
public class checkBoxController implements Serializable{

    private String[] selectedCorreos;
    private List<String> correos;

    @PostConstruct
    public void init() {
        correos = new ArrayList<String>();
        correos.add("josexpablox@gmail.com");
        correos.add("gabrielgranadosc@gmail.com");
        correos.add("gabriel.granados@ulatina.net");

    }

    public String[] getSelectedCorreos() {
        return selectedCorreos;
    }

    public void setSelectedCorreos(String[] selectedCorreos) {
        this.selectedCorreos = selectedCorreos;
    }

    public List<String> getCorreos() {
        return correos;
    }

    public void setCorreos(List<String> correos) {
        this.correos = correos;
    }

    public void onItemUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();

        FacesMessage msg = new FacesMessage();
        msg.setSummary("Item unselected: " + event.getObject().toString());
        msg.setSeverity(FacesMessage.SEVERITY_INFO);

        context.addMessage(null, msg);
    }
}