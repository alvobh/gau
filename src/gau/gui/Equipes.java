
package GUI;


import java.util.TreeSet;

class Equipe implements Comparable
{
    private String nome;

    public Equipe (String nome)
    {
	this.nome = nome;
    }

    public int compareTo (Object obj)
    {
	return this.nome.compareTo (((Equipe) obj).nome);
    }

    public String toString ()
    {
	return nome;
    }
}

class EquipeEfetiva
{
    private TreeSet<Equipe> equipes;

    public EquipeEfetiva (Equipe e)
    {
	equipes = new TreeSet<Equipe> ();
	equipes.add (e);
    }

    public boolean add (Equipe e)
    {
	return equipes.add (e);
    }

    public boolean contains (Equipe e)
    {
	return equipes.contains (e);
    }

    public String toString ()
    {
	return equipes.toString ();
    }
}
