import java.io.*;
public class Validacoes {

	private BufferedReader br;
	public Validacoes() 
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}
	
	// Inicia se a validacoes
	public byte validarOpcao(byte a, byte b) 
	{
		byte c = 0;	
		do 
		{	
			try 
			{
				c = Byte.parseByte(br.readLine());
			}
			catch(NumberFormatException ne) {System.out.println(ne.getMessage());}
			catch(IOException io) {System.out.println(io.getMessage());}
			
			if(c < a || c > b)
				System.out.println("Valor invalido");
		}while(c < a || c > b);
		return c;
	}
	
	public String validarString(String msg)
	{
		String b = null;
		do
		{
			try
			{
				b=msg;
			}
			catch(NumberFormatException d)
			{
				System.out.println(d.getMessage());
			}
			if(b.length()==0)
				System.out.println("Invalido!!!");
		}while(b.length()==0);
		
		return b;
	}
	
	public int validarInt(int a, int b,String msg)
	{
		int c=0;
		do
		{
			System.out.println(msg);
			try
			{
				c=Integer.parseInt(br.readLine());
			}
			catch(NumberFormatException e)
			{
				System.out.println(e.getMessage());
			}
			catch(IOException z)
			{
				System.out.println(z.getMessage());
			}
			if(c< a||c>b)
				System.out.println("Invalido!!");
		}while(c< a||c>b);
		return c;
	}
}
