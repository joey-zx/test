package Singleton;

public class Singletonn {

    private Singletonn() {

    }

    public static Singletonn getInstance() {
        return SingletonStatic.singleton;
    }

    private static class SingletonStatic {

        private static final Singletonn singleton = new Singletonn();
    }

}
