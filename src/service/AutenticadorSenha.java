package service;

import model.Recurso;
import model.Usuario;

public class AutenticadorSenha implements Autenticador {

    private Autenticador proximo;

    @Override
    public String autenticar(Usuario usuario, String senha, Recurso recurso) {
        if (!usuario.getSenha().equals(senha)) {
            return "Senha inválida";
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
