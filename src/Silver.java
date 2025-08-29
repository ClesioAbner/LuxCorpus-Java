public final class Silver extends Socio implements CalcularDesconto
{
  private String hidroginastica;
  public static int socioSilver;
  
  public Silver(String nomeSocio, String dataInscricao, String sexoSocio, String objectivoSocio, int codigoSocio, int idadeSocio, int pesoSocio, String hidroginastica)
  {
	  super(nomeSocio, dataInscricao, sexoSocio, objectivoSocio, codigoSocio, idadeSocio, pesoSocio);
	  this.hidroginastica=hidroginastica;
	  socioSilver++;
  }
  
  public Silver() {this("","","","",0,0,0,"");}

  public String getHidroginastica() {return hidroginastica;}
  public void setHidroginastica(String hidroginastica) {this.hidroginastica = hidroginastica;}
  public float getValorFinal()
  {
	  float valorFinal = 9500;
	  if(hidroginastica.equalsIgnoreCase("guiada"))
	  {
		  valorFinal+=1000;
	  }
	  float vf = valorFinal-(valorFinal*DESCONTO_SILVER);
	  return vf; 
  }
  public float getCalcularDesconto()
  {
	  Silver sl = new Silver();
	  float desconto = sl.getValorFinal()*DESCONTO_SILVER;
	  return desconto;
  }
  public String toString() {return super.toString()+"\nSilver [Tipo de Hidroginastica: "+hidroginastica+"]";}
}
