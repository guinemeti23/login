package service;

import model.Recurso;
import model.Usuario;

public class AutenticadorPerfil implements Autenticador {

    private Autenticador proximo;

    @Override
    public String autenticar(Usuario usuario, String senha, Recurso recurso) {
        if (!usuario.getPerfil().equals(recurso.getPerfilNecessario())) {
            return "Acesso negado ao recurso " + recurso.getNome();
        }
        if (proximo != null) {
            return proximo.autenticar(usuario, senha, recurso);
        }
        return "Autenticação falhou";
    }

    @Override
    public void setProximo(Autenticador proximo) {
        this.proximo = proximo;
    }
}
