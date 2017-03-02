package css.cis3334.heartratetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView textViewPulse;
    TextView textViewRange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textViewPulse = (TextView) findViewById(R.id.textViewPulse);
        textViewRange = (TextView) findViewById(R.id.textViewRange);

        Bundle extras = getIntent().getExtras();
        Integer pulse = extras.getInt("MainPulse");
        HeartRate hr = (HeartRate) extras.getSerializable("MainHeartRate");
        textViewPulse.setText("Pulse : " + pulse.toString());
        textViewRange.setText("Range: " + hr.getRangeName());

    }
}
