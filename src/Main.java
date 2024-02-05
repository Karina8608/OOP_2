import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Player> playerList = new ArrayList<>(Arrays.asList(
                new Human("Kristof", 2.0, 2.0),
                new Human("Anna", 1.5, 4),
                new Cat("Saimon", 3.2, 5.0),
                new Cat("Tihon", 5.0, 8.0),
                new Robot("Maxim", 0.0, 1.5) {
                    @Override
                    void jump(double distance) {

                    }

                    @Override
                    void endRace() {

                    }
                }
        ));

        List<Barrier> barrierList = new ArrayList<>(Arrays.asList(
                new Wall("Барьер легкий", 0.8),
                new Wall("Барьер средний", 1.1),
                new Wall("Барьер тяжелый", 1.5),
                new Way("Дорожка легкая", 0.5),
                new Way("Дорожка средняя", 1.0),
                new Way("Дорожка тяжелая", 2.0)
        ));


        for(Player player: playerList){
            System.out.println("---Успехи участника " + player.getName() + "---");
            player.run();
            for (Barrier barrier: barrierList){
                if( barrier instanceof Wall){
                    player.jump(((Wall) barrier).getDistance());
                } else if (barrier instanceof Way){
                    player.runThrough(((Way) barrier).getDistance());
                }
            }
            player.endRace();
        }
    }
}