package com.rohit.fragment_parcelable_factory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText eName, eEmail, eId;
    private Button button;
    int iId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eName = findViewById(R.id.editText1);
        eId = findViewById(R.id.editText2);
        eEmail = findViewById(R.id.editText3);
        button = findViewById(R.id.Button1);
        click();
    }

    public void click() {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sName = eName.getText().toString();
                try {

                    iId = Integer.parseInt(eId.getText().toString());
                } catch (NumberFormatException iId) {
                }
                String sEmail = eEmail.getText().toString();

                Person person = new Person(sName, sEmail, iId);
                Parceble_Fragment parceble_fragment = Parceble_Fragment.newInstance(person);


                getFragmentManager().beginTransaction().add(R.id.fragment_container, parceble_fragment).commit();
                clean();

            }
        });
    }

    public void clean() {
        eName.setText("");
        eId.setText("");
        eEmail.setText("");
    }
}
