package congnhat.intent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtA, edtB;
    private Button btnResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtA = (EditText) findViewById(R.id.edtA);
        edtB = (EditText) findViewById(R.id.edtB);
        btnResult = (Button) findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);

                if(!edtA.getText().toString().isEmpty() && !edtB.getText().toString().isEmpty()){
                    int a = Integer.parseInt(edtA.getText().toString());
                    int b = Integer.parseInt(edtB.getText().toString());

                    Bundle bundle = new Bundle();
                    bundle.putInt("soA", a);
                    bundle.putInt("soB", b);

                    myIntent.putExtra("MyPackage", bundle);
                    startActivity(myIntent);
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập số!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE);
        int a = sharedPreferences.getInt("soA",0);
        int b = sharedPreferences.getInt("soB",0);
        Toast.makeText(MainActivity.this, "Wellcome back to MainActivity ! Your last edit text : a= " + a + "  , b= " + b, Toast.LENGTH_LONG).show();
    }
}
