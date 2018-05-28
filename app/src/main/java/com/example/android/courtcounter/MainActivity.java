package com.example.android.courtcounter;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    public int counter;
    Button button;
    TextView textView;

    int GoalsA = 0;
    int GoalsB = 0;
    int FoulsA = 0;
    int FoulsB = 0;
    int ShotsA = 0;
    int ShotsB = 0;
    int CornerA = 0;
    int CornerB = 0;
    int OffsideA = 0;
    int OffsideB = 0;
    int YcardsA = 0;
    int RcardsA = 0;
    int YcardsB = 0;
    int RcardsB = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toast.makeText((getApplicationContext()), ("Tap Start Timer to Start"), Toast.LENGTH_LONG).show();

        /**
         ** Add countdown timer (searched the web to understand how this works, this was the recommended method I copied the code and edited it to work with my app, still having issues resetting the timer and restricting it to one timer).
         */
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(2700000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        textView.setText("" + String.format("%d min, %d sec",
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                        counter++;
                        if ((TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) == 4) &&
                                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)) == 55) {
                        }
                    }

                    /**
                     * Vibrate when timer ends (couldn't verify on an Android device, I own an Android tablet only)
                     */
                    public void onFinish() {
                        textView.setText("Time Up!!");
                        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        // Vibrate for 500 milliseconds
                        v.vibrate(500);
                    }
                }.start();

            }
        });

        /**
         * Add dropdown teams list. (Searched the web and found this was the easiest one to implement)
         */
        Spinner staticSpinner = findViewById(R.id.TeamA);
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.Teams,
                        android.R.layout.simple_spinner_item);
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticSpinner.setAdapter(staticAdapter);
        Spinner staticSpinner2 = findViewById(R.id.TeamB);
        ArrayAdapter<CharSequence> staticAdapter2 = ArrayAdapter
                .createFromResource(this, R.array.Teams,
                        android.R.layout.simple_spinner_item);
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticAdapter2
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticSpinner.setAdapter(staticAdapter);
        staticSpinner2.setAdapter(staticAdapter);

    }

    /**
     * Displays the given GOALS for Team A.
     */
    public void displayGoalsA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));

    }

    /**
     * Increase the score for Team A by 1 GOAL.
     */
    public void addOneGoalA(View v) {
        GoalsA += 1;
        displayGoalsA(GoalsA);
        Toast.makeText((getApplicationContext()), ("Goal!!!"), Toast.LENGTH_SHORT).show();
    }

    /**
     * Displays the given GOALS for Team B.
     */
    public void displayGoalsB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));


    }

    /**
     * Increase the score for Team A by 1 GOAL.
     */
    public void addOneGoalB(View v) {
        GoalsB += 1;
        displayGoalsB(GoalsB);
        Toast.makeText((getApplicationContext()), ("Goal!!!"), Toast.LENGTH_SHORT).show();
    }

    /**
     * Displays the given SHOTS for Team A.
     */
    public void displayShotsA(int shots) {
        TextView shotsView = findViewById(R.id.team_a_shots);
        shotsView.setText(String.valueOf(shots));
    }

    /**
     * Increase the SHOTS for Team A by 1 SHOT.
     */
    public void addShotsA(View v) {
        ShotsA += 1;
        displayShotsA(ShotsA);
    }

    /**
     * Displays the given SHOTS for Team B.
     */
    public void displayShotsB(int shots) {
        TextView shotsView = findViewById(R.id.team_b_shots);
        shotsView.setText(String.valueOf(shots));
    }

    /**
     * Increase the SHOTS for Team B by 1 SHOT.
     */
    public void addShotsB(View v) {
        ShotsB += 1;
        displayShotsB(ShotsB);
    }

    /**
     * Displays the given FOULS for Team A.
     */
    public void displayFoulsA(int fouls) {
        TextView foulsView = findViewById(R.id.team_a_fouls);
        foulsView.setText(String.valueOf(fouls));
    }

    /**
     * Increase the FOULS for Team A by 1 FOUL.
     */
    public void addFoulsA(View v) {
        FoulsA += 1;
        displayFoulsA(FoulsA);
    }

    /**
     * Displays the given FOULS for Team B.
     */
    public void displayFoulsB(int fouls) {
        TextView foulsView = findViewById(R.id.team_b_fouls);
        foulsView.setText(String.valueOf(fouls));
    }

    /**
     * Increase the FOULS for Team A by 1 FOUL.
     */
    public void addFoulsB(View v) {
        FoulsB += 1;
        displayFoulsB(FoulsB);
    }

    /**
     * Displays the given CornerKicks for Team A.
     */
    public void displayCornerA(int corner) {
        TextView cornerView = findViewById(R.id.team_a_ck);
        cornerView.setText(String.valueOf(corner));
    }

    /**
     * Increase the CornerKicks for Team A by 1 CornerKick.
     */
    public void addCkA(View v) {
        CornerA += 1;
        displayCornerA(CornerA);
    }

    /**
     * Displays the given CornerKicks for Team B.
     */
    public void displayCornerB(int corner) {
        TextView cornerView = findViewById(R.id.team_b_ck);
        cornerView.setText(String.valueOf(corner));
    }

    /**
     * Increase the CornerKicks for Team B by 1 CornerKick.
     */
    public void addCkB(View v) {
        CornerB += 1;
        displayCornerB(CornerB);
    }

    /**
     * Displays the given Offside for Team A.
     */
    public void displayOffsideA(int offside) {
        TextView offsideView = findViewById(R.id.team_a_os);
        offsideView.setText(String.valueOf(offside));
    }

    /**
     * Increase the Offsides for Team A by 1 Offside.
     */
    public void addOsA(View v) {
        OffsideA += 1;
        displayOffsideA(OffsideA);
    }

    /**
     * Displays the given Offside for Team B.
     */
    public void displayOffsideB(int offside) {
        TextView offsideView = findViewById(R.id.team_b_os);
        offsideView.setText(String.valueOf(offside));
    }

    /**
     * Increase the Offsides for Team B by 1 Offside.
     */
    public void addOsB(View v) {
        OffsideB += 1;
        displayOffsideB(OffsideB);
    }

    /**
     * Displays the given Yellow cards for Team A.
     */
    public void displayYcardsA(int ycards) {
        TextView ycardsView = findViewById(R.id.team_a_yc);
        ycardsView.setText(String.valueOf(ycards));


    }

    /**
     * Increase the Yellow cards for Team A by 1 card.
     */
    public void addYcA(View v) {
        YcardsA += 1;
        displayYcardsA(YcardsA);
        Toast.makeText((getApplicationContext()), ("Play nicely"), Toast.LENGTH_SHORT).show();
    }

    /**
     * Displays the given Yellow cards for Team B.
     */
    public void displayYcardsB(int ycards) {
        TextView ycardsView = findViewById(R.id.team_b_yc);
        ycardsView.setText(String.valueOf(ycards));


    }

    /**
     * Increase the Yellow cards for Team B by 1 card.
     */
    public void addYcB(View v) {
        YcardsB += 1;
        displayYcardsB(YcardsB);
        Toast.makeText((getApplicationContext()), ("Play nicely"), Toast.LENGTH_SHORT).show();
    }

    /**
     * Displays the given Red cards for Team A.
     */
    public void displayRcardsA(int rcards) {
        TextView rcardsView = findViewById(R.id.team_a_rc);
        rcardsView.setText(String.valueOf(rcards));


    }

    /**
     * Increase the Red cards for Team A by 1 card.
     */
    public void addRcA(View v) {
        RcardsA += 1;
        displayRcardsA(RcardsA);
        Toast.makeText((getApplicationContext()), ("You're out!"), Toast.LENGTH_SHORT).show();
    }

    /**
     * Displays the given Red cards for Team B.
     */
    public void displayRcardsB(int rcards) {
        TextView rcardsView = findViewById(R.id.team_b_rc);
        rcardsView.setText(String.valueOf(rcards));


    }

    /**
     * Increase the Red cards for Team B by 1 card.
     */
    public void addRcB(View v) {
        RcardsB += 1;
        displayRcardsB(RcardsB);
        Toast.makeText((getApplicationContext()), ("You're out!"), Toast.LENGTH_SHORT).show();
    }

    /**
     * Reset everything.
     */
    public void reset(View view) {

        GoalsA = 0;
        GoalsB = 0;
        FoulsA = 0;
        FoulsB = 0;
        ShotsA = 0;
        ShotsB = 0;
        CornerA = 0;
        CornerB = 0;
        OffsideA = 0;
        OffsideB = 0;
        YcardsA = 0;
        YcardsB = 0;
        RcardsA = 0;
        RcardsB = 0;

        displayGoalsA(GoalsA);
        displayGoalsB(GoalsB);
        displayShotsA(ShotsA);
        displayShotsB(ShotsB);
        displayFoulsA(FoulsA);
        displayFoulsB(FoulsB);
        displayCornerA(CornerA);
        displayCornerB(CornerB);
        displayOffsideA(OffsideA);
        displayOffsideB(OffsideB);
        displayYcardsA(YcardsA);
        displayYcardsB(YcardsB);
        displayRcardsA(RcardsA);
        displayRcardsB(RcardsB);
    }
}