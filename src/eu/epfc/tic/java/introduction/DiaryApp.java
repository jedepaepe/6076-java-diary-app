package eu.epfc.tic.java.introduction;

import java.util.Scanner;

public class DiaryApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Diary application");
        DiaryDao.initialize();
        String choice;
        do {
            System.out.println();
            System.out.println("(1) lister les rendez-vous");
            System.out.println("(2) ajouter un rendez-vous");
            System.out.println("(3) mettre à jour un rendez-vous");
            System.out.println("(4) supprimer un rendez-vous");
            System.out.println("(Q) quitter l'application");
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> DiaryUseCase.show();
                case "2" -> DiaryUseCase.add();
                case "3" -> DiaryUseCase.update();
                case "4" -> DiaryUseCase.delete();
            }

        } while (! choice.equals("Q"));
        System.out.println("à bientôt");
    }
}
