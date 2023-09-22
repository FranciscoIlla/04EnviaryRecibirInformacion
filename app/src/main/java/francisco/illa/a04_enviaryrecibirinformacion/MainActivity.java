package francisco.illa.a04_enviaryrecibirinformacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import francisco.illa.a04_enviaryrecibirinformacion.Modelos.Usuario;

public class MainActivity extends AppCompatActivity {

    private EditText txtPassword;

    private Button btnDesencriptar;

    private EditText txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVista();

        btnDesencriptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();
                Usuario usuario = new Usuario(email,password);
                Intent intent = new Intent(MainActivity.this,DesencriptarActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("USER",usuario);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private void inicializarVista() {
        txtPassword = findViewById(R.id.txtPasswordMain);
        txtEmail = findViewById(R.id.txtxEmail);
        btnDesencriptar = findViewById(R.id.btnDesencriptar);
    }
}