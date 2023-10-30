package service;

import model.Recurso;
import model.Usuario;

public interface Autenticador {
    String autenticar(Usuario usuario, String senha, Recurso recurso);
    void setProximo(Autenticador proximo);
}

