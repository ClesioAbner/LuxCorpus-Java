public final class Standard extends Normal
{
  private int horario;
  public static int socioStandard;
  
  public Standard(String nomeSocio, String dataInscricao, String sexoSocio, String objectivoSocio, int codigoSocio, int idadeSocio, int pesoSocio, byte quantiMensal, int horario)
  {
	  super(nomeSocio, dataInscricao, sexoSocio, objectivoSocio, codigoSocio, idadeSocio, pesoSocio,quantiMensal);
	  this.horario=horario;
  }
  
  public Standard() {this("","","","",0,0,0,(byte)0,0);}

  public int getHorario() {return horario;}
  public void setHorario(int horario) {this.horario = horario;}
  public float getValorFinal()
  {
	  float valorFinal = (3500+150)+((3500+150)*0.05f);
	  return valorFinal;
  }
  public String toString() {return super.toString()+"\nStandard [Horario Que Ira Frequentar: "+horario+"]";}
}
