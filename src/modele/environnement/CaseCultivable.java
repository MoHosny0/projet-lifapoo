package modele.environnement;

import modele.SimulateurPotager;
import modele.environnement.varietes.Legume;
import modele.environnement.varietes.Salade;
import modele.environnement.varietes.Varietes;

public class CaseCultivable extends Case {

    private Legume legume;
    public CaseCultivable(SimulateurPotager _simulateurPotager) {
        super(_simulateurPotager);
    }

    @Override
    public void actionUtilisateur() {
        if (legume == null) {
            legume = new Salade();

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
            legume.nextStep();
        }
    }
}
