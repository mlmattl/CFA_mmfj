import model.user.DamselInDistress;
import model.user.Hero;

public class Main {

    public static void main(String[] args) {

        DamselInDistress damselInDistress1 = new DamselInDistress();
        DamselInDistress damselInDistress2 = new DamselInDistress();

        damselInDistress1.setCity("Bilthoven");
        damselInDistress1.setCountry("Holland");
        damselInDistress1.setFirstName("Martijn");
        damselInDistress1.setLastName("Louzada");

        Hero hero1 = new Hero();
        Hero hero2 = new Hero();

        hero1.setId(1);
        hero1.setFirstName("Frank");
        hero1.setLastName("Meert");



        System.out.println(damselInDistress1);
        System.out.println(hero1);


    }



}
