package com.eurobank.service;

import java.time.LocalDateTime;
import java.util.List;

import com.eurobank.exception.ApellidoErrorExceptions;
import com.eurobank.exception.CorreoErrorExceptions;
import com.eurobank.exception.DniErrorExceptions;
import com.eurobank.exception.NombreErrorExceptions;
import com.eurobank.exception.PasswordErrorExceptions;
import com.eurobank.exception.TelefonoErrorExceptions;
import com.eurobank.exception.UserErrorExceptions;
import com.eurobank.model.Customer;
import com.eurobank.repository.CustomerRepository;

public class CustomerService {

	private CustomerRepository clienteRepository;

	public CustomerService() {
		clienteRepository = new CustomerRepository();
	}

	public Customer nuevoCliente(int id, String dni, String nombre, String apellido, String telefono, String correo, LocalDateTime fecha_creacion, String name_user ,String password)
			throws 
			DniErrorExceptions, 
			NombreErrorExceptions,
			ApellidoErrorExceptions,
			TelefonoErrorExceptions,
			CorreoErrorExceptions,
			UserErrorExceptions,
			PasswordErrorExceptions
	{

		//valido el dni
		validarDni(dni);
		//e inmediatamente verifico que no existe
		existeDNI(dni);
		
		validarNombre(nombre);
		validarApellido(apellido);
		validarTelefono(telefono);
		validarCorreo(correo);
		validarUser(name_user);
		validarPassword(password);

		Customer cliente = new Customer(
				id, dni, nombre, apellido, telefono, 
				correo, fecha_creacion, name_user, password);

		clienteRepository.agregarCliente(cliente);
		
		return cliente;
	}

	private void validarPassword(String password) throws PasswordErrorExceptions {
		if(password.isBlank()) {
			throw new PasswordErrorExceptions("ERROR: La contraseña no puede estar vacio");
		}
	}

	private void validarUser(String name_user) throws UserErrorExceptions {

		if(name_user.isBlank()) {
			throw new UserErrorExceptions("ERROR: El nombre de Usuario no puede estar vacio");
		}
		else {
			//el nombre de usuario no debe tener espacios
			for(int i = 0; i < name_user.length(); i++) {
				if(name_user.charAt(i) == ' ') {
					throw new UserErrorExceptions("ERROR: Nombre de usuario no debe tener espacios");
				}
			}
		}
	}

	private void validarCorreo(String correo) throws CorreoErrorExceptions {
		if(correo.isBlank()) {
			System.out.println("ERROR: El correo no puede estar vacio");
		}else {	

			for(int i = 0; i < correo.length(); i++) {
				if(correo.charAt(i) == ' ') {
					throw new CorreoErrorExceptions("ERROR: El correo no puede tener espacios");
				}
			}

			boolean arroba = false;

			for(int i = 0; i < correo.length(); i++) {

				if(correo.charAt(i) == '@') {
					arroba = true; 
					if(arroba) {
						String correo_part1 = correo.substring(0, i);
						String correo_part2 = correo.substring(i, correo.length());

						if(correo_part1.length() < 5 || !(correo_part2.equals("@gmail.com"))) {
							throw new CorreoErrorExceptions("ERROR: CORREO nombre erroneo o no es @gmail.com");
						}else {
							break;
						}
					}else {
						throw new CorreoErrorExceptions("ERROR: CORREO no valido");
					}
				}
			}
			if(!arroba) {
				throw new CorreoErrorExceptions("ERROR: CORREO no valido (@gmail.com)");
			}

		}
	}

	private void validarTelefono(String telefono) throws TelefonoErrorExceptions {

		if(telefono.isBlank()) {
			throw new TelefonoErrorExceptions("ERROR: El TELEFONO no puede estar vacio");
		}else {
			//validar si tiene 9 caracteres
			if(telefono.length() == 9) {
				for(int i = 0; i < telefono.length(); i++) {
					if(!Character.isDigit(telefono.charAt(i))) {
						throw new TelefonoErrorExceptions("ERROR: TELEFONO debe contener solo numeros");
					}
				}
			} else {
				throw new TelefonoErrorExceptions("ERROR: El nro de TELEFONO debe contener 9 CARACTERES");
			}
		}
	}

	private void validarApellido(String apellido) throws ApellidoErrorExceptions{
		if(apellido.isBlank() || apellido.isEmpty()) {
			throw new ApellidoErrorExceptions("ERROR: El APELLIDO no puede estar vacio"+ apellido);
		}else {
			for(int i = 0; i < apellido.length(); i++){
				if(!Character.isLetter(apellido.charAt(i)) && !Character.isSpaceChar(apellido.charAt(i))) {
					throw new ApellidoErrorExceptions("ERROR: El APELLIDO NO puede contener NUMEROS o CARACTERES ESPECIALES");
				}
			}
		}		
	}

	private void validarNombre(String nombre) throws NombreErrorExceptions{
		if (nombre.isBlank() || nombre.isEmpty()) {
			throw new NombreErrorExceptions("ERROR: El NOMBRE no puede estar vacío.");
		}else {
			for(int i = 0; i< nombre.length(); i++) {
				if(!Character.isLetter(nombre.charAt(i)) &&
						!Character.isSpaceChar(nombre.charAt(i))) {
					throw new NombreErrorExceptions("ERROR: El NOMBRE NO puede contener NUMEROS o CARACTERES ESPECIALES");
				}
			}
		}
	}

	private void existeDNI(String dni) throws DniErrorExceptions{
		Customer clienteExistente = clienteRepository.buscarPorDni(dni);
		//si existe mando un error, si no continuo
		if(clienteExistente != null) {
			throw new DniErrorExceptions("EL DNI YA EXISTE: " + dni+"\n");
		}
	}
	
	private void validarDni(String dni) throws DniErrorExceptions {
		//que no este en blanco o vacio
		if (dni == null || dni.isBlank()) {
			throw new DniErrorExceptions("El DNI no puede estar vacío.");
		}

		//Que tenga 8 digitos
		if (!dni.matches("\\d{8}")) {
			throw new DniErrorExceptions("El DNI debe contener exactamente 8 números.");
		}
	}

	/*
	 * Método para mostrar todos los clientes almacenados actualmente.
	 */
	public List<Customer> listarClientes() {
	    return clienteRepository.listar();
	}


}
