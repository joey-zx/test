package homework.exec;

public class PpAhlete extends Athlete implements EnglishSkill {

    @Override
    public void play() {
        System.out.println("Play Ping Pang");
    }

    @Override
    public void learnEnglish() {
        System.out.println("Learning English");
    }
}
