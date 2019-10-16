package indirizzoIP.model;

public class IndirizzoIP {
	
	private int[] iDecimale;
	private int cidr; 
	private ErrClass err=new ErrClass();
	
	public void setIndirizzoIP(int a,int b,int c,int d,int cidr) {
		int[] indi= {a,b,c,d};
		this.iDecimale=indi;
		this.cidr=cidr;
		for(int l:iDecimale) {
			System.out.println(l);
		}
		
	}
	
	public int[] iBinario() {
		int[] b=new int[32];
		int[] s= {128,64,32,16,8,4,2,1};
		int n,i;
		i=0;
		while(i<b.length){
			for(int k=0; k<iDecimale.length;k++) {
				n=iDecimale[k];
				for(int c=0;c<s.length;c++) {
					if(n>=s[c]) {
						b[i]=1;
						n=n-s[c];
						i++;
					}
					else{
						b[i]=0;
						i++;
					}
				
				}
				
			}
		}
		return b;
	}
	
	public int[] conversioneD(int[] b) {
		int a=0;
		int[] s= {128,64,32,16,8,4,2,1};
		int[] d=new int[4];
		while(a<b.length) {
			for(int i=0;i<d.length;i++) {
				d[i]=0;
			
			
				for(int j=0;j<s.length;j++) {
					d[i]+=s[j]*b[a];
					//System.out.println(i+" "+j+" "+a+"\n");
					a++;
					if(a>=b.length)break;
				}
				
			}
		}
		return d;
		
	}

	public int[] iRete() {
		int[] bRete = new int[32];
		for(int i=0;i<bRete.length;i++) {
			if(i<cidr)
				bRete[i]=iBinario()[i];
			else
				bRete[i]=0;
		}
		
		
		return conversioneD(bRete);
	}

	public char classe() {
		
		if(iDecimale[0]>=128&&iDecimale[0]<192) return 'B';
		else if(iDecimale[0]>=192&&iDecimale[0]<224) return 'C';
		else if(iDecimale[0]>=224&&iDecimale[0]<240) return 'D';
		else if(iDecimale[0]>=240&&iDecimale[0]<256) return 'A';
		else  return 'A';
	}

	
	public int[] iSubnetMask() {
		int[] bSubnetMask=new int[32];
		for(int i=0;i<bSubnetMask.length;i++) {
			if(i<cidr)
				bSubnetMask[i]=1;
			else
				bSubnetMask[i]=0;
		}
		
		return conversioneD(bSubnetMask);
	}

	
	public int nHost() {
		return(int)(Math.pow(2,(32-cidr))-2);
	}
	
	public int nSubnet() {
		int a;
		if (classe()=='A') a=8;
		else if (classe()=='B') a=16;
		else if (classe()=='C') a=24;
		else a=32;
		
		if(cidr-a==0) return 0;
		else return (int)Math.pow(2, (cidr-a));
	}

	public int[] iBroadcast() {
		int[] bBroadcast=new int[32];
		for(int i=0;i<bBroadcast.length;i++) {
			if(i<cidr)
				bBroadcast[i]=1;
			else
				bBroadcast[i]=1;
		}
		return conversioneD(bBroadcast);
	}
	
	public int[] iGateway() {
		int[] gate= iRete();
		gate[gate.length-1]+=1;
		return gate;
		
		
	}
	
	public String sDecimale(int[] d) {
		String s="";
		for(int i=0;i<d.length;i++) {
			if(i!=3)
				s+=(d[i]+".");
			else
				s+=d[i];
		}
		
		return s;
	}

	public String toString() {
		
		err.clear();
		if(cidr>32) err.addMsg("CIDR deve essere minore di 32");
		if(classe()=='A'&&cidr<8) err.addMsg("gli indirizzi della classe A ha CIDR maggiore o uguale al 8\n");
		else if(classe()=='B'&&cidr<16) err.addMsg("gli indirizzi della classe B ha CIDR maggiore o uguale al 16\n");
		else if(classe()=='C'&&cidr<24) err.addMsg("gli indirizzi della classe C ha CIDR maggiore o uguale al 24\n");
		else if(classe()=='D'&&cidr<32) err.addMsg("gli indirizzi della classe D ha CIDR maggiore o uguale al 32\n");
		
		for(int i=0;i<iDecimale.length;i++) {
			if(iDecimale[i]<0||iDecimale[i]>255)
				err.addMsg("ogni byte dell'indirizzo IP deve essere compreso tra 0 e 255");
		}
		
		
		if (!err.isErr()) {
			String c = "CLASSE: " + classe();

			String b = "Indirizzo IP binario: ";
			for (int i = 0; i < iBinario().length; i++) {
				if (i % 8 == 0 && i != 0)
					b += (iBinario()[i] + ".");
				else
					b += iBinario()[i];
			}

			String r = "Indirizzo di rete: ";
			r += sDecimale(iRete());

			String sm = "SubnetMask: ";
			sm += sDecimale(iSubnetMask());

			String br = "\n";

			String g = "Default gateway: ";
			g += sDecimale(iGateway());

			String bro = "Broadcast: ";
			bro += sDecimale(iBroadcast());

			String nH = "Num. Host: " + nHost();

			String nS = "Num. Sottorete: " + nSubnet();

			return c + br + b + br + r + br + sm + br + g + br + bro + br + nH + br + nS;
		}
		else {
			String s="";
			for(int i=0;i<err.getMsg().size();i++) {
				s+=(err.getMsg().get(i)+"\n");
			}
			return s;
		}
		
	}

//	public String errori() {
//		String err="";
//		
//		if(classe()=='A'&&cidr<8) err+="gli indirizzi della classe A ha CIDR maggiore o uguale al 8\n";
//		if(classe()=='A'&&cidr<8) err+="gli indirizzi della classe B ha CIDR maggiore o uguale al 8\n";
//		if(classe()=='A'&&cidr<8) err+="gli indirizzi della classe C ha CIDR maggiore o uguale al 8\n";
//		if(classe()=='A'&&cidr<8) err+="gli indirizzi della classe D ha CIDR maggiore o uguale al 8\n";
//	}
	
	
	
}
