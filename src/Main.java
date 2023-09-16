import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

        public static void main (String[]args){
            Scanner sc = new Scanner(System.in);

//            ArrayList<Integer> points = new ArrayList<>();
            ArrayList<String> names = new ArrayList<>();
            HashMap<String, Integer> userAndPoints = new HashMap<>();

            boolean oneMore = true;

            while (oneMore) {
                System.out.println("Skriv namn. Om du vill avlsuta tryck Enter.");
                String name = sc.nextLine();
                if (!name.isEmpty()) {
//                    names.add(name);
                    System.out.println("Skriv in poängen");
//                    points.add(sc.nextInt());
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
//            printHighestScore(points, names);
            String userWithHighestPoints = getUserWithHighestPoints(userAndPoints);
            System.out.println("Användaren med högst poäng var " + userWithHighestPoints + ". Poängen var " + userAndPoints.get(userWithHighestPoints));
//            printAverageScore(points);


        }
        static String getUserWithHighestPoints(HashMap<String, Integer> userAndPoints){
            int highestPoints = 0;
            String nameOfHighestPoints = "";
            for (Map.Entry<String, Integer> entry : userAndPoints.entrySet()){
                int points = entry.getValue();
                if (points > highestPoints){
                    highestPoints = points;
                    nameOfHighestPoints = entry.getKey();
                }
            }
            return nameOfHighestPoints;
        }


        static void printHighestScore(ArrayList<Integer> points, ArrayList<String> names) {
            // Eller ska vi printa härifrån? isf skicka in båda arrayerna.
            int highestScoreIndex = 0;
            int highestScore = 0;
            for (int i = 0; i < points.size(); i++) {
                if (points.get(i) > highestScore) {
                    highestScoreIndex = i;
                    highestScore = points.get(i);
                }
            }
            System.out.println("Den högst poängen är " + highestScore + " och det var " + names.get(highestScoreIndex));
        }

        static void printAverageScore(ArrayList<Integer> points) {

            double sumOfPoints = 0;
            for (int score : points) {
                sumOfPoints = sumOfPoints + score;
            }
            double averagePoints = sumOfPoints / points.size();
            System.out.println("Medelpoängen är " + averagePoints);
        }
}


