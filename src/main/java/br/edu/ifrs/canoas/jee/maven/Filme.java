package br.edu.ifrs.canoas.jee.maven;

public class Filme extends Acervo implements Alugavel 
{
	
	private String diretor;
	private String estilo;
	
	
	public String getTitulo()
	{
		return super.getTitulo();
	}
	
	public int getTempoEmprestimo()
	{
		return 0;
	}

	public String getDiretor() 
	{
		return diretor;
	}

	public void setDiretor(String diretor)
	{
		this.diretor = diretor;
	}

	public String getEstilo() 
	{
		return estilo;
	}

	public void setEstilo(String estilo)
	{
		this.estilo = estilo;
	}

	
	

}
