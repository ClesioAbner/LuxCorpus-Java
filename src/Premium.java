public final class Premium extends Normal
{
  private String nomePersonal;
  public static int socioPremium;
  
  public Premium(String nomeSocio, String dataInscricao, String sexoSocio, String objectivoSocio, int codigoSocio, int idadeSocio, int pesoSocio, byte quantiMensal, String nomePersonal)
  {
	  super(nomeSocio, dataInscricao, sexoSocio, objectivoSocio, codigoSocio, idadeSocio, pesoSocio,quantiMensal);
	  this.nomePersonal=nomePersonal;
	  socioPremium++;
  }
  
  public Premium() {this("","","","",0,0,0,(byte)0,"");}
  public String getNomePersonal() {return nomePersonal;}
  public void setNomePersonal(String nomePersonal) {this.nomePersonal = nomePersonal;}
  public float getValorFinal()
  {
	  float valorFinal = 7000+500;
	  return valorFinal;
  }
  public String toString() {return super.toString()+"\nPremium [Nome do Personal Trainer: "+nomePersonal+"]";}
}
