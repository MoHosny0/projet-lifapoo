package modele.environnement;

import modele.SimulateurPotager;
import modele.environnement.varietes.*;

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
            Varietes variete = simulateurPotager.nouveauLegume();
            switch (variete) {
                case salade:
                    legume = new Salade();
                    break;
                case carrotte:
                    legume = new Carrotte();
                    break;
                case betterave:
                    legume = new Betterave();
                    break;
            }
        } else {
            Varietes variete = legume.getVariete();
            simulateurPotager.recolter(variete);
            legume = null;
            System.out.println(variete.name() + " à été récolté");
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
