import nl.sapperheroes.model.user.Client;
import nl.sapperheroes.model.user.Hero;
import nl.sapperheroes.model.user.User;

public class Main {

    public static void main(String[] args) {

        User client1 = new Client();
        User client2 = new Client();

        client1.setCity("Bilthoven");
        client1.setCountry("Holland");
        client1.setFirstName("Martijn");
        client1.setLastName("Louzada");

        User hero1 = new Hero();
        User hero2 = new Hero();

        hero1.setId(1);
        hero1.setFirstName("Frank");
        hero1.setLastName("Meert");


        System.out.println(client1);
        System.out.println(hero1);


    }



}
