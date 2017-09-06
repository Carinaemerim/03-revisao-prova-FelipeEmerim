package br.edu.ifrs.canoas.jee.maven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControleDeLocacao {

	
	private Map <Associado, List<Acervo>> emprestimos = new HashMap<Associado, List<Acervo>>();
	
	
	public Map<Associado, List<Acervo>> getEmprestimos()
	{
		return emprestimos;
	}
	
	public boolean adicionaEmprestimo(Associado associado, Acervo acervo)
	{
		if(acervo.isLocado())
		{
			return false;
		}
		
		if (emprestimos.get(associado) == null)
		{
			List <Acervo> list = new ArrayList<Acervo>();
			acervo.setLocado(true);
			list.add(acervo);
			emprestimos.put(associado, list);
		}
			
			
			else
			{
				acervo.setLocado(true);
				emprestimos.get(associado).add(acervo);
			}
		
		return true;
		
			
		
		
		
	}
	
	public boolean devolveEmprestimo(Associado associado, Acervo acervo)
	{
		if(!acervo.isLocado())
		{
			return false;
		}
		
		if(emprestimos.get(associado).contains(acervo))
		{
			acervo.setLocado(false);
			emprestimos.get(associado).remove(acervo);
		}
		
		return true;
	}
	public int getTotalLocados()
	{
		return emprestimos.values().size();
	}
	
	
	
}
