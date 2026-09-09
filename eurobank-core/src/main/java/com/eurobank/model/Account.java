package com.eurobank.model;

public class Account {

	private String nro_cuenta;
    private String nro_cci;
    private double saldo;
    private String movimientos;
    private boolean estado;

    public Account() {
    }

    public Account(String nro_cuenta, String nro_cci, double saldo, String movimientos, boolean estado) {
        this.nro_cuenta = nro_cuenta;
        this.nro_cci = nro_cci;
        this.saldo = saldo;
        this.movimientos = movimientos;
        this.estado = estado;
    }

    public String getNro_cuenta() {
        return nro_cuenta;
    }

    public void setNro_cuenta(String nro_cuenta) {
        this.nro_cuenta = nro_cuenta;
    }

    public String getNro_cci() {
        return nro_cci;
    }

    public void setNro_cci(String nro_cci) {
        this.nro_cci = nro_cci;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public String getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(String movimientos) {
		this.movimientos = movimientos;
	}
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
    public String toString() {
        return "\n\t\tNro Cuenta: " + nro_cuenta +
                "\n\t\tCCI: " + nro_cci +
                "\n\t\tSaldo: " + saldo ;
        
    }
	
}
