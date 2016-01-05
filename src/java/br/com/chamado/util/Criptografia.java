/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamado.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Eduardo de Godoy Ferrari
 */
public final class Criptografia {
    
    private static MessageDigest md;

    static 
    {
       try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }

   }
  
    private static char[] hexCodes(byte[] texto)
    {
       char[] hexOutput = new char[texto.length * 2];
       String hexString;
       
       for(int i = 0 ; i < texto.length; i++)
       {
          hexString = "00" + Integer.toHexString(texto[i]);
	  hexString.toUpperCase().getChars(hexString.length() - 2, hexString.length(), hexOutput, i * 2);
       }
       return hexOutput;
    }
    public static String criptografar(String senha)
    {
	
	md.update(senha.getBytes());
	byte  byteData[] = md.digest();
	StringBuilder sb = new StringBuilder();
	
	for(int i = 0 ; i < byteData.length; i++)
	{
        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
	return sb.toString();
		
    }
}
