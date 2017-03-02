package css.cis3334.heartratetracker;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by cssuser on 2/16/2017.
 */

public class HeartRateAdapter  extends ArrayAdapter<HeartRate> {

    private final Context context;
    private HeartRateList hrList;

    public HeartRateAdapter(Context context, int rowLayout, int dummyTV, HeartRateList hrList) {
        super(context, rowLayout, dummyTV, hrList.getList());
        this.context = context;
        this.hrList = hrList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the heart rate we are displaying
        HeartRate hr = hrList.getHeartRate(position);
        View view;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.heart_rate_row, null);

        TextView tvPulse=(TextView)view.findViewById(R.id.textViewPulse);
        TextView tvType=(TextView)view.findViewById(R.id.textViewtype);
        TextView tvDescription=(TextView)view.findViewById(R.id.textViewDescription);
        tvPulse.setText(hr.getPulse().toString());
        tvType.setText(hr.getRangeName());

        if (hr.getRange()==0) {
            tvType.setTextColor(ContextCompat.getColor(context, R.color.colorZone1));
        } else if (hr.getRange()==1) {
            tvType.setTextColor(ContextCompat.getColor(context, R.color.colorZone2));
        } else if (hr.getRange()==2) {
            tvType.setTextColor(ContextCompat.getColor(context, R.color.colorZone3));
        } else if (hr.getRange()==3) {
            tvType.setTextColor(ContextCompat.getColor(context, R.color.colorZone4));
        } else if (hr.getRange()==4) {
            tvType.setTextColor(ContextCompat.getColor(context, R.color.colorZone5));
        } else if (hr.getRange()==5) {
            tvType.setTextColor(ContextCompat.getColor(context, R.color.colorZone6));
        }



        tvDescription.setText(hr.getRangeDescrtiption());

        return(view);
    }

}
