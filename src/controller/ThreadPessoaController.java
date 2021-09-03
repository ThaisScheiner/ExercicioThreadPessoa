package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoaController extends Thread
{
	private int Pessoa;
	private static int Chegada;
	private static int Saida;
	private Semaphore semaforo;

	public ThreadPessoaController(int Pessoa, Semaphore semaforo)
	{
		this.Pessoa = Pessoa;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() 
	{
		pessoaAndando();

		try 
		{
			semaforo.acquire();
			cruzandoPorta();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			semaforo.release();
			pessoaSaindo();
		}


	}
	
	
   private void pessoaAndando()
   {
	   int distanciaTotal = 200;
	   int distanciaPercorrida = 0;
	   int deslocamento = 0;
	   int tempo = 1000;
	   
	   while (distanciaPercorrida <distanciaTotal) 
	   {
		   deslocamento =(int)((Math.random() * 3) + 4);
		   distanciaPercorrida += deslocamento;
		   
		   try 
		   {
			   sleep(tempo);
		   }
		   catch (InterruptedException e)
		   {
			   e.printStackTrace();
		   }
		   System.out.println("A Pessoa " + Pessoa + " já andou " + distanciaPercorrida + "m.");
			   
		   }
	   		Chegada++;
	   		
	   		System.out.println("A Pessoa " + Pessoa + " foi a " + Chegada + "ª pessoa a chegar na porta");
	   }
   
   private void cruzandoPorta()
   {
	   System.out.println("A Pessoa " + Pessoa + " abriu a porta");
	   int tempo = (int)((Math.random() *1001) +1000);
	   
	   try 
	   {
		   sleep(tempo);
	   }
	   catch (InterruptedException e) 
	   {
		   e.printStackTrace();
	   }
	   System.out.println("A Pessoa " + Pessoa + " cruzou a porta");
   }
   
   private void pessoaSaindo()
   {
	   	Saida++;
		System.out.println("A Pessoa " + Pessoa + " foi a " + Saida + "ª a cruzar a porta");
   }
	
}
