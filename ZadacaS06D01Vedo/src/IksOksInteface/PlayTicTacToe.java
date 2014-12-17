package IksOksInteface;

import IksOksLogika.*;

public class PlayTicTacToe {
	
	public static void main(String[] args) throws Exception {
        
		Igrica novaIgra = new Igrica();
		
		while (novaIgra.daLiJeKrajIgre() == false){
			System.out.println("Unesite Koordinate vaseg poteza");
			int i = TextIO.getInt();
			int j = TextIO.getInt();
			
			novaIgra.odigrajPotez(i, j);
			
			novaIgra.daLiJeKrajIgre();
			
			
		}
				
	}
}
