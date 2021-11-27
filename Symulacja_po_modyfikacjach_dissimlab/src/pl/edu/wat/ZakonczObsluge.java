package pl.edu.wat; /**
 * @author Dariusz Pierzchala
 * 
 * Description: Zdarzenie końcowe aktywności gniazda obsługi. Kończy obsługę przez losowy czas obiektów - zgłoszeń.
 */

import dissimlab.simcore.BasicSimEvent;
import dissimlab.simcore.SimControlException;

public class ZakonczObsluge extends BasicSimEvent<Smo, Klient>
{
    public ZakonczObsluge(Smo parent, double delay, Klient zgl) throws SimControlException
    {
    	super(parent, delay, zgl);
    }
  
	@Override
	protected void onTermination() throws SimControlException {}

	@Override
	protected void stateChange() throws SimControlException {
    	Smo smoParent = getSimObj();

        System.out.println(simTimeFormatted()+": NR1 SMO-Koniec obsługi  zgl. nr: " + eventParams.getId());
		smoParent.setWolne(true);

		new RozpocznijObsluge2(smoParent);
		// Zaplanuj ponownie obsługę, jeśli sa zgłoszenia w kolejce
        if (smoParent.liczbaZgl() > 0)
        {
			//new RozpocznijObsluge2(smoParent);
			new RozpocznijObsluge(smoParent);

        }		
	}

	@Override
	public Klient getEventParams() {
		return null;
	}
}