package com.arunya.aarunya;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NewRegistrationTransporterActivity extends AppCompatActivity {

    private static final String TAG = "AddToDatabase";

    private Button btnSubmit;
    private EditText mLicenseNumber,mVehicleRegistration,mPricePerKm,mVehicleCapacity,mName,mDob, mAddress,mAadhaar,mPhoneNum;
    //private Spinner mVehicleType,mCapacityInUnit,mState,mDistrict;
    private String userID;

    //add Firebase Database stuff
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporter_extra_register);

        btnSubmit = (Button) findViewById(R.id.submit_btn);
        mLicenseNumber = (EditText) findViewById(R.id.driver_license_number_edit);
        mVehicleRegistration = (EditText) findViewById(R.id.vehicle_registration_edit);
        mPricePerKm = (EditText) findViewById(R.id.price_km_edit);
        mVehicleCapacity = (EditText) findViewById(R.id.vehicle_capacity_edit);
        mName = (EditText) findViewById(R.id.name_edit);
        mDob = (EditText) findViewById(R.id.dob_edit);
        mAddress = (EditText) findViewById(R.id.address_edit);
        mAadhaar = (EditText) findViewById(R.id.uid_edit);
        //mState = (Spinner) findViewById(R.id.state_edit);
        //mDistrict = (Spinner) findViewById(R.id.district_edit);
        mPhoneNum = (EditText) findViewById(R.id.phone_edit);
        //mVehicleType = (Spinner) findViewById(R.id.vehicle_type_edit);
        //mCapacityInUnit = (Spinner) findViewById(R.id.vehicle_capacity_unit_edit);


        //declare the database reference object. This is what we use to access the database.
        //NOTE: Unless you are signed in, this will not be useable.
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    toastMessage("Successfully signed in with: " + user.getEmail());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                    toastMessage("Successfully signed out.");
                }
                // ...
            }
        };

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Log.d(TAG, "onDataChange: Added information to database: \n" +
                        dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Submit pressed.");
                String LicenseNumber = mLicenseNumber.getText().toString();
                String VehicleRegistration = mVehicleRegistration.getText().toString();
                String VehicleCapacity = mVehicleCapacity.getText().toString();
                String PricePerKm = mPricePerKm.getText().toString();
                String Name = mName.getText().toString();
                String DOB = mDob.getText().toString();
                String Address = mAddress.getText().toString();
                String Aadhaar = mAadhaar.getText().toString();
                String PhoneNum = mPhoneNum.getText().toString();
                //String state = mState.getSelectedItem().toString();
                //String district = mDistrict.getSelectedItem().toString();
                //String CapacityInUnit = mCapacityInUnit.getSelectedItem().toString();
                //String VehicleType = mVehicleType.getSelectedItem().toString();


                Log.d(TAG, "onClick: Attempting to submit to database: \n" +
                                "Name: " + Name + "\n" +
                                "DOB: " + DOB + "\n" +
                                "Address: " + Address + "\n" +
                                //"District: " + district + "\n" +
                                //"State: " + state + "\n" +
                                "Aadhaar Number: " + Aadhaar + "\n" +
                                "Phone number: " + PhoneNum + "\n"+
                        "License Number: " + LicenseNumber + "\n" +
                        "Vehicle Registration Number: " + VehicleRegistration + "\n" +
                        "Vehicle Capacity: " + VehicleCapacity + "\n" +
                        "Price per Km: " + PricePerKm + "\n"
                        //"Capacity in Unit: " + CapacityInUnit + "\n" +
                        //"Vehicle Type: " + VehicleType + "\n"
                );

                //handle the exception if the EditText fields are null
                if(!LicenseNumber.equals("") && !VehicleRegistration.equals("") && !VehicleCapacity.equals("")
                        && !PricePerKm.equals("")){
                    TransporterExtraInfo transporterExtraInfo = new TransporterExtraInfo(Name,DOB,Address,
                            PhoneNum, Aadhaar,LicenseNumber,VehicleRegistration, VehicleCapacity,
                            PricePerKm);
                    myRef.child("Users").child("Transporter").child(userID).setValue(transporterExtraInfo);
                    toastMessage("New Information has been saved.");
                    mName.setText("");
                    mDob.setText("");
                    mAddress.setText("");
                    mAadhaar.setText("");
                    mPhoneNum.setText("");
                    mLicenseNumber.setText("");
                    mVehicleRegistration.setText("");
                    mVehicleCapacity.setText("");
                    mPricePerKm.setText("");


                        Intent afterSubmit = new Intent(NewRegistrationTransporterActivity.this, TransporterHomeActivity.class);
                        startActivity(afterSubmit);

                }else{
                    toastMessage("Fill out all the fields");
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }


    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

}
