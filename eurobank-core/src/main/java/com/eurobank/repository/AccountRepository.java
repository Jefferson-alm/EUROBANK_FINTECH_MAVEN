package com.eurobank.repository;

import java.util.ArrayList;
import java.util.List;

import com.eurobank.model.Account;

public class AccountRepository {
	
	List<Account> listaCuentas;
	
	//inicializamos el metodo
	public AccountRepository() {
		listaCuentas = new ArrayList<Account>();
	}
	
	//CRUD ACCOUNT
	//CREAR CUENTA
	public void crearCuenta(Account cuenta) {
		listaCuentas.add(cuenta);
	}
	
	//MOSTRAR CUENTA
	public List<Account> listarCuentas() {
		return listaCuentas;
	}
	
	//DELETE CUENTA
	//DESABILITAR CUENTA
	public boolean desabilidarCuenta(Account cuenta)
	{
		cuenta.setEstado(false);
		return cuenta.isEstado();
	}
	
	public Account buscarPorId(int id) {
		for(Account cuenta: listaCuentas) {
			if(cuenta.getId() == id) {
				return cuenta;
			}
		}
		return null;
	}
	
	
	public boolean existeNroCuenta(String nro_cuenta) {

	    for (Account cuenta : listaCuentas) {

	        if (cuenta.getNro_cuenta().equals(nro_cuenta)) {
	            return true;
	        }
	    }

	    return false;
	}
	
	public boolean existeNroCCI(String nro_cci) {

	    for (Account cuenta : listaCuentas) {

	        if (cuenta.getNro_cci().equals(nro_cci)) {
	            return true;
	        }
	    }

	    return false;
	}
}
