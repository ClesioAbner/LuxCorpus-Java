public class Reserva 
{
  private String codigoReserva, horaEntrada, data, codigoDoSocio, nomeDoSocio, tipoPacote;
  
  public Reserva(String codigoReserva, String horaEntrada, String data, String codigoDoSocio, String nomeDoSocio, String tipoPacote)
  {
	  this.codigoReserva=codigoReserva;
	  this.horaEntrada=horaEntrada;
	  this.data=data;
	  this.codigoDoSocio=codigoDoSocio;
	  this.nomeDoSocio=nomeDoSocio;
	  this.tipoPacote=tipoPacote;
  }
  
  public Reserva() {this("","","","","","");}

  public String getCodigoReserva() {return codigoReserva;}
  public String getHoraEntrada() {return horaEntrada;}
  public String getData() {return data;}
  public String getCodigoSocio() {return codigoDoSocio;}
  public String getNomeSocio() {return nomeDoSocio;}
  public String getTipoPacote() {return tipoPacote;}
  public void setCodigoReserva(String codigoReserva) {this.codigoReserva = codigoReserva;}
  public void setHoraEntrada(String horaEntrada) {this.horaEntrada = horaEntrada;}
  public void setData(String data) {this.data = data;}
  public void setCodigoSocio(String codigoDoSocio) {this.codigoDoSocio = codigoDoSocio;}
  public void setNomeSocio(String nomeDoSocio) {this.nomeDoSocio = nomeDoSocio;}
  public void setTipoPacote(String tipoPacote) {this.tipoPacote = tipoPacote;}
  public String toString() {return "Reserva [Codigo Reserva: "+codigoReserva+", Hora de Entrada: "+horaEntrada+", Data: "+data
			+ ", Codigo do Socio: "+codigoDoSocio+", Nome do Socio: "+nomeDoSocio+", Tipo de Pacote: "+tipoPacote+"]";}
}
