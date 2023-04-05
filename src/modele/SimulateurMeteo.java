package modele;

import modele.Ordonnanceur;
import modele.SimulateurPotager;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class SimulateurMeteo implements Runnable {
    private SimulateurPotager simPot;
    private long startTime;
    private static final double PI = Math.PI;
    
    private Thread meteoThread;

    // Constante pour la température et l'amplitude de variation pour la fluctation de temperature
    private static final double Moyenne_temp = 20.0; 
    private static final double Amplitude_temp = 15.0;

    // hydrométrie en %
    private static final double Moyenne_hydro = 50.0;
    private static final double Amplitude_hydro = 30.0;

    // ensoleillement en %
    private static final double Moyenne_ensol = 50.0;
    private static final double Amplitude_ensol = 30.0;


    public SimulateurMeteo(SimulateurPotager _simPot) {
        Ordonnanceur.getOrdonnanceur().add(this);
        simPot = _simPot;
        startTime = System.currentTimeMillis();

        meteoThread = new Thread(this);
        meteoThread.start();

    }



    private int temperature;
    private int hydrometrie;
    private int ensoleillement;

 
    public int[] getCondition(){

        return new int[] {temperature, hydrometrie, ensoleillement};

    }

    @Override
    public void run() {
        // TODO 
    
            long currentTime = System.currentTimeMillis();
            double elapsedTime = (currentTime - startTime) / 1000.0;
    
            //Calcule la temperature, hydromettrie, ensoleillement selon une fonctions sinusoïdales.
            temperature = (int) (Moyenne_temp + Amplitude_temp * Math.sin(2 * PI * elapsedTime / 86400));
            hydrometrie = (int) (Moyenne_hydro + Amplitude_hydro * Math.sin(2 * PI * elapsedTime / 43200 + PI / 3));
            ensoleillement = (int) (Moyenne_ensol + Amplitude_ensol * Math.sin(2 * PI * elapsedTime / 86400 + PI / 2));
    
            // Mettre à jour l'environnement avec les nouvelles conditions
            simPot.updateEnvironment(temperature, hydrometrie, ensoleillement);
    }
}








/* 
while (true) {
    try {
        Thread.sleep(1000); // pause pour une seconde

        long currentTime = System.currentTimeMillis();
        double elapsedTime = (currentTime - startTime) / 1000.0;

        // Calculé la température, l'hydrométrie,ensolleiment based on sine wave functions
        temperature = (int) (Moyenne_temp + Amplitude_temp * Math.sin(2 * PI * elapsedTime / 86400));
        hydrometrie = (int) (Moyenne_hydro + Amplitude_hydro * Math.sin(2 * PI * elapsedTime / 43200 + PI / 3));
        ensoleillement = (int) (Moyenne_ensol + Amplitude_ensol * Math.sin(2 * PI * elapsedTime / 86400 + PI / 2));

        // update l'environnemnt avec les nouveaux conditions
       simPot.updateEnvironment(temperature, hydrometrie, ensoleillement);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
} */