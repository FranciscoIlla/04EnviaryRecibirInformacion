package francisco.illa.a04_enviaryrecibirinformacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import francisco.illa.a04_enviaryrecibirinformacion.Modelos.Direccion;

public class CrearDireccionActivity extends AppCompatActivity {

    private EditText txtCalle;
    private EditText txtNumero;
    private EditText txtCiudad;
    private Button btnCrearDireccion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_direccion);

        inicializar();

        btnCrearDireccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String calle = txtCalle.getText().toString();
                int numero = Integer.parseInt(txtNumero.getText().toString());
                String ciudad = txtCiudad.getText().toString();

                Direccion direccion = new Direccion(calle, numero, ciudad);

                Bundle bundle = new Bundle();
                bundle.putSerializable("DIR", direccion);
                Intent intent = new Intent();
                intent.putExtras(bundle);

                setResult(RESULT_OK, intent);

                finish();

            }
        });
    }

    private void inicializar() {
        txtCalle = findViewById(R.id.txtCalleMain);
        txtNumero = findViewById(R.id.txtNumeroMain);
        txtCiudad = findViewById(R.id.txtCiudadMAin);
        btnCrearDireccion = findViewById(R.id.btnCrearDireccion);


    }
}