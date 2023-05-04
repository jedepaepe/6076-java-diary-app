package eu.epfc.tic.java.introduction;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class DiaryUI {
    private static Scanner scanner = new Scanner(System.in);

    public static void show(List<Diary> diaries) {
        System.out.println("\nListe des rendez-vous");
        for(Diary d : diaries) {
            System.out.println(String.join(" - ", "" + d.getId(), d.getTitle(), d.getDescription(), d.getBegin(),
                    d.getIsPublic()));
        }
    }

    public static Diary addForm() {
        System.out.println("\nFormulaire d'ajout d'un rendez-vous");
        return requestDiaryData();
    }

    public static Diary updateForm() {
        System.out.println("\nFormulaire de modification d'un rendez-vous");
        int id = requestId();
        Diary diary = requestDiaryData();
        diary.setId(id);
        return diary;
    }

    public static int deleteForm() {
        System.out.println("\nFormulaire de suppression d'un rendz-vous");
        return requestId();
    }

    private static int requestId() {
        System.out.print("Identifiant: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static Diary requestDiaryData() {
        System.out.print("Titre: ");
        String title = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Date de début: ");
        String begin = scanner.nextLine();
        System.out.print("Is public? ");
        String isPublic = scanner.nextLine();
        return new Diary(title, description, begin, isPublic);
    }
}
