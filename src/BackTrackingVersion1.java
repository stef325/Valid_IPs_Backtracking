package src;

import java.util.ArrayList;
public class BackTrackingVersion1 {


	// inicio da fun��o de endere�os IP v�lidos
	static void GetAllValidIpAddress(ArrayList<String>result,
									String givenString,int index,
									int count, String ipAddress){

		// Caso base para checar o tamanho da string e contador 
		if (givenString.length() == index && count == 4){

			// remover o ultimo ponto
			ipAddress = ipAddress.substring(0,ipAddress.length()-1);
	
			// adicionar o endere�o ip ao result
			result.add(ipAddress);
			return;
		}

		// Para adicionar um �ndice ao endere�o IP
		if (givenString.length() < index + 1)
			return;

		// Sele��o do digito e chamada da fun��o novamente,
		//mas agora para outros blocos
		ipAddress = (ipAddress + givenString.substring(index , index + 1) + '.');

		GetAllValidIpAddress(result, givenString, index + 1, count + 1, ipAddress);

		//Backtrack para gerar outro endere�o IP poss�vel 
		// agora removemos dois �ndices (um para o d�gito 
		// e outro para o ponto) do final
		ipAddress = ipAddress.substring(0,ipAddress.length() - 2);

		// Sele��o de dois digitos dessa vez 
		//e chamada da fun��o novamente, para outros blocos
		if (givenString.length() < index + 2 ||givenString.charAt(index) == '0')
			return;

		ipAddress = ipAddress + givenString.substring(index,index + 2) + '.';
		GetAllValidIpAddress(result, givenString, index + 2,
							count + 1, ipAddress);

		// Seleciona tr�s d�gitos consecutivos e chama 
		// a mesma fun��o para outros blocos
		ipAddress = ipAddress.substring(0,ipAddress.length() - 3);

		// Seleciona tr�s d�gitos consecutivos para verificar se � maior que 255
		// e chama a mesma fun��o para outros blocos
		if (givenString.length() < index + 3 ||
			Integer.valueOf(givenString.substring(index,index + 3)) > 255)
		return;
		ipAddress += givenString.substring(index,index + 3) + '.';
		GetAllValidIpAddress(result, givenString,
							index + 3, count + 1, ipAddress);

		// Retroceder para gerar outro endere�o IP poss�vel 
		// Ent�o removemos quatro �ndices do final
		ipAddress = ipAddress.substring(0,ipAddress.length()-4);
	}
	
	
	public static void main (String[] args) {
		String givenString = "25525511135";

		ArrayList<String>result = new ArrayList<String>() ;
		String ipAddress = "";
		GetAllValidIpAddress(result, givenString, 0, 0,ipAddress);

		for(int i = 0; i < result.size(); i++)
			System.out.println(result.get(i));
	}
	
	}

	// This code is contributed by shinjanpatra.
