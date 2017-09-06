package br.edu.ifrs.canoas.jee.maven;

public class Jogo extends Acervo implements Alugavel 
{

	private String plataforma;
	
	public String getTitulo()
	{
		return super.getTitulo();
	}
	
	public int getTempoEmprestimo()
	{
		return 0;
	}

	public String getPlataforma()
	{
		return plataforma;
	}

	public void setPlataforma(String plataforma) 
	{
		this.plataforma = plataforma;
	}
	
	
}
