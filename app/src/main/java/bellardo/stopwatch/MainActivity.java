package bellardo.stopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends Activity {

    private int sec=0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
    }


    protected void onClickStart(View view){
        running=true;
    }

    protected void onClickStop(View view)
    {
        running=false;
    }

    protected void onClickReset(View view){
        running=false;
        sec=0;
    }

    private void runTimer(){
        final TextView  timeView= (TextView)findViewById(R.id.Timeview);
        final Handler handler = new  Handler();
        //final Runnable t;
        handler.post(new Runnable(){
            @Override
            public void run(){
                int hr = sec/3600;
                int min = (sec%3600)/60;
                int secs = sec%60;
                String Time = String.format(Locale.US, "%d:%02d:%02d", hr, min, secs);
                timeView.setText(Time);
                if(running){
                    sec++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
}
