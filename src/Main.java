import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

        public static void main (String[]args){
            Scanner sc = new Scanner(System.in);


            ArrayList<String> names = new ArrayList<>();
            HashMap<String, Integer> userAndPoints = new HashMap<>();

            boolean oneMore = true;

            while (oneMore) {
                System.out.println("Skriv namn. Om du vill avlsuta tryck Enter.");
                String name = sc.nextLine();
                if (!name.isEmpty()) {

                    System.out.println("Skriv in poängen");

                    int points = sc.nextInt();
                    sc.nextLine();
                    if (!userAndPoints.containsKey(name)){
                        userAndPoints.put(name, points);
                    }
//                System.out.println("Vill du lägga till en till?");
//                String again = sc.nextLine();
                } else {
                    oneMore = false;
                }
            }
            System.out.println(userAndPoints);

            userWithHighestPoints(userAndPoints);
            printAverageScoreMap(userAndPoints);



        }
        static void userWithHighestPoints(HashMap<String, Integer> userAndPoints){
            int highestPoints = 0;
            String nameOfHighestPoints = "";
            for (Map.Entry<String, Integer> entry : userAndPoints.entrySet()){
                int points = entry.getValue();
                if (points > highestPoints){
                    highestPoints = points;
                    nameOfHighestPoints = entry.getKey();
                }
            }
            System.out.println("Personen med högst poäng var " + nameOfHighestPoints + ". Poängen var " + highestPoints);
        }
        
    static void printAverageScoreMap(HashMap<String, Integer> nameAndPoints) {
        double sumOfPoints = 0;

        for (Map.Entry<String, Integer> entry : nameAndPoints.entrySet()){
            sumOfPoints += entry.getValue();
        }
        double averagePoints = sumOfPoints / nameAndPoints.size();

        System.out.println("Medelpoängen är " + averagePoints);
    }
}


