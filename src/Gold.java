public final class Gold extends Socio implements CalcularDesconto
{
  private String nutriParticular; 
  private int numQuarto;
  public static int socioGold;
  public static float valGold;
  
  public Gold(String nomeSocio, String dataInscricao, String sexoSocio, String objectivoSocio, int codigoSocio, int idadeSocio, int pesoSocio, String nutriParticular, int numQuarto)
  {
	  super(nomeSocio, dataInscricao, sexoSocio, objectivoSocio, codigoSocio, idadeSocio, pesoSocio);
	  this.nutriParticular=nutriParticular;
	  this.numQuarto=numQuarto;
	  socioGold++;
  }
  
  public Gold() {this("","","","",0,0,0,"",0);}

  public String getNutriParticular() {return nutriParticular;}
  public int getNumQuarto() {return numQuarto;}
  public void setNutriParticular(String nutriParticular) {this.nutriParticular = nutriParticular;}
  public void setNumQuarto(int numQuarto) {this.numQuarto = numQuarto;}
  
  public float valorNutri()
  {
	  if(nutriParticular.equalsIgnoreCase("sim"))
		  return 2000;
	  return 0;
  }
  public float getValorFinal()
  {
	  Gold gd = new Gold();
	  float valorFinal = 15000+valorNutri();
	  
	  valorFinal-=getCalcularDesconto();
	  valGold+=valorFinal;
	  return valorFinal;
	  
  }
  public float getCalcularDesconto()
  {
	  float desconto =(15000+valorNutri()*DESCONTO_GOLD);
	  return desconto;
  }
  public String toString() {return super.toString()+"\nGold [Nutricionista Particular: "+nutriParticular+", Numero do Quarto: "+numQuarto+"]";}
}
