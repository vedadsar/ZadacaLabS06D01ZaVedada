package IksOksLogika;

public class Polje {
    public static final int PRVI_IGRAC = -1;
    public static final int DRUGI_IGRAC = 1;
    public static final int PRAZNO_POLJE = 0;
	
    private int vrijednost;
    
    public static char  prvi_igrac = 'X';
    public static char drugi_igrac = 'O';
    public static char prazno_polje = ' ';
    
    //Ovo nam je za GUI kada budemo iscrtavali stanje tabele
    public static String prvi;
    public static String drugi;
    public static String prazno;
    /**
     * Konstruktor za default vrijednosti
     */
    public Polje(){
    	vrijednost = PRAZNO_POLJE;
    }
    
    /**
     * This is setter for polje.
     * @param vrijednost
     * @throws Exception
     */
    public void postaviPolje(int vrijednost) throws Exception{
    	 if(this.vrijednost==PRAZNO_POLJE){
    		 if(vrijednost != PRVI_IGRAC  ||  vrijednost != DRUGI_IGRAC){
    			 throw new IllegalArgumentException("Niste unijeli ispravan znak");
    		 }
    		 this.vrijednost=vrijednost;
    	 }else{
    		 throw new Exception("Polje nije prazno");
    	 }
    }
    /**
     * Funkcija vraca char u  zavisnosti od vrijednosti.
     * @return
     */
    public  char vratiVrijednostPolja(){
    	if(vrijednost == PRAZNO_POLJE)
    		return prazno_polje;
    	if(vrijednost == PRVI_IGRAC)
    		return prvi_igrac;
    	return drugi_igrac;
    }

      public static void postaviZnakove(char prvi, char drugi, char prazno){
    	  prvi_igrac = prvi;
    	  drugi_igrac=drugi;
    	  prazno_polje=prazno;
      }
}
