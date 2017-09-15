package congnhat.intent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView txtResult;
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtResult = (TextView) findViewById(R.id.txtResult);
        btnBack = (Button) findViewById(R.id.btnBack);

        Intent callerIntent = getIntent();
        final Bundle packBundle = callerIntent.getBundleExtra("MyPackage");
        int a = packBundle.getInt("soA");
        int b = packBundle.getInt("soB");
        giaiPTBN(a,b);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ResultActivity.this, MainActivity.class);

                Bundle bundle = packBundle;

                myIntent.putExtra("MyPackage", bundle);
                startActivity(myIntent);
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("soA", a);
        editor.putInt("soB", b);
        editor.commit();
    }
    public void giaiPTBN(int a, int b){
        if(a==0){
            if(b==0){
                txtResult.setText("Vô số nghiệm");
                return;
            } else {
                txtResult.setText("Vô nghiệm");
            }
        } else {
            txtResult.setText(String.valueOf((float) (-b/a)));
        }
    }
}
