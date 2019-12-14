package mosfeqanik01.numbertable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int TimeTableNumber;
    ListView timeTable;
    public void generateTimetable(int TimeTableNumber ){
        ArrayList<String> timeTableList = new ArrayList<String> ();
        for(int j=1;j <= 10;j++){
            timeTableList.add(Integer.toString(TimeTableNumber)+" * "+ Integer.toString(j) + " = " + Integer.toString(j*TimeTableNumber));
//            timeTableList.add(Integer.toString(j * TimeTableNumber));
        }
        ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timeTableList);
        timeTable.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeTable = findViewById(R.id.timetableListView);
        final SeekBar seekbarValue = findViewById(R.id.timeTableSeekBar);
        int max=20;
        int Startingpoint=10;
        seekbarValue.setMax(max);
        seekbarValue.setProgress(Startingpoint);

        seekbarValue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                if(progress < min){
                    TimeTableNumber = min;
                    seekbarValue.setProgress(TimeTableNumber);
                }else{
                    TimeTableNumber = progress;
                }
                generateTimetable(TimeTableNumber );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
