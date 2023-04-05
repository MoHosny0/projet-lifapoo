package modele.environnement;

import modele.SimulateurPotager;
import modele.environnement.varietes.Legume;
import modele.environnement.varietes.Salade;

public class CaseCultivable extends Case {

    private Legume legume;
    public CaseCultivable(SimulateurPotager _simulateurPotager) {
        super(_simulateurPotager);
        
    }

    //DONE
    public void updateCase(int temperature, int hydrometrie, int ensoleillement) {

        //TODOOO
    // Mettre à jour l'état de la case enfonction des conditions météorologiques actuelles.
    

     if (legume != null) {
        legume.croissance( temperature, hydrometrie, ensoleillement);
    }

    }


    @Override
    public void actionUtilisateur() {
        if (legume == null) {
            legume = new Salade();

        } else {
            legume = null;
        }
    }

    public Legume getLegume() {
        return legume;
    }

    @Override
    public void run() {
        if (legume != null) {
            
            int[] conditions = simulateurPotager.getSimMet().getCondition(); // get up to date conditions
            legume.nextStep(conditions[0], conditions[1], conditions[2]); // utiliser next step avec les nouveau condition.
        }
    }
}
