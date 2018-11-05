package hu.bitheory.zover.rps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btn_rock, btn_paper, btn_scissors;
    private TextView results;
    private ImageView human;
    private ImageView robot;
    private TextView points;
    private int robot_points, human_points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_rock = (Button) findViewById(R.id.btn_rock);
        btn_paper = (Button) findViewById(R.id.btn_paper);
        btn_scissors = (Button) findViewById(R.id.btn_scissors);

        human = (ImageView) findViewById(R.id.human);
        robot = (ImageView) findViewById(R.id.robot);

        results = (TextView) findViewById(R.id.results);
        points = (TextView) findViewById(R.id.points);

        btn_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                human.setImageResource(R.drawable.rock);
                Robot(1);
            }
        });

        btn_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                human.setImageResource(R.drawable.paper);
                Robot(2);
            }
        });

        btn_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                human.setImageResource(R.drawable.scissors);
                Robot(3);
            }
        });
    }

    public void Robot(int human_choice) {
        Random r = new Random();

        int robot_choice = r.nextInt(3)+1;

        if(robot_choice == 1){
            robot.setImageResource(R.drawable.rock);
            Check(1,human_choice);
        }

        else if(robot_choice == 2){
            robot.setImageResource(R.drawable.paper);
            Check(2,human_choice);
        }

        else if(robot_choice == 3){
            robot.setImageResource(R.drawable.scissors);
            Check(3,human_choice);
        }
    }

    public void Check(int robot_choice, int human_choice){
        if(robot_choice == human_choice){
            results.setText("DÖNTETLEN");
        }
        else if(human_choice == 1 && robot_choice == 3){
            results.setText("NYERTÉL!");
            human_points++;
        }
        else if(human_choice== 1 && robot_choice == 2){
            results.setText("ROBOT NYERT!");
            robot_points++;
        }
        else if(human_choice == 3 && robot_choice == 1){
            results.setText("ROBOT NYERT!");
            robot_points++;
        }
        else if(human_choice == 3 && robot_choice == 2) {
            results.setText("NYERTÉL!");
            human_points++;
        }
        else if(human_choice == 2 && robot_choice == 1){
            results.setText("NYERTÉL!");
            human_points++;
        }
        else if(human_choice == 2 && robot_choice == 3){
            results.setText("ROBOT NYERT!");
            robot_points++;
        }

        points.setText("TE: " + human_points + " | ROBOT: " + robot_points);
    }
}
