package francisco.illa.a04_enviaryrecibirinformacion;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import francisco.illa.a04_enviaryrecibirinformacion.Modelos.Direccion;
import francisco.illa.a04_enviaryrecibirinformacion.Modelos.Usuario;

public class MainActivity extends AppCompatActivity {

    private EditText txtPassword;

    private Button btnDesencriptar;

    private EditText txtEmail;
    private Button btnDireccionMain;

    private final int DIRECCIONES=123;
    private ActivityResultLauncher<Intent> launcherDirecciones;

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
        btnDireccionMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CrearDireccionActivity.class);
                startActivityForResult(intent,DIRECCIONES);

            }
        });

    }

    /**
     * Se activa al retornar StartActivityForResult
     * @param requestCode -> identificador de la ventana o actividad que se ha cerrado "como el
     *                    tipo de dato que se retorna"
     * @param resultCode -> el mod en que se ha cerrado
     * @param data -> Datos retornados (intent con el bundle dentro)
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    if(requestCode == DIRECCIONES);{
            if(resultCode == RESULT_OK){
                Bundle bundle = data.getExtras();
                Direccion direccion = (Direccion) bundle.getSerializable("DIR");
                Toast.makeText(this, direccion.toString(), Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"CANCELADA",Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void inicializarVista() {
        txtPassword = findViewById(R.id.txtPasswordMain);
        txtEmail = findViewById(R.id.txtxEmail);
        btnDesencriptar = findViewById(R.id.btnDesencriptar);
        btnDireccionMain = findViewById(R.id.btnCrearDireccion);

    }
}