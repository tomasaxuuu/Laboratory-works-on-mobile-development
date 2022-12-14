package com.example.thirdlaboratory;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText xOne = findViewById(R.id.funcXone);
        EditText xTwo = findViewById(R.id.funcXtwo);
        Button submit = findViewById(R.id.submitBtn);
        Button clear = findViewById(R.id.clearBtn);
        GraphView graph = findViewById(R.id.graph);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    float firstX = Float.parseFloat(xOne.getText().toString());
                    float secondX = Float.parseFloat(xTwo.getText().toString());
                    if(Math.abs(firstX) >= Math.abs(secondX)) {
                        throw new Exception();
                    }
                    graph.getXs(firstX, secondX);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.empty),
                            Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                graph.clearGraph();
            }
        });
    }
}