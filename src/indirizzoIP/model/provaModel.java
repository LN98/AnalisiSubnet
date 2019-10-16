package indirizzoIP.model;

public class provaModel {

	public static void main(String[] args) {
		IndirizzoIP i=new IndirizzoIP ();
		i.setIndirizzoIP(64,0,0,255,9);
		
		for(int a:i.iBinario()) {
			System.out.print(a);
		}
		//i.iRete();
		System.out.println(" ");
		for(int a:i.iRete()) {
			System.out.print(a);
		}
		
		System.out.println(" ");
		for(int a:i.iSubnetMask()) {
			System.out.print(a);
		}
		
		System.out.println(" ");
		System.out.println(i.nHost());
		System.out.println(i.nSubnet());

		for(int a:i.iGateway()) {
			System.out.print(a);
		}
	}

}
