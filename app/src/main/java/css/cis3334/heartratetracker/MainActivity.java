package css.cis3334.heartratetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView lvHeartRates;
    TextView tvSelect;
    HeartRateList heartRateList;
    ArrayAdapter<HeartRate> hrAdapter;

    //ArrayList<HeartRate> basicheartRateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSelect = (TextView) findViewById(R.id.textViewSelect);
        lvHeartRates = (ListView) findViewById(R.id.listViewHeartRates);
//        basicheartRateList = new ArrayList<HeartRate>();
//        Random randGenerator = new Random();
//        for (int i=0; i<20; i++) {
//            basicheartRateList.add(new HeartRate( randGenerator.nextInt(180-110) + 110, 25));
//        }
        heartRateList = new HeartRateList();
        heartRateList.InitRandomElderly();

        //ArrayAdapter<HeartRate> planetAdapter = new ArrayAdapter<HeartRate>(this, android.R.layout.simple_list_item_1, basicheartRateList);
        hrAdapter = new HeartRateAdapter(this, R.layout.heart_rate_row, R.id.textViewPulse, heartRateList);
        hrAdapter.setDropDownViewResource(R.layout.heart_rate_row);
        lvHeartRates.setAdapter(hrAdapter);

        lvHeartRates.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                HeartRate hr = (HeartRate) parent.getItemAtPosition(position);
                tvSelect.setText("You selected: " + hr.toString());
            }
        });

    }
}
