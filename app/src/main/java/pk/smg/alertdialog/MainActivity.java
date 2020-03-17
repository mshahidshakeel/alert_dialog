package pk.smg.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = {"Simple Dialog", "Simple Dialog with Action Buttons",
                "Custom Dialog", "Simple Material Dialog", "Material Dialog with Action Buttons",
                "Material Dialog Custom View"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, items);
        ListView mainListView = findViewById(R.id.mainListView);
        mainListView.setAdapter(adapter);

        mainListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        AlertDialog alertDialog;

                        switch(position){
                            case 0:
                                alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                                alertDialog.setTitle("Simple Dialog");
                                alertDialog.setMessage("This is a simple dialog box that" +
                                            " is used to just display a message. " +
                                            "You can hide is by clicking outside the box." +
                                            " Thank You!");
                                alertDialog.show();
                                break;
                            case 1:
                                alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                                alertDialog.setTitle("Alert Dialog with Action Buttons");
                                alertDialog.setMessage("In this alert dialog you can provide " +
                                        "a response to the alert by selecting a button.");
                                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Done",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Toast.makeText(MainActivity.this, "Done is clicked!", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Toast.makeText(MainActivity.this, "Cancel is clicked!", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                alertDialog.show();
                                break;
                            case 2:
                                alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                                LayoutInflater inflater = getLayoutInflater();
                                final View v = inflater.inflate(R.layout.login_alert, null);
                                alertDialog.setView(v);
                                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE,
                                        "Login",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                TextView username = v.findViewById(R.id.username);
                                                TextView password = v.findViewById(R.id.password);

                                                Toast.makeText(MainActivity.this,
                                                        username.getText() + " " + password.getText(),
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                alertDialog.show();
                                break;
                            case 3:
                                new MaterialAlertDialogBuilder(MainActivity.this    )
                                        .setTitle("Simple Material Dialog")
                                        .setMessage("This is a simple material dialog. You can" +
                                                " dismiss it by clicking outside the box.")
                                        .show();
                                break;
                            case 4:
                                new MaterialAlertDialogBuilder(MainActivity.this)
                                        .setTitle("Material Dialog with Action Buttons")
                                        .setMessage("In this alert dialog you can provide" +
                                                "a response to the alert by selecting a button.")
                                        .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .show();
                                break;
                            case 5:
                                final View vi = getLayoutInflater().inflate(
                                        R.layout.login_alert,
                                        null
                                );
                                new MaterialAlertDialogBuilder(MainActivity.this)
                                        .setView(vi)
                                        .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                TextView username = vi.findViewById(R.id.username);
                                                TextView password = vi.findViewById(R.id.password);

                                                Toast.makeText(MainActivity.this,
                                                        username.getText() + " " + password.getText(),
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .show();
                        }
                    }
                }
        );
    }
}
