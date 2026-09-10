package com.eurobank.repository;

import java.util.ArrayList;
import java.util.List;

import com.eurobank.model.Customer;

public class CustomerRepository {

	ArrayList<Customer> listaClientes;
	//List<Customer> listaCuentas = new ArrayList<>();
	
	public CustomerRepository() {
		listaClientes = new ArrayList<Customer>();
	}
	
	//UN CLIENTE TIENE SU CRUD
	//CREAR CLIENTE
	public void agregarCliente(Customer cliente) {
		listaClientes.add(cliente);		
	}
	
	//LISTAR CLIENTE
	public List<Customer> listar() {
	    return listaClientes;
	}

	//METODO PARA BUSCAR DNI
	public Customer buscarPorDni(String dni) {
		for(Customer cliente: listaClientes) {
			if(cliente.getDni().equals(dni)) {
				return cliente;
			}
		}
		return null;
	}

}
