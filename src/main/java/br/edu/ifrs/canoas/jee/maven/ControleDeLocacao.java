package br.edu.ifrs.canoas.jee.maven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ControleDeLocacao {

	
	public Map <Associado, List<Acervo>> emprestimos = new HashMap<Associado, List<Acervo>>();
	
	
	public List<Acervo> getObjectList(Associado a1)
	{
		if(a1 == null)
		{
			return null;
		}
		
		if(!emprestimos.containsKey(a1))
		{
			return null;
		}
		
		return emprestimos.get(a1);
	}
	
	public Acervo getObjElement(Associado a1, int i)
	{
		if(a1 == null || i < 0)
		{
			return null;
		}
		
		if(!emprestimos.containsKey(a1) || emprestimos.get(a1).isEmpty())
		{
			return null;
		}
		
		if(i > emprestimos.get(a1).size())
		{
			return null;
		}
		
		
		return emprestimos.get(a1).get(i);
	}
	
	
	public Map<Associado, List<Acervo>> getEmprestimos()
	{
		return emprestimos;
	}
	
	public boolean adicionaEmprestimo(Associado associado, Acervo acervo)
	{
		if(acervo.isLocado() || associado == null|| acervo == null)
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
		if(associado == null || acervo == null|| !acervo.isLocado())
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
		int count = 0;
		for (Entry<Associado, List<Acervo>> e: emprestimos.entrySet())
		{
			count += e.getValue().size();
		}
		
		return count;
	}
	
	
	
}
