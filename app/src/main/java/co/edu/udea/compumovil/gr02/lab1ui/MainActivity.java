package co.edu.udea.compumovil.gr02.lab1ui;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Date;

import co.edu.udea.compumovil.gr02.lab1ui.R;

public class MainActivity extends AppCompatActivity {
    String nombre;
    String apellido;
    String direccion;
    String email;
    String telefono;
    String pais;
    String sexo;
    String hobbie;
    boolean favorito;
    int dia;
    int mes;
    int año;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Generando el autocomplete
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.aTxtV_pais);
        String[] paises = getResources().getStringArray(R.array.pais_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paises);
        textView.setAdapter(adapter);
        //agregandole opciones al Spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner_hobbie);
        ArrayAdapter<CharSequence> adapterHobbie = ArrayAdapter.createFromResource(this, R.array.hobbies_array, android.R.layout.simple_spinner_item);
        adapterHobbie.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterHobbie);
        nombre = String.valueOf("");
        apellido = String.valueOf("");
        direccion = String.valueOf("");
        email = String.valueOf("");
        telefono = String.valueOf("");
        pais = String.valueOf("");
        sexo = String.valueOf("");
        hobbie = String.valueOf("");
        favorito = false;
        dia = Integer.valueOf(0);
        mes = Integer.valueOf(0);
        año = Integer.valueOf(0);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void showContact(View view) {
        ((TextView) findViewById(R.id.txtVw_contacto)).setText("");
        capturarEditText();
        capturarRadioButton();
        capturarDatePicker();
        capturarSpinner();
        capturarCheckBox();

        if (esContactoValido()) {
            ((TextView) findViewById(R.id.txtVw_contacto)).append(nombre + "\n");
            ((TextView) findViewById(R.id.txtVw_contacto)).append(apellido + "\n");
            ((TextView) findViewById(R.id.txtVw_contacto)).append(email + "\n");
            ((TextView) findViewById(R.id.txtVw_contacto)).append(direccion + "\n");
            ((TextView) findViewById(R.id.txtVw_contacto)).append(telefono + "\n");
            ((TextView) findViewById(R.id.txtVw_contacto)).append(pais + "\n");
            ((TextView) findViewById(R.id.txtVw_contacto)).append(sexo + "\n");
            ((TextView) findViewById(R.id.txtVw_contacto)).append(dia + "/" + mes + "/" + año + "\n");
            if (favorito) {
                ((TextView) findViewById(R.id.txtVw_contacto)).append("favorito");
            }
        } else {
            Toast toast1 = Toast.makeText(getApplicationContext(), "Complete el formulario. No ha ingresado datos en los campos subrayados", Toast.LENGTH_SHORT);
            toast1.show();
        }




    }

    private void capturarEditText() {
        EditText e1 = (EditText) findViewById(R.id.edTxt_nombre);
        nombre = e1.getText().toString();
        e1 = (EditText) findViewById(R.id.edTxt_apellido);
        apellido = e1.getText().toString();
        e1 = (EditText) findViewById(R.id.edTxt_direccion);
        direccion = e1.getText().toString();
        e1 = (EditText) findViewById(R.id.edTxt_email);
        email = e1.getText().toString();
        e1 = (EditText) findViewById(R.id.edTxt_telefono);
        telefono = e1.getText().toString();
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.aTxtV_pais);
        pais = textView.getText().toString();
    }

    private void capturarRadioButton() {
        sexo = "";
        boolean checked = ((RadioButton) findViewById(R.id.radio_mujer)).isChecked();
        if (checked) {
            sexo = ((RadioButton) findViewById(R.id.radio_mujer)).getText().toString();
        } else {
            sexo = ((RadioButton) findViewById(R.id.radio_hombre)).getText().toString();
        }
    }

    private void capturarCheckBox() {
        favorito = ((CheckBox) findViewById(R.id.checkBox_favorito)).isChecked();
    }

    private void capturarSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.spinner_hobbie);
        hobbie = spinner.getSelectedItem().toString();
    }

    private void capturarDatePicker() {
        dia = ((DatePicker) findViewById(R.id.datePicker)).getDayOfMonth();
        mes = ((DatePicker) findViewById(R.id.datePicker)).getMonth();
        año = ((DatePicker) findViewById(R.id.datePicker)).getYear();
    }


    private boolean esContactoValido() {
        boolean esValido = true;
        if (nombre.isEmpty()) {
            EditText e1 = (EditText) findViewById(R.id.edTxt_nombre);
            e1.setBackgroundColor(Color.parseColor("#dfdf1f"));
            esValido = false;
        }else{
            EditText e1 = (EditText) findViewById(R.id.edTxt_nombre);
            e1.setBackgroundColor(Color.TRANSPARENT);
        }

        if (apellido.isEmpty()) {
            EditText e1 = (EditText) findViewById(R.id.edTxt_apellido);
            e1.setBackgroundColor(Color.parseColor("#dfdf1f"));
            esValido = false;
        }else{
            EditText e1 = (EditText) findViewById(R.id.edTxt_apellido);
            e1.setBackgroundColor(Color.TRANSPARENT);
        }


        if (direccion.isEmpty()) {
            EditText e1 = (EditText) findViewById(R.id.edTxt_direccion);
            e1.setBackgroundColor(Color.parseColor("#dfdf1f"));
            esValido = false;
        }else{
            EditText e1 = (EditText) findViewById(R.id.edTxt_direccion);
            e1.setBackgroundColor(Color.TRANSPARENT);
        }

        if (email.isEmpty()) {
            EditText e1 = (EditText) findViewById(R.id.edTxt_email);
            e1.setBackgroundColor(Color.parseColor("#dfdf1f"));
            esValido = false;
        }else{
            EditText e1 = (EditText) findViewById(R.id.edTxt_email);
            e1.setBackgroundColor(Color.TRANSPARENT);
        }

        if (telefono.isEmpty()) {
            EditText e1 = (EditText) findViewById(R.id.edTxt_telefono);
            e1.setBackgroundColor(Color.parseColor("#dfdf1f"));
            esValido = false;
        }else{
            EditText e1 = (EditText) findViewById(R.id.edTxt_telefono);
            e1.setBackgroundColor(Color.TRANSPARENT);
        }

        if (pais.isEmpty()) {
            AutoCompleteTextView e1 = (AutoCompleteTextView) findViewById(R.id.aTxtV_pais);
            e1.setBackgroundColor(Color.parseColor("#dfdf1f"));
            esValido = false;
        }else{
            AutoCompleteTextView e1 = (AutoCompleteTextView) findViewById(R.id.aTxtV_pais);
            e1.setBackgroundColor(Color.TRANSPARENT);
        }
        return esValido;
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://co.edu.udea.compumovil.gr02.lab1ui/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://co.edu.udea.compumovil.gr02.lab1ui/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
