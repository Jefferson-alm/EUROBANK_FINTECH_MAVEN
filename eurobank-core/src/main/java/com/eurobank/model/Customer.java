package com.eurobank.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Customer extends Person {

	private String name_user; 
	private String password;
	private LocalDateTime fecha_creacion;
	
	List<Account> listaCuentas = new ArrayList<Account>();
	
	
	public Customer() {
		
	}
	
	public Customer(int id, String dni_cliente, String nombre_cliente, String apellido_cliente, String telefono_cliente, String correo_electronico, LocalDateTime fecha_creacion, String name_user ,String password) {
		super(id, dni_cliente, nombre_cliente, apellido_cliente, telefono_cliente, correo_electronico);
		this.fecha_creacion = fecha_creacion;
		this.name_user = name_user;
		this.password = password;
	}

	public Customer(int id, String dni_cliente, String nombre_cliente, String apellido_cliente, String telefono_cliente, String correo_electronico, LocalDateTime fecha_creacion, String password, ArrayList<Account> listaCuentas) {
		super(id, dni_cliente, nombre_cliente, apellido_cliente, telefono_cliente, correo_electronico);
		this.fecha_creacion = fecha_creacion;
		this.password = password;
		this.listaCuentas = listaCuentas;
	}
	
	
	public LocalDateTime getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(LocalDateTime fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public String getName_user() {
		return name_user;
	}
	public void setName_user(String name_user) {
		this.name_user = name_user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Account> getListaCuentas() {
		return listaCuentas;
	}
	
	public void add_account(Account cuenta) {
		listaCuentas.add(cuenta);
	}
	
	@Override
	public String toString() {
		return 	super.toString() + 			
				"\n\tUSUARIO: " + name_user +
				"\n\tFECHA CREACION: " + fecha_creacion +
				"\n\tCUENTAS: " + listaCuentas +
				"\n";
	}
	
	
}
