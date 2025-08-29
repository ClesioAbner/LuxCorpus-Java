import java.io.Serializable;

public abstract class Socio implements Serializable
{
  protected int codigoSocio, idadeSocio, pesoSocio;
  protected String nomeSocio, dataInscricao, sexoSocio, objectivoSocio;
  
  public Socio (String nomeSocio, String dataInscricao, String sexoSocio, String objectivoSocio, int codigoSocio, int idadeSocio, int pesoSocio)
  {
	  this.nomeSocio=nomeSocio;
	  this.dataInscricao=dataInscricao;
	  this.sexoSocio=sexoSocio;
	  this.objectivoSocio=objectivoSocio;
	  this.codigoSocio=codigoSocio;
	  this.idadeSocio=idadeSocio;
	  this.pesoSocio=pesoSocio;
  }
  
  public Socio() {this("","","","",0,0,0);}

  public int getCodigoSocio() {return codigoSocio;}
  public int getIdadeSocio() {return idadeSocio;}
  public int getPesoSocio() {return pesoSocio;}
  public String getNomeSocio() {return nomeSocio;}
  public String getDataInscricao() {return dataInscricao;}
  public String getSexoSocio() {return sexoSocio;}
  public String getObjectivoSocio() {return objectivoSocio;}
  public void setCodigoSocio(int codigoSocio) {this.codigoSocio = codigoSocio;}
  public void setIdadeSocio(int idadeSocio) {this.idadeSocio = idadeSocio;}
  public void setPesoSocio(int pesoSocio) {this.pesoSocio = pesoSocio;}
  public void setNomeSocio(String nomeSocio) {this.nomeSocio = nomeSocio;}
  public void setDataInscricao(String dataInscricao) {this.dataInscricao = dataInscricao;}
  public void setSexoSocio(String sexoSocio) {this.sexoSocio = sexoSocio;}
  public void setObjectivoSocio(String objectivoSocio) {this.objectivoSocio = objectivoSocio;}
  public abstract float getValorFinal();
  public String toString() {return "Socio [Codigo do Socio: "+codigoSocio+", Idade do Socio: "+idadeSocio+", Peso do Socio: "+pesoSocio
			+ ", nomeSocio=" + nomeSocio + ", dataInscricao=" + dataInscricao + ", sexoSocio=" + sexoSocio
			+", Objectivo do Socio: "+objectivoSocio+"]";}
}
