import java.util.ArrayList;
import java.util.Scanner;

public class Main {

        public static void main (String[]args){
            Scanner sc = new Scanner(System.in);

            ArrayList<Integer> points = new ArrayList<>();
            ArrayList<String> names = new ArrayList<>();

            boolean oneMore = true;

            while (oneMore) {
                System.out.println("Skriv namn. Om du vill avlsuta tryck Enter.");
                String name = sc.nextLine();
                if (!name.isEmpty()) {
                    names.add(name);
                    // Comment2
                    System.out.println("Skriv in poängen");
                    points.add(sc.nextInt());
                    sc.nextLine();
//                System.out.println("Vill du lägga till en till?");
//                String again = sc.nextLine();
                } else {
                    oneMore = false;
                }
            }
            printHighestScore(points, names);
            printAverageScore(points);
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


