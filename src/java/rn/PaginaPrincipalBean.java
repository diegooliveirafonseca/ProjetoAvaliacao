/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rn;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author diego
 */
@ManagedBean(name = "MenuBean")
public class PaginaPrincipalBean {
    
    public String menuUsuario(){
        return "cadastroUsuario";
    }
}
