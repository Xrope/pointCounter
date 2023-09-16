import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

        public static void main (String[]args){
            HashMap<String, Integer> nameAndPoints = new HashMap<>();
            boolean keepGoing = true;
            System.out.println("Välkommen!");
            System.out.println("Här kan du skriva in namn och poäng och sedan räkna medelvärdet och ta reda på högst poängen.");

            do {
                String menuItemPicked = "";
                System.out.println();
                printMenu(nameAndPoints.isEmpty());
                menuItemPicked = sc.nextLine();

                switch (menuItemPicked) {
                    case "1" -> addNamesAndPoints(nameAndPoints);
                    case "2" -> userWithHighestPoints(nameAndPoints);
                    case "3" -> printAverageScoreMap(nameAndPoints);
                    case "4" -> keepGoing = false;
                    default -> System.out.println("Ogiltigt menyval");
                }


            }while (keepGoing);


            System.out.println(nameAndPoints);

        }

        static void printMenu(boolean isNameAndPointsEmpty){
            System.out.println("___________Meny___________");
            System.out.println("1. Lägg in namn och poäng");
            System.out.println("2. Visa vem som har högstpoäng." + (isNameAndPointsEmpty ? "Lägg in namn och poäng först.": ""));
            System.out.println("3. Räkna ut medelvärdet." + (isNameAndPointsEmpty ? "Lägg in namn och poäng först.": ""));
            System.out.println(("4. Avsluta"));

        }

        static void addNamesAndPoints(HashMap<String, Integer> nameAndPoints){
            boolean oneMore = true;


            while (oneMore) {
                System.out.println("Skriv namn. Om du vill avlsuta tryck Enter.");
                String name = sc.nextLine();
                if (!name.isEmpty()) {

                    System.out.println("Skriv in poängen");

                    int points = sc.nextInt();
                    sc.nextLine();
                    if (!nameAndPoints.containsKey(name)){
                        nameAndPoints.put(name, points);
                    }
//                System.out.println("Vill du lägga till en till?");
//                String again = sc.nextLine();
                } else {
                    oneMore = false;
                }
            }
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


