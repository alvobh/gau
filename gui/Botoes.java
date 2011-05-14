package GUI;


import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JTextField;

class Botao
{
    public char code;

    public Botao (char code)
    {
	this.code = code;
    }

    public boolean check (Botao b)
    {
	return this.code == b.code;
    }

    public static Botao read (JTextField j)
    {
	char c = j.getText().charAt(0);
	if (c == ' ') return null;
	else return new Botao (c);
    }
}

class BotaoEfetivo
{
    private EquipeEfetiva equipe;
    private Botao hardware;

    public BotaoEfetivo (EquipeEfetiva e, Botao b)
    {
	this.equipe = e;
	this.hardware = b;
    }

    public EquipeEfetiva check (Botao b)
    {
	return hardware.check (b) ? equipe : null;
    }

    public boolean check_team (Equipe e)
    {
	return equipe.contains (e);
    }

}

class Botoes
{
    private ArrayList<BotaoEfetivo> sistema;
    int n;

    public Botoes (int n)
    {
	this.n = n;
	sistema = new ArrayList<BotaoEfetivo> (n);
    }

    public boolean match (Equipe e, Botao b)
    {
	/*
	* associa a equipe "e" ao botão "b" no sistema de botões objeto
	* retorna true caso dê tudo certo
	* retorna false caso já exista equipe com o mesmo nome
	*/

	EquipeEfetiva teste;
	int i = 0;

	while (i < sistema.size())
	{
	    teste = sistema.get(i).check (b);
	    if (teste != null)
	    {
		teste.add (e);
		return true;
	    }
	    else if (sistema.get(i).check_team (e))
		return false;
	    else
		i++;
	}

	teste = new EquipeEfetiva (e);
	sistema.add (new BotaoEfetivo (teste, b));
	return true;
    }

    public EquipeEfetiva press (Botao b)
    {
	/*
	* aperta o botão "b" sob o sistema de botões objeto
	* retorna a equipe correpondente
	*         ou null caso o botão não exista no sistema
	*/

	EquipeEfetiva correspondente;
	int i = 0;

	while (i < sistema.size())
	{
	    correspondente = sistema.get(i).check (b);
	    if (correspondente != null) return correspondente;
	    else i++;
	}

	return null;
    }

    public int size ()
    {
	return n;
    }

}
