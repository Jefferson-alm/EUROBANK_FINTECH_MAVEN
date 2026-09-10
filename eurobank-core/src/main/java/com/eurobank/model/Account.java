package com.eurobank.model;

import java.time.LocalDateTime;

public class Account {

	private int id;
	private String nro_cuenta;
    private String nro_cci;
    private double saldo;
    private String movimientos;
    private boolean estado;
    private LocalDateTime fechaCreacion;

    public Account() {
    }

    public Account(int id, String nro_cuenta, String nro_cci, double saldo, String movimientos, boolean estado, LocalDateTime fechaCreacion) {
    	this.id = id;
        this.nro_cuenta = nro_cuenta;
        this.nro_cci = nro_cci;
        this.saldo = saldo;
        this.movimientos = movimientos;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;

    }
   
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	

	@Override
    public String toString() {
        return "\n\t\tID_Cuenta: " + id +
        		"\n\t\tNro Cuenta: " + nro_cuenta +
                "\n\t\tCCI: " + nro_cci +
                "\n\t\tSaldo: " + saldo +
                "\n\t\tEstado: " + estado ;
        
    }
	
}
