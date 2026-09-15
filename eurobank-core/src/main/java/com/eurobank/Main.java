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
import com.eurobank.service.AccountService;
import com.eurobank.service.CustomerService;

public class Main {


	
	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		
		CustomerService clienteService = new CustomerService();	
		CustomerRepository clienteRepository = new CustomerRepository();

		int contador = 1;
		String opcion;
		do {
            System.out.println("================================");
            System.out.println("        EUROBANK");
            System.out.println("================================");
            System.out.println("[1] Crear cliente");
            System.out.println("[2] Crear cuenta");
            System.out.println("[3] Depositar dinero");
            System.out.println("[4] Retirar dinero");
            System.out.println("[5] Transferir dinero");
            System.out.println("[6] Consultar saldo");
            System.out.println("[7] Ver movimientos");
            System.out.println("[8] Consultar clientes");
            System.out.println("[9] Consultar cuentas");
            System.out.println("[0] Salir");
            System.out.println("================================");
            System.out.print("Seleccione una opción: ");
			opcion = sc.nextLine();

			if(!opcion.isBlank()) {
				try {
				int op = Integer.parseInt(opcion);
				

					switch (op) {
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
							
							System.out.println(clienteService.listarClientes());
							
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
						System.out.println();
						break;
						
					case 2:
						
						System.out.println("================================");
						System.out.println("       CREAR CUENTA");
						System.out.println("================================");
						System.out.println("DNI: ");
						String dni = sc.nextLine();
						System.out.println("Usuario: ");
						String usuario = sc.nextLine();
						System.out.println("Password: ");
						String password = sc.nextLine();
						
						if(clienteService.existeDNI(dni)) {
							Customer cliente_ = clienteRepository.buscarPorDni(dni);
							
							if(cliente_.getName_user().equals(usuario)&&
									cliente_.getPassword().equals(password)) {
								System.out.println("=====BIENVENIDO " + cliente_.getNombre() + " " +
										cliente_.getApellido() + " =======" );
								
								System.out.println("¿DESEA CREAR UNA NUEVA CUENTA? ");
								System.out.println("[SI]");
								System.out.println("[NO]");
								System.out.print("Opcion: ");
								char crear_Y_N =  sc.nextLine().toLowerCase().charAt(0);
								if(crear_Y_N == 's') {
									AccountService.crearCuenta(cliente_, crear_Y_N);
									System.out.println(cliente_);
									
								}

								
							}else {
								System.out.println("ERROR: Por favor ingrese sus datos correctamente");	
							}
							
							
							
						}else {
							System.out.println("ERROR: Por favor ingrese sus datos correctamente");	
						
						}
						
						break;
					case 11:
						System.out.println("GRACIAS POR SU VISITA");
						break;
						

					default:
						System.out.println("\nOPCION NO VALIDA");
					}
					
				}catch (Exception e) {
					System.out.println("ERROR: Elige una Opcion");
				}
				
			}

		}while(!opcion.equals("11"));

		sc.close();
	}

}
