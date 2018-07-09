package com.arunya.aarunya;

import android.content.Intent;
import android.location.Address;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Enquiry extends AppCompatActivity {

    private Button enquirySubmit;
    private EditText nameEdit, mailEdit, enquiryEdit;
    private String userID;

    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);

        enquirySubmit = (Button) findViewById(R.id.enquiry_submit);
        nameEdit = (EditText) findViewById(R.id.enquiry_name_edit);
        mailEdit = (EditText) findViewById(R.id.enquiry_edit_email);
        enquiryEdit = (EditText) findViewById(R.id.enquiry_edit_enquiry);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        enquirySubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEdit.getText().toString();
                String mail = mailEdit.getText().toString();
                String enquiry = enquiryEdit.getText().toString();


                //handle the exception if the EditText fields are null
                if (!name.equals("") && !mail.equals("") && !enquiry.equals("")) {
                    EnquiryInfo enquiryInfo = new EnquiryInfo(name, mail, enquiry);
                    myRef.child("Enquiry").child(userID).setValue(enquiryInfo);
                    Toast.makeText(Enquiry.this, "Your  Enquiry has been submitted", Toast.LENGTH_SHORT).show();
                    nameEdit.setText("");
                    mailEdit.setText("");
                    enquiryEdit.setText("");


                    Intent Submit = new Intent(Enquiry.this, TransporterHomeActivity.class);
                    startActivity(Submit);
                } else {
                    Toast.makeText(Enquiry.this, "Fill out all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
