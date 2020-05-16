package homework.Farm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Farm {

    private List<Cow> cows = new ArrayList<>();

    public Farm() {
        cows.add(new Cow(5));
    }

    public void bronCow() {
        for (int i = 0; i < cows.size(); i++) {
            Cow cow = cows.get(i).bronCow();
            if(cow != null) {
                cows.add(cow);
            }
        }
    }

    public int getCowsNum() {
        return cows.size();
    }
}
