import java.util.Vector;
public class Pesquisa {

public Pesquisa() {}
	
	public int pesquisarCodigo(Vector vecUm,int codigoSocio)
	{
		int indice=-1;
		boolean encontrou=false;
		Socio s;
		
		for(int i=0;i<vecUm.size()&& encontrou==false;i++)
		{
			s=(Socio) vecUm.elementAt(i);
			if(s.getCodigoSocio()==codigoSocio)
			{
				encontrou=true;
				indice=i;
			}	
		}
		return indice;
	}
}
