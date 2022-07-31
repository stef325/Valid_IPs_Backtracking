package src;

import java.util.ArrayList;
import java.util.List;

public class BackTrackingVersion2 {

	public static void main(String[] args) {
		BackTrackingVersion2 bt = new BackTrackingVersion2();
		System.out.print(bt.restoreIpAddresses("25525511135"));
	}
	
	//driver, recuperar ips
	public List<String> restoreIpAddresses(String s){
			List<String> allIpAddresses = new ArrayList<>();
			int[] path = new int[4];
			snapshotIp(allIpAddresses, s, 0, path, 0);
			return allIpAddresses;

	}
	

	public void snapshotIp(List<String> allIpAddresses, String s,
			int builderIndex, int[] path, int segment) {
		
		//casos bases, pega as respostas e guarda o resultado
		if(segment == 4 && builderIndex == s.length()) {
			allIpAddresses.add(path[0]+"."+path[1]+"."+path[2]+"."+path[3]);
			return;
		}else if(segment == 4 || builderIndex == s.length()) {
			return;
		}
		
		for(int len = 1; len <=3 && builderIndex + len <= s.length(); len++) {
			
			String snapshot = s.substring(builderIndex, builderIndex+len);
			int value = Integer.parseInt(snapshot);
			
			//restri��es
			if(value> 255 || len>= 2 && s.charAt(builderIndex) == '0') {
				break;
			}
			
			//escolha para bracktracking separado em
			path[segment] = value;// escolha
			snapshotIp(allIpAddresses, s, builderIndex+len, path, segment+1);//explora
			path[segment]= -1;//n�o escolhido
		} }

}
