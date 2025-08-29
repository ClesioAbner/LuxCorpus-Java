

public class Usuario 
{
    private String nome, email, senha, chave;
    
    private Usuario(String nome, String email, String senha, String chave)
    {
    	this.nome=nome;
    	this.email=email;
    	this.senha=senha;
    	this.chave=chave;
    }
    
    public Usuario() {this("","","","");}

	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getSenha() {return senha;}
	public void setSenha(String senha) {this.senha = senha;}
	public String getChave() {return chave;}
	public void setChave(String chave) {this.chave = chave;}
}
