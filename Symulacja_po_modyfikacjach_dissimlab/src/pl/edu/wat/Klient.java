package pl.edu.wat;

import dissimlab.broker.INotificationEvent;
import dissimlab.broker.IPublisher;
import dissimlab.simcore.BasicSimObj;

/**
 * Description: Klasa zgloszenia obsługiwanego w gnieździe obsługi.
 * 
 * @author Dariusz Pierzchala
 */

public class Klient extends BasicSimObj {
    public static int licznikKlientow = 0;
    private final double czasPrzybycia;
    private final int id;

    public Klient(double czasPrzybycia) {
        this.czasPrzybycia = czasPrzybycia;
        this.id = licznikKlientow++;
    }

    @Override
    public void reflect(IPublisher publisher, INotificationEvent event) {
    }

    @Override
    public boolean filter(IPublisher publisher, INotificationEvent event) {
        return false;
    }

    public int getId() {
        return id;
    }

    public double getCzasPrzybycia() {
        return czasPrzybycia;
    }
}