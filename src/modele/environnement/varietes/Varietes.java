package modele.environnement.varietes;

import java.util.EnumSet;
import java.util.Random;

public enum Varietes {
    salade, carrotte, betterave;

    private static final Random GNA = new Random();
    private static final EnumSet<Varietes> VARIETES = EnumSet.allOf(Varietes.class);
    private static final int TAILLE = VARIETES.size();

    public static Varietes varietesAleatoire() {
        return (Varietes) VARIETES.toArray()[GNA.nextInt(TAILLE)];
    }
}
