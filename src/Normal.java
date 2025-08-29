public abstract class Normal extends Socio
{
  protected byte quantiMensal;
  
  public Normal(String nomeSocio, String dataInscricao, String sexoSocio, String objectivoSocio, int codigoSocio, int idadeSocio, int pesoSocio, byte quantiMensal)
  {
	  super(nomeSocio, dataInscricao, sexoSocio, objectivoSocio, codigoSocio, idadeSocio, pesoSocio);
	  this.quantiMensal=quantiMensal;
  }
  
  public Normal() {this("","","","",0,0,0,(byte)0);}

  public byte getQuantiMensal() {return quantiMensal;}
  public void setQuantiMensal(byte quantiMensal) {this.quantiMensal = quantiMensal;}
  public abstract float getValorFinal();
  public String toString() {return super.toString()+"\nNormal [quantiMensal=" + quantiMensal + "]";} 
}
