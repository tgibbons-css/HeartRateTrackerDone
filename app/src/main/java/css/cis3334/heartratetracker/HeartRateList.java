package css.cis3334.heartratetracker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by cssuser on 2/16/2017.
 */

public class HeartRateList {
    private ArrayList<HeartRate> heartRateList = new ArrayList<HeartRate>();

    public HeartRateList() {
        heartRateList = new ArrayList<HeartRate>();
    }

    public void InitRandomYouth() {
        Random randGenerator = new Random();
        for (int i=0; i<20; i++) {
            heartRateList.add(new HeartRate( randGenerator.nextInt(180-110) + 110, 25));
        }
    }
    public void InitRandomElderly() {
        Random randGenerator = new Random();
        for (int i=0; i<20; i++) {
            heartRateList.add(new HeartRate( randGenerator.nextInt(150-80) + 80, 50));
        }
    }

    public List getList() {
        return heartRateList;
    }

    public HeartRate getHeartRate(Integer index) {
        return heartRateList.get(index);
    }


    public void remove(Integer index){
        heartRateList.remove(index);
    }

}
