/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;


import modele.environnement.Case;
import modele.environnement.CaseCultivable;
import modele.environnement.CaseNonCultivable;

import java.awt.Point;
import java.util.HashMap;
import java.util.Random;


public class SimulateurPotager {

    public static final int SIZE_X = 20;
    public static final int SIZE_Y = 10;

    private SimulateurMeteo simMet;

    // private HashMap<Case, Point> map = new  HashMap<Case, Point>(); // permet de récupérer la position d'une entité à partir de sa référence
    private Case[][] grilleCases = new Case[SIZE_X][SIZE_Y]; // permet de récupérer une entité à partir de ses coordonnées

    private HashMap<String, Integer> inventaire;

    public SimulateurPotager() {

        initialisationDesEntites();

        simMet = new SimulateurMeteo(this);

        inventaire = new HashMap<String, Integer>();
    }


    
    public Case[][] getPlateau() {
        return grilleCases;
    }
    
    private void initialisationDesEntites() {

        // murs extérieurs horizontaux
        for (int x = 0; x < 20; x++) {
            addEntite(new CaseNonCultivable(this), x, 0);
            addEntite(new CaseNonCultivable(this), x, 9);
        }

        // murs extérieurs verticaux
        for (int y = 1; y < 9; y++) {
            addEntite(new CaseNonCultivable(this), 0, y);
            addEntite(new CaseNonCultivable(this), 19, y);
        }

        addEntite(new CaseNonCultivable(this), 2, 6);
        addEntite(new CaseNonCultivable(this), 3, 6);

        Random rnd = new Random();

        for (int x = 5; x < 15; x++) {
            for (int y = 3; y < 7; y++) {
                CaseCultivable cc = new CaseCultivable(this);
                addEntite(cc , x, y);
                if (rnd.nextBoolean()) {
                    cc.actionUtilisateur();
                }

                Ordonnanceur.getOrdonnanceur().add(cc);

            }
        }

    }

    public void actionUtilisateur(int x, int y) {
        if (grilleCases[x][y] != null) {
            grilleCases[x][y].actionUtilisateur();
        }
    }

    private void addEntite(Case e, int x, int y) {
        grilleCases[x][y] = e;
        //map.put(e, new Point(x, y));
    }


    private Case objetALaPosition(Point p) {
        Case retour = null;
        return grilleCases[p.x][p.y];
    }

    public void recolter(String legume) {
        if (inventaire.containsKey(legume)) {
            inventaire.replace(legume, inventaire.get(legume) + 1);
        } else {
            inventaire.put(legume, 1);
        }
        System.out.println("Vous avez " + inventaire.get(legume) + " " + legume);
    }

}
