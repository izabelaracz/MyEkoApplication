package com.example.myekoapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myekoapplication.QuizContract.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "MyEkoQuiz.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public QuizDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_TEXT + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);

    }

    private void fillQuestionsTable() {
        Question q1 = new Question("Ekologia zajmuje się:", "Zależnościami między żywymi organizmami a środowiskiem, w którym żyją.", "Ochroną środowiska.", "Według ogólnej definicji ekologia to nauka o strukturze i funkcjonowaniu przyrody. Przede wszystkim należy zdawać sobie sprawę, iż ekologia to dziedzina biologii. Zajmuje się ona opisywaniem zależności między wybranymi gatunkami organizmów żywych a środowiskiem w jakim żyją. Równocześnie zajmuje się ona badaniem zjawisk zachodzących pomiędzy poszczególnymi organizmami żywymi.", 1);
        addQuestion(q1);
        Question q2 = new Question("Recykling to:", "Powtórne wykorzystanie odpadów.", "Wyrzucanie odpadów", "Recykling to system czynności i procesów, zmierzający do odzyskania i ponownego wykorzystania odpadów komunalnych, przy jak najmniejszym wkładzie energetycznym. Recykling sprawia, że odpady stają się z powrotem wartościowe i zamiast trafić na składowisko, przekształcają się w surowce do produkcji nowych materiałów.",1);
        addQuestion(q2);
        Question q3 = new Question("Co należy zrobić z napotkanymi w lesie grzybami trującymi?", "Zniszczyć je.", "Pozostawić je w spokoju.", "Niejadalne przez ludzi grzyby należy zostawić w spokoju, ponieważ są one pokarmem dla zwierząt, są one schronieniem dla owadów, poprawiają warunki życiowe jak i zarówno grzybów jak i drzewa, urzyźniają glebę oraz są wykorzystywane w produkcji lekarstw i witamin.",2);
        addQuestion(q3);
        Question q4 = new Question("Smogiem nazywamy:", "Niską i gęstą mgłę.", "Utrzymujące się nad wielkimi miastami i okręgami przemysłowymi zanieczyszczenie powietrza.", "Smog jest niczym innym jak zanieczyszczeniem powietrza. Smog jest w rzeczywistości mieszaniną powstała w wyniku zanieczyszczeń powietrza wynikających z naszej działalności i niekorzystnych zjawisk atmosferycznych (przede wszystkim mgły).  Potocznie za smog uznaje się rodzaj chmury, która unosi się nad miastem czy wsią zwłaszcza w okresie jesiennym i zimowym. Polski smog, bo tak można nazwać jedno z największych zanieczyszczeń w Europie, składa się przede wszystkim z tlenków węgla, azotu i siarki i najbardziej szkodliwych pyłów PM10 i PM2,5 oraz benzo(a)pirenu . ", 2);
        addQuestion(q4);
        Question q5 = new Question("Jak zmniejszyć ilość śmieci?", "Kupować tylko najpotrzebniejsze rzeczy i segregować odpadki.", "Nie da się zmniejszyć.", "Czy wiesz, że w każdej minucie na świecie sprzedaje się około miliona plastikowych butelek? \"Less waste\" to styl życia zakładający ograniczanie ilości produkowanych odpadów do niezbędnego minimum poprzez: ograniczenie nadmiernego konsumpcjonizmu, który zagraża środowisku naturalnego, przemyślane decyzje zakupowe, odpowiednie użytkowanie posiadanej żywności i przedmiotów, maksymalne wykorzystanie pozostałości i resztek.", 1);
        addQuestion(q5);
        Question q6 = new Question("Dbamy o ilość zużywanej wody kąpiąc się:", "W wannie pełnej wody.", "Pod prysznicem.", " Do napełnienia wanny średniej wielkości potrzeba ok. 150 litrów wody, zaś średnio w czasie prysznica zużywa się 15 litrów wody na minutę. Zatem, jeśli bierzemy szybki prysznic, oszczędność wody w porównaniu z kąpielą w wannie jest olbrzymia, liczby mówią same za siebie: 4-minutowy prysznic to pobór wody rzędu 60 litrów, zaś w czasie kąpieli zużyjemy ponad dwa razy tyle, czyli ok. 150 litrów.", 2);
        addQuestion(q6);
        Question q7 = new Question("Związkiem niszczącym warstwę ozonową w atmosferze jest:", "tlenek węgla", "freon", "Ozon stratosferyczny powstaje w wyniku oddziaływania promieniowania ultrafioletowego pochodzącego ze Słońca na cząsteczki atmosferycznego tlenu. Powstały ozon zanika w reakcji katalitycznego rozpadu z atomami chloru, uwolnionymi po rozpadzie freonów. Problem pojawił się, gdy do powszechnego użycia wszedł związek zwany freonem-12. Związki te wykorzystywane były w sprężarkach, urządzeniach chłodniczych i klimatyzacyjnych, do produkcji lakierów, a także w przemyśle kosmetycznym i medycynie. Cząsteczki freonów nie wchodzą w reakcję z innymi substancjami i nie rozpadają się w troposferze, mogą więc pozostawać w atmosferze w stanie niezmienionym przez ponad 100 lat.", 2);
        addQuestion(q7);
        Question q8 = new Question("Wzrost temperatury Ziemi i zmiany klimatyczne to skutek rosnącego stężenia w atmosferze:", "tlenu", "dwutlenku węgla", "Niebezpieczne dla przyszłości życia na naszej planecie zmiany związane są przede wszystkim z tzw. globalnym ociepleniem. Zjawisko to jest konsekwencją uwalniania się do atmosfery gazów cieplarnianych (w szczególności dwutlenku węgla), będących produktem ubocznym działalności człowieka. Wzrost stężenia CO2 następuje głównie na skutek spalania paliw kopalnych (m.in. węgla, ropy naftowej i jej produktów), produkcji cementu (podstawowego materiału budowlanego), a także w związku z powiększaniem areałów rolniczych kosztem wycinki lasów – naturalnych „płuc Ziemi”, które redukują ilość dwutlenku węgla w powietrzu.", 2);
        addQuestion(q8);
        Question q9 = new Question("Jaki rodzaj trawnika zapewni większą różnorodność biologiczną i dostarczy pokarmu większej liczbie owadów zapylających rośliny?", "Często koszony trawnik w stylu angielskim.", "Łąki kwietne z wyspami chwastów.", "Łąka kwietna jest schronieniem nawet dla 300 gatunków zwierząt: małych ssaków, gadów, płazów, owadów, oraz zapylaczy, w tym pszczół, które zbierając pyłek pełnią pożyteczną rolę w ekosystemie. Łąka stanowi dla nich miejsce do rozmnażania i schronienie, jest bogata gatunkowo – może ją tworzyć nawet 60 gatunków różnych roślin, czyli zdecydowanie więcej, niż tworzy trawnik! Ponadto złożony system korzeniowy roślin wiąże wodę deszczową w glebie, zatrzymując wilgoć dłużej niż trawnik, dodatnio wpływa na bilans wód gruntowych.", 2);
        addQuestion(q9);
        Question q10 = new Question("Człowiek powinien wypić 1,5 litra wody dziennie. Aby jak najmniej szkodzić środowisku naturalnemu, zamiast kupować wodę w butelkach plastikowych, należy:", "Kupować wodę w szklanych butelkach.", "Pić przefiltrowaną wodę z kranu.", "Picie filtrowanej wody kranowej sprawia, że nie produkujemy ton plastiku, nie zanieczyszczamy przy tym środowiska. Dodatkowo jest to bardzo tanie! Może kosztować ok. 20 gr za litr – czyli nawet 10 razy taniej niż koszt zakupu wody butelkowanej.", 2);
        addQuestion(q10);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_TEXT, question.getText());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setText(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_TEXT)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
