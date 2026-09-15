package com.eurobank.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;

import com.eurobank.model.Account;
import com.eurobank.model.Customer;
import com.eurobank.repository.AccountRepository;


public class AccountService {

	// CREAR CUENTA
	/*
	 * Para crear una cuenta debo tener lo siguiente
	 * que la opcion elegida de crear debe ser si. (recibe un character)
	 * y esta cuenta agregarlo a un cliente, nada mas
	 * 
	 * */
	static String cod_continente = "000012";	
	static String cod_pais = "9999";
	static String cod_banco = "1234";
	static int idContador = 1;
    private static AccountRepository acRepos = new AccountRepository();

	public static void crearCuenta(Customer cliente, char crear) {

		if(crear == 's') {
			SecureRandom r = new SecureRandom();

			int id = idContador;
			String nro_cuenta;
			String nro_cci;

			do {
				nro_cuenta = cod_pais + "-" + cod_banco + "-" + r.nextInt(10, 1000);
			} while (acRepos.existeNroCuenta(nro_cuenta));

			do {
				nro_cci = cod_continente + "-" + cod_pais + "-" + cod_banco + "-" + r.nextInt(10, 1000);
			} while (acRepos.existeNroCCI(nro_cci));

			double saldo = 10.00;

			String movimientos = "CUENTA CREADA: + S/ 10.00";

			boolean estado = true;
			LocalDateTime fechaCreacion = LocalDateTime.now();
			Account cuenta = new Account(id, nro_cuenta, nro_cci, saldo, movimientos, estado, fechaCreacion);

			cliente.add_account(cuenta);
			acRepos.crearCuenta(cuenta);

			System.out.println("CREANDO CUENTA");
			System.out.println(".\n.\n.\n");
			System.out.println("CUENTA CREADA-...");
			idContador++;

		}else {
			System.out.println("Regresando al menu...");
			return;
		}
	}

}
