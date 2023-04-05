package modele.environnement.varietes;

public class Salade extends Legume {
    @Override
    public Varietes getVariete() {
        return Varietes.salade;
    }

    @Override
    public void croissance(int temperature, int hydrometrie, int ensoleillement){
        // TODO
        //System.out.println("Une salade pousse !!");


        
        // exemple  

        
          if (temperature >= 10 && temperature <= 20 && hydrometrie >= 40 && ensoleillement >= 50) {
            System.out.println("Une salade pousse !!");
        } else {
            System.out.println("Les conditions ne sont pas favorables pour la croissance");
        }
         
    }
}
