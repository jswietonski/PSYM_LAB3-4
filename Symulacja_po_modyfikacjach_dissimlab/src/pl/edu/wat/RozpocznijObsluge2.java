package pl.edu.wat; /**
 * @author Dariusz Pierzchala
 * 
 * Description: Zdarzenie początkowe aktywności gniazda obsługi. Rozpoczyna obsługę przez losowy czas obiektów - zgłoszeń.
 */

import dissimlab.random.RNGenerator;
import dissimlab.simcore.BasicSimEvent;
import dissimlab.simcore.SimControlException;

public class RozpocznijObsluge2 extends BasicSimEvent<Smo, Klient>
{
    private final RNGenerator generator;

    public RozpocznijObsluge2(Smo parent) throws SimControlException
    {
    	super(parent);
    	generator = new RNGenerator();
    }

	@Override
	protected void stateChange() throws SimControlException {
    	Smo smoParent = getSimObj();

        if (smoParent.liczbaZgl2() > 0)
        {
        	// Zablokuj gniazdo
        	smoParent.setWolne2(false);
        	// Pobierz klienta
			//####################################################
        	Klient zgl = smoParent.usun2();
        	//####################################################
        	// Wygeneruj czas obsługi
            double czasObslugi;
            do {
            	czasObslugi = generator.normal(6.0, 1.0);
            } while (czasObslugi<=0.0);
        	
            // Zapamiętaj dane monitorowane
        	smoParent.MVczasy_obslugi2.setValue(czasObslugi);
            smoParent.MVczasy_oczekiwania2.setValue(simTime() - zgl.getCzasPrzybycia());
            System.out.println(simTimeFormatted()+":                       NR2 Początek obsługi  zgl. nr: " + zgl.getId());
        	// Zaplanuj koniec obsługi
        	new ZakonczObsluge2(smoParent, czasObslugi, zgl);
        }
		
	}



	@Override
	protected void onTermination() throws SimControlException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Klient getEventParams() {
		// TODO Auto-generated method stub
		return null;
	}
}