package com.eurobank.repository;

import java.util.ArrayList;

import com.eurobank.model.Customer;

public class CustomerRepository {

	ArrayList<Customer> listaClientes = new ArrayList<>();
	
	public CustomerRepository() {
		listaClientes = new ArrayList<Customer>();
	}
	
	/*
	 * UN CLIENTE TIENE SU CRUD
	 * C = CREAR
	 * R = LISTAR
	 * U = UPDATE
	 * D = DELETE (QUE EN ESTE CASO SOLO LO DAREMOS DE BAJA)
	*/
	
	//CREAR CLIENTE
	public void nuevoCliente(Customer customer) {
		
		String dni;
		
		
		
		String nombre;
		String apellido;
		String telefono;
		String correo;
		
		
		
		
		listaClientes.add(customer);
	}
	
	//LISTAR CLIENTE
	public void listar() {
		System.out.println(listaClientes);
	}
	
	//UPDATE CLIENTE
	
	
	//DELETE CLIENTE
	
	
	
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
