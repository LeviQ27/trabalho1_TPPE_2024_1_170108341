package com.trabalho1;


public class Endereco {

    private String estado;
    private boolean eCapital;

    public Endereco(String estado, boolean eCapital){
        this.estado = estado;
        this.eCapital = eCapital;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean iseCapital() {
        return eCapital;
    }

    public void seteCapital(boolean eCapital) {
        this.eCapital = eCapital;
    }

    

}
