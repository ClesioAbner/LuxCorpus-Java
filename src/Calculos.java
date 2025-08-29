import java.util.*;
public class Calculos 
{
  public Calculos() {}
  
  // calculoDesconto
  public float calcularValorTotalDesconto()
  {
	  Gold gd = new Gold();
	  Silver sl = new Silver();
	  float desconto=0;
	  desconto += gd.getCalcularDesconto()+sl.getCalcularDesconto();
	  return desconto;
  }
  
  // calculo Final
   public float calcularValotTotal(Vector vecUm)
	{
		 Socio sc;
		  Gold gd = new Gold();
		  Silver sl=new Silver();
		  Premium pr=new Premium();
		  Standard st=new Standard();
		  float vt=0;
		  
		  for(int i=0;i<vecUm.size();i++)
		  {
			  sc=(Socio) vecUm.elementAt(i);
			  if(sc instanceof Gold)
			  {
				  gd=(Gold) vecUm.elementAt(i);
				  vt+=gd.getValorFinal();
			  }
			  else if(sc instanceof Silver)
			  {
				  sl=(Silver) vecUm.elementAt(i);  
				  vt+=sl.getValorFinal();
			  }
			  else if(sc instanceof Premium)
			  {
				  pr=(Premium) vecUm.elementAt(i);  
				  vt+=pr.getValorFinal();
			  }
			  else if(sc instanceof Standard)
			  {
				  st=(Standard) vecUm.elementAt(i);  
				  vt+=st.getValorFinal();
			  }
		  }
		  return vt;
	}
   
    // Achar Antigo
    public int acharIndiceSocioAntigo(Vector vecUm)
    {
  	  int indice=0, ano=2023,anoo=0;
  	  Socio sc;
  	  
  	  for(int i=0; i<vecUm.size(); i++)
  	  {
  		  sc = (Socio)vecUm.elementAt(i);
  		  anoo = Integer.parseInt(sc.getDataInscricao().substring(6,10));
  		  
  		  if(anoo<ano)
  		  {
  			  ano=anoo;
  			  indice=i;
  		  }
  	  }
  	  return indice;
    }
}