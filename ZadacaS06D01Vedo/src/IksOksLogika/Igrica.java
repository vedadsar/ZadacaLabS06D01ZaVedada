package IksOksLogika;

public class Igrica {
	
    private Tabela poljanaZaIgru;
    private int aktivniIgrac;

    public Igrica(){
    	poljanaZaIgru = new Tabela();
    	aktivniIgrac = Polje.PRVI_IGRAC;
    }
    
    public boolean provjeriDaLiJeDozvoljenPotez(int i, int j){
    if(poljanaZaIgru.provjeriPolje(i, j))
    	if (poljanaZaIgru.getPolje(i, j).vratiVrijednostPolja() == Polje.prazno_polje)
    		return true;
    return false;
    }
    /**
     * Funkcija koja ce odigrati potez. U nasu tabelu ce upisati potez, i promjeniti igraca. Takodjer provjerava da li je potez ispravan.
     * @param i
     * @param j
     * @throws Exception
     */
    public void odigrajPotez(int i, int j) throws Exception{
    	if(provjeriDaLiJeDozvoljenPotez(i, j)){
    		poljanaZaIgru.setPolje(aktivniIgrac, i, j);
    		
    		if(aktivniIgrac == Polje.PRVI_IGRAC){
    			aktivniIgrac = Polje.DRUGI_IGRAC;
    		}
    		else{
    			aktivniIgrac = Polje.PRVI_IGRAC;
    		}
    	}else{
    		throw new Exception("Potez nije dozvoljen");
    	}
    }
    
    public boolean daLiJeKrajIgre(){
    	boolean imaPraznihPolja = false;
    	
    	for(int i=0;i<3;i++){
    		for(int j=0;j<3;j++){
                imaPraznihPolja |= (poljanaZaIgru.getPolje(i, j).vratiVrijednostPolja()==Polje.prazno_polje); 
    		}
    	}
    	if(!imaPraznihPolja)
    		return true;
    	return nekoJePobjedio();
    }

	private boolean nekoJePobjedio() {
	     // Provjeravamo da li su redovi jednake, ukoliko jesu vracamo boolean true !
		for(int i=0; i<3;i++){
			for(int j=0;j<2;j++){
				if(poljanaZaIgru.getPolje(i, j) != poljanaZaIgru.getPolje(i, j+1)){
					return false;
				}
			}
		}
		// Provjeravamo da li su kolone jednake, ako jesu vracamo true
		for(int i=0; i<2;i++){
			for(int j=0;j<3;j++){
				if(poljanaZaIgru.getPolje(i, j) != poljanaZaIgru.getPolje(i+1, j)){
					return false;
				}
			}
		}
		
		//Provjeravamo prvu diagonalu
		if(poljanaZaIgru.getPolje(0, 0) != poljanaZaIgru.getPolje(1, 1) &&
		   poljanaZaIgru.getPolje(0, 0) != poljanaZaIgru.getPolje(2, 2))
			return false;
		//provjeravamo drugu diagonalu
		if(poljanaZaIgru.getPolje(0, 2) != poljanaZaIgru.getPolje(1, 1) &&
		   poljanaZaIgru.getPolje(0, 2) != poljanaZaIgru.getPolje(2,0))
			return false;
		
		
		return true;
	}
}
