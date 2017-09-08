package br.edu.ifrs.canoas.jee.maven;

import static org.assertj.core.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;





public class ControleDeLocacaoTeste 
{

	ControleDeLocacao cdl;
	
	@Before
	public void setup() {
		cdl = new ControleDeLocacao();
	}
	
	@Test
	public void adicionaEmprestimoTest()
	{
		Associado a1 = createAssociado();
		Filme f1 = createFilme();
		
		cdl.adicionaEmprestimo(a1, f1);
		
		Acervo f2 = new Filme();
				
		f2 = cdl.getObjElement(a1, 0);
		
		assertThat(f2.getTitulo()).isEqualTo("o masssacre da tesoura");
		
	}
	
	@Test
	public void adicionaDoisEmprestimosTeste()
	{
		Associado a1 = createAssociado();
		Filme f1 = createFilme();
		
		cdl.adicionaEmprestimo(a1, f1);
		
		Jogo j1 = createJogo();
		
		
		cdl.adicionaEmprestimo(a1, j1);
		
		assertThat(cdl.getObjElement(a1, 0).getTitulo()).isEqualTo("o masssacre da tesoura");
		assertThat(cdl.getObjElement(a1, 1).getTitulo()).isEqualTo("Half-life 3");
	}
	
	@Test
	public void getTotalLocadosTeste()
	{
		Associado a1 = createAssociado();
		Filme f1 = createFilme();
		
		cdl.adicionaEmprestimo(a1, f1);
		
		Jogo j1 = createJogo();
		
		
		cdl.adicionaEmprestimo(a1, j1);
		
		Associado a2 = createAssociado();
		a2.setCodigo("A2");
		
		Jogo j2 = createJogo();
		j2.setCodigo("J2");
		
		cdl.adicionaEmprestimo(a2, j2);
		
		assertThat(cdl.getTotalLocados()).isEqualTo(3);
	}
	
	@Test
	public void locaNullTeste()
	{
		Filme f1 = createFilme();
		Associado a1 = null;
		
		assertThat(cdl.adicionaEmprestimo(a1, f1)).isEqualTo(false);
	}
	
	@Test
	public void devolveNullTeste()
	{
		Filme f1 = null;
		Associado a1 = null;
		
		assertThat(cdl.devolveEmprestimo(a1, f1)).isEqualTo(false);
	}
	
	@Test
	public void adicionaFilmeLocadoTeste()
	{
		Filme f1 = createFilme();
		Associado a1 = createAssociado();
		
		cdl.adicionaEmprestimo(a1,f1);
		Associado a2 = createAssociado();
		
		a2.setCodigo("A2");
		
		assertThat(cdl.adicionaEmprestimo(a2, f1)).isEqualTo(false);
	}
	
	@Test
	public void getElementoMapaTeste()
	{
		Associado a1 = createAssociado();
		Filme f1 = createFilme();
		
		assertThat(cdl.getObjElement(a1, -1)).isEqualTo(null);
		assertThat(cdl.getObjElement(a1, 0)).isEqualTo(null);
		
		cdl.adicionaEmprestimo(a1, f1);
		assertThat(cdl.getObjElement(a1, 7)).isEqualTo(null);
		
		a1 = null;
		
		assertThat(cdl.getObjectList(a1)).isEqualTo(null);
		
		
	}
	
	@Test
	public void DevolveEmprestimoTeste()
	{
		Associado a1 = createAssociado();
		Filme f1 = createFilme();
		
		cdl.adicionaEmprestimo(a1, f1);
		assertThat(cdl.devolveEmprestimo(a1, f1)).isEqualTo(true);
		assertThat(f1.isLocado()).isEqualTo(false);
		assertThat(cdl.getObjElement(a1, 0)).isEqualTo(null);
	}
	
	public Filme createFilme()
	{
		Filme f1 = new Filme();
		f1.setCodigo("F1");
		f1.setDiretor("Carina");
		f1.setEstilo("Terror");
		f1.setLocado(false);
		f1.setTitulo("o masssacre da tesoura");
		
		return f1;
	}
	
	public Jogo createJogo()
	{
		Jogo j1 = new Jogo();
		j1.setCodigo("J1");
		j1.setLocado(false);
		j1.setPlataforma("playstation 4");
		j1.setTitulo("Half-life 3");
		
		return j1;
	}
	
	public Associado createAssociado()
	{
		Associado a1 = new Associado();
		a1.setCodigo("A1");
		a1.setNome("Felipe Emerim");
		return a1;
	}

}
