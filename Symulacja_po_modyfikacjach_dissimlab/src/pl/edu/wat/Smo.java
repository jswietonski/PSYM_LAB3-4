package pl.edu.wat; /**
 * @author Dariusz Pierzchala
 * 
 * Description: Description: Klasa gniazda obsługi obiektów - zgłoszeń 
 */

import java.util.LinkedList;

import dissimlab.broker.INotificationEvent;
import dissimlab.broker.IPublisher;
import dissimlab.monitors.MonitoredVar;
import dissimlab.simcore.BasicSimObj;
import dissimlab.simcore.SimControlException;



public class Smo extends BasicSimObj
{
    private final LinkedList <Klient> kolejka;
    private final LinkedList <Klient> kolejka2;
	private boolean wolne = true;
    private boolean wolne2 = true;


    public MonitoredVar MVczasy_obslugi;
    public MonitoredVar MVczasy_oczekiwania;
    public MonitoredVar MVdlKolejki;
    public MonitoredVar MVutraconeZgl;

    public MonitoredVar MVczasy_obslugi2;
    public MonitoredVar MVczasy_oczekiwania2;
    public MonitoredVar MVdlKolejki2;
    public MonitoredVar MVutraconeZgl2;
	
    public Smo() throws SimControlException
    {
        // Utworzenie wewnętrznej listy w kolejce
        kolejka = new LinkedList<>();
        kolejka2 = new LinkedList<>();
        // Deklaracja zmiennych monitorowanych
        MVczasy_obslugi = new MonitoredVar();
        MVczasy_oczekiwania = new MonitoredVar();
        MVdlKolejki = new MonitoredVar();
        MVutraconeZgl = new MonitoredVar();

        MVczasy_obslugi2 = new MonitoredVar();
        MVczasy_oczekiwania2 = new MonitoredVar();
        MVdlKolejki2 = new MonitoredVar();
        MVutraconeZgl2 = new MonitoredVar();
    }

    // Wstawienie zgłoszenia do kolejki
    public int dodaj(Klient zgl)
    {
        kolejka.add(zgl);
        MVdlKolejki.setValue(kolejka.size());
        return kolejka.size();
    }
    public int dodaj2(Klient zgl)
    {
        kolejka2.add(zgl);
        MVdlKolejki2.setValue(kolejka2.size());
        return kolejka2.size();
    }

    // Pobranie zgłoszenia z kolejki
    public Klient usun()
    {
    	Klient zgl = (Klient) kolejka.removeFirst();
        MVdlKolejki.setValue(kolejka.size());
        return zgl;
    }
    public Klient usun2()
    {
        Klient zgl = (Klient) kolejka2.removeFirst();
        MVdlKolejki2.setValue(kolejka2.size());
        return zgl;
    }

    // Pobranie zgłoszenia z kolejki
    public boolean usunWskazany(Klient zgl)
    {
    	Boolean b= kolejka.remove(zgl);
        MVdlKolejki.setValue(kolejka.size());
        return b;
    }
    
    public int liczbaZgl()
    {
        return kolejka.size();
    }

    public int liczbaZgl2()
    {
        return kolejka2.size();
    }

	public boolean isWolne() {
		return wolne;
	}
    public boolean isWolne2() {
        return wolne2;
    }

	public void setWolne(boolean wolne) {
		this.wolne = wolne;
	}
    public void setWolne2(boolean wolne2) {
        this.wolne = wolne2;
    }

	@Override
	public void reflect(IPublisher publisher, INotificationEvent event) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean filter(IPublisher publisher, INotificationEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
}