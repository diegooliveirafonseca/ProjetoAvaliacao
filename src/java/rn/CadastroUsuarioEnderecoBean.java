/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rn;

import DAO.UsuarioDAO;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Endereco;
import modelo.Usuario;

/**
 *
 * @author Marcus Pantoja
 */
@SessionScoped  //Escop de sessão -> para atualizar o endereço do usuário
@ManagedBean(name = "cadastroUsuarioEnderecoBean")
public class CadastroUsuarioEnderecoBean {

    private Usuario usuario;
    private Endereco endereco;

    public String salvar() {
        UsuarioDAO udao = new UsuarioDAO();
        usuario.setEndereco(endereco);
        endereco.setUsuario(usuario);
        if (usuario.getCodUsuario() == null) {
            udao.salvar(usuario);
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Salvo com Sucesso", ""));
        } else {
            udao.atualizar(usuario);
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Atualizado com Sucesso", ""));
        }
        limpar();

        return "index";
    }

    public String listarUsuarios() {
        return "listagem";
    }

    public void limpar() {
        setUsuario(null);
        setEndereco(null);

    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        if (endereco == null) {
            endereco = new Endereco();
        }
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
