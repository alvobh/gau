package GUI;


import GUI.Botoes;
import java.util.ArrayList;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Prova
{
    private int[] pontuacao;
    private String nome;
    protected ArrayList<EquipeEfetiva> colocacao;

    public Prova (String pontuacao, String nome, int num_equipes)
    {
	int[] p_aux = new int[num_equipes];
	String[] aux = pontuacao.split ("/");
	boolean parser = true;
	int end = 0;

	for (int i = 0; i < num_equipes; i++)
	{
	    if (parser)
	    {
		if (i == aux.length)
		{
		    parser = false;
		    end = 0;
		}
		else if (aux[i].equals("..."))
		{
		    parser = false;
		    end = p_aux[i-1];
		}
		else end = Integer.parseInt(aux[i]);
	    }
	    p_aux[i] = end;
	}

	this.pontuacao = p_aux;
	this.nome = nome;
	this.colocacao = new ArrayList<EquipeEfetiva> (num_equipes);
    }

    public String results (int i)
    {
	String resultado = "";
        if(i<colocacao.size()){
            resultado = colocacao.get(i) + " : " + pontuacao[i] + " ptos";
            return resultado;
        }
        else
            return null;
    }

    public int size ()
    {
	return pontuacao.length;
    }

    public String toString ()
    {
	return nome;
    }

}

class ProvaComBotao extends Prova
{
    private Botoes sistema;

    public ProvaComBotao (String pontuacao, String nome, Botoes sistema)
    {
	super (pontuacao, nome, sistema.size());
	this.sistema = sistema;
    }

    public EquipeEfetiva press (Botao b, JPanel p, char escolha)
    {
	EquipeEfetiva correspondente;
	correspondente = sistema.press (b);
	if (correspondente != null)
	{
	    if (colocacao.contains (correspondente))
		return null;
	    else
	    {
		colocacao.add (correspondente);
		return correspondente;
	    }
	}
	else {
            JOptionPane.showMessageDialog(p, "Botão não registrado!");
            escolha = 'n';
        }
	return null;
    }
}

