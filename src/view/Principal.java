package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPessoaController;

public class Principal {

	public static void main(String[] args) 
	{
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for (int Pessoa = 0 ; Pessoa <4 ; Pessoa++) {
			Thread tPessoa = new ThreadPessoaController(Pessoa, semaforo);
			tPessoa.start();
		}
	}

}
