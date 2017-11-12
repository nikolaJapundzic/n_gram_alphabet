package package_1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class N_gram_main {
	
	public static String unos;
	public static String[]niz;
	//public static int brojac;
	
	public static void main(String[] args) throws IOException {
		
		

		ArrayList <String> colum = new ArrayList <String>();
		ArrayList <String> maxColum = new ArrayList <String>();
		ArrayList <String> ultraLista = new ArrayList <String>();

		FileInputStream fstream;
		BufferedReader br;
		String strLine;
		
		boolean fileExist;
		Scanner SK = new Scanner(System.in);
		
		String fileName;
		
		int counter1 = 0;
		int counter2 = 0;
		boolean flag = true;
	
		
		do {
			fileExist = true;
			fileName = SK.next();
			
			System.out.println(new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Calendar.getInstance().getTime()));
			
			try {
				fstream = new FileInputStream(fileName);
				br = new BufferedReader(new InputStreamReader(fstream));
				
				while ((strLine = br.readLine()) != null)   {
					ultraLista.add(strLine);				
				}
				br.close();
				
			} catch(Exception e) {
				fileExist = false;
			}
		}while(!fileExist);
		
		SK.close();
		
		
		BigInteger fact = BigInteger.valueOf(1);
	    for (int i = 1; i <= ultraLista.size(); i++) {
	    	fact = fact.multiply(BigInteger.valueOf(i));
	    }
	    
	    BigInteger counterBIG = BigInteger.valueOf(0);
	    //counterBIG.add(BigInteger.valueOf(1));
	    niz = ultraLista.toArray(new String[ultraLista.size()]);
	    
	    do {
	    	BigInteger counterBIG2 = BigInteger.valueOf(0);
	    	do {
	    		for(int i = niz.length-1; i>0; i--) {
					niz = zamena(niz, i-1, i);
					counterBIG2 = counterBIG2.add(BigInteger.valueOf(1));
					//stampajKombinaciju(counterBIG2);
					//------------------OVO VRTETI--------------------------------------------------------
					
					
					counter1 = 0;
					counter2 = 0;
					do {
						flag = true;
						counter1 = 0;
						do {
							if(flag) {
								colum = new ArrayList <String>();
								colum.add(niz[counter2]);
							}
										
							if(!flag) {
								if(isOK(colum.get(colum.size()-1), niz[counter1])) {
									colum.add(niz[counter1]);
								}
							}
							flag = false;
							counter1++;
							
						}while(counter1<ultraLista.size());
						
						if(maxColum.size() < colum.size()) {
							maxColum = colum;
						}
						
						counter2++;
					}while(counter2<ultraLista.size());
					//------------------OVO VRTETI--------------------------------------------------------
				}
				niz = zamena(niz, niz.length-2, niz.length-1);
				counterBIG2 = counterBIG2.add(BigInteger.valueOf(1));
				//stampajKombinaciju(counterBIG2);
				//------------------OVO VRTETI--------------------------------------------------------
				
				
				counter1 = 0;
				counter2 = 0;
				do {
					flag = true;
					counter1 = 0;
					do {
						if(flag) {
							colum = new ArrayList <String>();
							colum.add(niz[counter2]);
						}
									
						if(!flag) {
							if(isOK(colum.get(colum.size()-1), niz[counter1])) {
								colum.add(niz[counter1]);
							}
						}
						flag = false;
						counter1++;
						
					}while(counter1<ultraLista.size());
					
					if(maxColum.size() < colum.size()) {
						maxColum = colum;
					}
					
					counter2++;
				}while(counter2<ultraLista.size());
				//------------------OVO VRTETI--------------------------------------------------------
				
				
				for(int i = 0; i <niz.length-1; i++) {
					niz = zamena(niz, i, i+1);
					counterBIG2 = counterBIG2.add(BigInteger.valueOf(1));
					//stampajKombinaciju(counterBIG2);
//------------------OVO VRTETI--------------------------------------------------------
					
					
					counter1 = 0;
					counter2 = 0;
					do {
						flag = true;
						counter1 = 0;
						do {
							if(flag) {
								colum = new ArrayList <String>();
								colum.add(niz[counter2]);
							}
										
							if(!flag) {
								if(isOK(colum.get(colum.size()-1), niz[counter1])) {
									colum.add(niz[counter1]);
								}
							}
							flag = false;
							counter1++;
							
						}while(counter1<ultraLista.size());
						
						if(maxColum.size() < colum.size()) {
							maxColum = colum;
						}
						
						counter2++;
					}while(counter2<ultraLista.size());
					//------------------OVO VRTETI--------------------------------------------------------
				}
				niz = zamena(niz, 0, 1);
				counterBIG2 = counterBIG2.add(BigInteger.valueOf(1));
				//stampajKombinaciju(counterBIG2);
				//------------------OVO VRTETI--------------------------------------------------------
				
				
				counter1 = 0;
				counter2 = 0;
				do {
					flag = true;
					counter1 = 0;
					do {
						if(flag) {
							colum = new ArrayList <String>();
							colum.add(niz[counter2]);
						}
									
						if(!flag) {
							if(isOK(colum.get(colum.size()-1), niz[counter1])) {
								colum.add(niz[counter1]);
							}
						}
						flag = false;
						counter1++;
						
					}while(counter1<ultraLista.size());
					
					if(maxColum.size() < colum.size()) {
						maxColum = colum;
					}
					
					counter2++;
				}while(counter2<ultraLista.size());
				//------------------OVO VRTETI--------------------------------------------------------
	    	}while(!counterBIG2.equals(fact));
	    	

			counterBIG = counterBIG.add(BigInteger.valueOf(1));
	    	System.out.println(counterBIG + "----------------------------------------------------------------------------------------------------------------");
	    	
	    }while(!counterBIG.equals(fact));
		
		
		
		
		
		
		System.out.println();
		System.out.println("One of the longest n-gram word chain.");
		System.out.println(Arrays.toString(maxColum.toArray()));
		System.out.println(new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Calendar.getInstance().getTime()));
		
	

	}

private static boolean isOK(String newWord, String lastWord) {
		
		boolean flag = true;
		boolean flag2 = true;

		int counter = 0;
		String[] array1 = newWord.split("");
		String[] array2 = lastWord.split("");
		
		ArrayList<String> list1 = new ArrayList<String>();
		for(int i = 0; i < array1.length; i++) {
			list1.add(array1[i]);
		}
		
		ArrayList<String> list2 = new ArrayList<String>();
		for(int i = 0; i < array2.length; i++) {
			list2.add(array2[i]);
		}
	
		if(newWord.length() == lastWord.length()-1) {
			
			while(counter != list1.size()) {
				flag2 = true;
				for(int i = 0; i < list2.size(); i++) {
					if(list1.get(counter).equals(list2.get(i))){

						list1.remove(counter);
						list2.remove(i);
						counter = 0;
						flag2 = false;

						break;
					}
					
				}
				if(flag2) {
					counter++;
				}
					
			}
			if(list1.size() > 0) {
				flag = false;
			}
		}else {
			flag = false;
		}
		return flag;
	}
public static String[] zamena(String [] niz, int leviBroj, int desniBroj){
	String[]nizPermutiran = niz;
	
	String memorija = nizPermutiran[desniBroj];
	nizPermutiran[desniBroj] = nizPermutiran[leviBroj];
	nizPermutiran[leviBroj] = memorija;
	
	return nizPermutiran;
}

public static void stampajKombinaciju(BigInteger brojac) {
	if(niz.length > 2){
		System.out.print(brojac + " ");
		for(int j = 0; j<niz.length; j++) {
			System.out.print(niz[j] + " ");
			//ovde izvrsiti
		}
		System.out.println();
	}else if(niz.length == 2) {
		System.out.println(niz[0] +" "+ niz[1]);
		System.out.println(niz[1] +" "+ niz[0]);
	}else if(niz.length == 1) {
		if(unos.equals("")) {
			System.out.println("-1");
		}else {
			System.out.println(niz[0]);
		}
	}
	
}

}

