package test;

//LoadTermb.java

import java.io.IOException;

import com.sun.jna.Native;

public class LoadTermb
{
	public static void main (String [] args)
	{
		Termb lib = (Termb) Native.loadLibrary ("termb", Termb.class);
		Termb.IdCardTxtInfo info = new Termb.IdCardTxtInfo();
		
		lib.SetJpgPath("c:\\1.jpg");
		if (lib.InitComm(1001) != 1){
			System.out.println ("InitComm error!");					
		}
		lib.Authenticate();
		if (lib.Read_Content(1) != 1){
			System.out.println ("Read_Content error!");	
		}
		lib.GetIdCardTxtInfo(info);
		System.out.print ("Name is ");
		try{
			System.out.println(new String(info.name, "gb2312"));   
		}catch(IOException e){   
			e.printStackTrace();   
		}   
	}
}
