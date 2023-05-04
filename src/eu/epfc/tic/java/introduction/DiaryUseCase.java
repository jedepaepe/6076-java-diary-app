package eu.epfc.tic.java.introduction;

import java.util.List;

public class DiaryUseCase {
    public static void show() {
        List<Diary> diaries = DiaryDao.fetch();
        DiaryUI.show(diaries);
    }

    public static void add() {
        Diary diary = DiaryUI.addForm();
        DiaryDao.add(diary);
    }

    public static void update() {
        Diary diary = DiaryUI.updateForm();
        DiaryDao.update(diary);
    }

    public static void delete() {
        int id = DiaryUI.deleteForm();
        DiaryDao.delete(id);
    }
}
