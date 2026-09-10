package com.eurobank;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.eurobank.exception.ApellidoErrorExceptions;
import com.eurobank.exception.CorreoErrorExceptions;
import com.eurobank.exception.DniErrorExceptions;
import com.eurobank.exception.NombreErrorExceptions;
import com.eurobank.exception.PasswordErrorExceptions;
import com.eurobank.exception.TelefonoErrorExceptions;
import com.eurobank.exception.UserErrorExceptions;
import com.eurobank.model.Customer;
import com.eurobank.repository.CustomerRepository;
import com.eurobank.service.CustomerService;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);

		CustomerService clienteService = new CustomerService();	
		CustomerRepository clienteRepository = new CustomerRepository();

		int contador = 1;
		int opcion;
		do {
			System.out.println("======================");
			System.out.println("      EUROBANK");
			System.out.println("======================");

			System.out.println("[1] Nuevo cliente");
			System.out.println("[2] Salir");

			System.out.print("Opcion: ");
			opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {
			case 1: 
				System.out.println("================================");
				System.out.println("       REGISTRO DE CLIENTES");
				System.out.println("================================");
				
				try {

					int id = contador;
					System.out.print("Ingrese DNI: ");
					String dni = sc.nextLine();

					System.out.print("Ingrese Nombre: ");
					String nombre = sc.nextLine().toUpperCase();


					System.out.print("Ingrese Apellido: ");
					String apellido = sc.nextLine().toUpperCase();


					System.out.print("Ingrese Telefono: ");
					String telefono = sc.nextLine();

					System.out.print("Ingrese Correo: ");
					String correo = sc.nextLine().toLowerCase();

					LocalDateTime fecha_creacion = LocalDateTime.now();

					System.out.print("Nombre de Usuario: ");
					String usuario = sc.nextLine();

					System.out.print("Password: ");
					String password = sc.nextLine();

					Customer cliente = clienteService.nuevoCliente(
							id, dni, nombre, apellido, telefono, correo, 
							fecha_creacion, usuario, password);

					//Esta parte solamente se ejecutará si no ocurrió ninguna excepción.
					System.out.println();
					System.out.println("Cliente registrado correctamente.");
					clienteRepository.agregarCliente(cliente);
					
					clienteService.listarClientes();
					clienteRepository.listar();
					
					contador++;

				}catch(PasswordErrorExceptions e) {
					System.out.println(e.getMessage());

				}catch(UserErrorExceptions e) {
					System.out.println(e.getMessage());

				}catch(CorreoErrorExceptions e) {
					System.out.println(e.getMessage());

				}catch(TelefonoErrorExceptions e) {
					System.out.println(e.getMessage());

				}catch (ApellidoErrorExceptions e) {
					System.out.println(e.getMessage());

				}catch(NombreErrorExceptions e) {
					System.out.println(e.getMessage());

				}catch(DniErrorExceptions e) {
					System.out.println(e.getMessage());

				}
				catch (Exception e){
					System.out.println(e.getMessage());

				}
				break;
			case 2:
				
				break;
				

			default:
				System.out.println("\nOPCION NO VALIDA");
			}

			


		}while(opcion != 2);

		sc.close();
	}

}
