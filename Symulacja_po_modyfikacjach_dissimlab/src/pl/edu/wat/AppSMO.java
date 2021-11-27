package pl.edu.wat; /**
 * @author Dariusz Pierzchala
 * 
 * Description: Klasa główna. Tworzy dwa SMO, inicjalizuje je.Startuje symulację. Wyświetla statystyki.
 * 
 * Wersja testowa.
 */

import java.math.BigDecimal;

import dissimlab.monitors.Diagram;
import dissimlab.monitors.Diagram.DiagramType;
import dissimlab.monitors.Statistics;
import dissimlab.simcore.SimControlException;
import dissimlab.simcore.SimManager;

public class AppSMO {
	public static void main(String[] args) {
		try {
			SimManager simManager = SimManager.initInstance();
			// Powołanie Systemu Masowej Obslugi
			Smo smo = new Smo();
			// Utworzenie otoczenia sklepu
			new OtoczenieSklepu(smo, 5.0, 1.5);

			// Dwa sposoby zaplanowanego końca symulacji
			simManager.setEndSimTime(100);
			// lub
			//SimControlEvent stopEvent = new SimControlEvent(1000.0, SimControlStatus.STOPSIMULATION);

			// Uruchomienie symulacji za pośrednictwem metody "start"
			simManager.startSimulation();

			// Wyniki 
			double wynik = BigDecimal.valueOf(Statistics
					.arithmeticMean(smo.MVczasy_oczekiwania)).setScale(2,
					BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out
					.println("Wartość średnia czasu oczekiwania na obsługę:   "
							+ wynik);
			wynik = BigDecimal.valueOf(Statistics
					.weightedMean(smo.MVczasy_oczekiwania)).setScale(2,
					BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out
					.println("Ważona wartość średnia czasu oczekiwania na obsługę:   "
							+ wynik);			
			wynik = BigDecimal.valueOf(Statistics
					.standardDeviation(smo.MVczasy_oczekiwania)).setScale(2,
					BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out
					.println("Odchylenie standardowe dla czasu obsługi:       "
							+ wynik);
			wynik = BigDecimal.valueOf(Statistics.max(smo.MVczasy_oczekiwania))
			.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out.println("Wartość maksymalna czasu oczekiwania na obsługę: "
					+ wynik);
			wynik = BigDecimal.valueOf(Statistics
					.arithmeticMean(smo.MVdlKolejki)).setScale(2,
					BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out
					.println("Wartość średnia długości kolejki:       "
							+ wynik);
			wynik = BigDecimal.valueOf(Statistics
					.weightedMean(smo.MVdlKolejki)).setScale(2,
					BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out
					.println("Ważona wartość średnia długości kolejki:       "
							+ wynik);
			wynik = BigDecimal.valueOf(Statistics
					.max(smo.MVdlKolejki)).setScale(2,
					BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out
					.println("Wartość maksymalna długości kolejki:       "
							+ wynik);


//#####################################################
			System.out
					.println("#####################################################"
							);
			System.out
					.println("Wartość średnia czasu oczekiwania na obsługę2:   "
							+ wynik);
			wynik = BigDecimal.valueOf(Statistics
					.weightedMean(smo.MVczasy_oczekiwania2)).setScale(2,
					BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out
					.println("Ważona wartość średnia czasu oczekiwania na obsługę2:   "
							+ wynik);
			wynik = BigDecimal.valueOf(Statistics
					.standardDeviation(smo.MVczasy_oczekiwania2)).setScale(2,
					BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out
					.println("Odchylenie standardowe dla czasu obsługi2:       "
							+ wynik);
			wynik = BigDecimal.valueOf(Statistics.max(smo.MVczasy_oczekiwania2))
					.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out.println("Wartość maksymalna czasu oczekiwania na obsługę2: "
					+ wynik);
			wynik = BigDecimal.valueOf(Statistics
					.arithmeticMean(smo.MVdlKolejki2)).setScale(2,
					BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out
					.println("Wartość średnia długości kolejki2:       "
							+ wynik);
			wynik = BigDecimal.valueOf(Statistics
					.weightedMean(smo.MVdlKolejki2)).setScale(2,
					BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out
					.println("Ważona wartość średnia długości kolejki2:       "
							+ wynik);
			wynik = BigDecimal.valueOf(Statistics
					.max(smo.MVdlKolejki2)).setScale(2,
					BigDecimal.ROUND_HALF_UP).doubleValue();
			System.out
					.println("Wartość maksymalna długości kolejki2:       "
							+ wynik);

			System.out
					.println("xxxxxxxxxxxxxx       "
							+Statistics.numberOfSamples(smo.MVczasy_obslugi2) );

//#####################################################

			Diagram d1 = new Diagram(DiagramType.DISTRIBUTION, "Czas obsługiwania");
			d1.add(smo.MVczasy_obslugi, java.awt.Color.GREEN);
			d1.show();

			Diagram d2 = new Diagram(DiagramType.HISTOGRAM,
					"Dlugość kolejki - HISTOGRAM");
			d2.add(smo.MVdlKolejki, java.awt.Color.BLUE);
			d2.show();

			Diagram d3 = new Diagram(DiagramType.HISTOGRAM,
					"Czasy oczekiwania na obsługę");
			d3.add(smo.MVczasy_oczekiwania, java.awt.Color.BLUE);
			d3.show();

			Diagram d4 = new Diagram(DiagramType.TIME,
					"Długość kolejki w czasie");
			d4.add(smo.MVdlKolejki, java.awt.Color.RED);
			d4.show();

//############################################################################
			Diagram d5 = new Diagram(DiagramType.DISTRIBUTION, "Czas obsługiwania2");
			d5.add(smo.MVczasy_obslugi2, java.awt.Color.GREEN);
			d5.show();

			Diagram d6 = new Diagram(DiagramType.HISTOGRAM,
					"Dlugość kolejki - HISTOGRAM2");
			d6.add(smo.MVdlKolejki2, java.awt.Color.BLUE);
			d6.show();

			Diagram d7 = new Diagram(DiagramType.HISTOGRAM,
					"Czasy oczekiwania na obsługę2");
			d7.add(smo.MVczasy_oczekiwania2, java.awt.Color.BLUE);
			d7.show();

			Diagram d8 = new Diagram(DiagramType.TIME,
					"Długość kolejki w czasie2");
			d8.add(smo.MVdlKolejki2, java.awt.Color.RED);
			d8.show();


			
		} catch (SimControlException e) {
			e.printStackTrace();
		}

	}
}
