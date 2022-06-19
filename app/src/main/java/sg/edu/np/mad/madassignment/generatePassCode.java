package sg.edu.np.mad.madassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class generatePassCode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_pass_code);
        // find the id for the back button
        ImageView generate_back = findViewById(R.id.gen_back);
        // find the id for passcode textview
        TextView pc_passcode = findViewById(R.id.generated_pc);
        // find the id for generate passcode button
        Button generatePC = findViewById(R.id.generatePCbtn);
        // set the OnClickListener event listener for the passcode button
        generatePC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set the passcode to 6
                int length = 6;
                // set the textview to the length of the passcode specified.
                pc_passcode.setText(generateRandomPassCode(length));
            }
        });
        // set the OnClickListener event listener for back button
        generate_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // intent to go back to the lecturer's main page.
                Intent i = new Intent(generatePassCode.this, LecturerMain.class);
                // start the intent activity
                startActivity(i);
            }
        });
    }
    // method to generate random pass code
    public String generateRandomPassCode(int length) {
        // a list of random characters to be used for the passcode
      char[] randomPassCode = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
      // initialise StringBuilder
      StringBuilder stringBuilder = new StringBuilder();
      // initialise Random
        Random random = new Random();
        // for loop to append a random passcode
        for (int i = 0; i < length; i++)
        {
            char c = randomPassCode[random.nextInt(randomPassCode.length)];
            stringBuilder.append(c);
        }
        // return the result in string
        return stringBuilder.toString();
    }
}