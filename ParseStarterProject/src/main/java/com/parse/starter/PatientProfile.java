package com.parse.starter;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class PatientProfile extends AppCompatActivity {

//    TextView pat_Name, pat_Phone, pat_Loc, pat_Age;
//    ImageView pat_Img, pat_ImgBlur;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_doctor_profile);
//        linkLayoutFeatures();
//        //initializeID();
//    }
//
//    private void linkLayoutFeatures() {
//        pat_Name = findViewById(R.id.pat_Name);
//        pat_Img = findViewById(R.id.pat_Img);
//        pat_ImgBlur = findViewById(R.id.pat_ImgBlur);
//        pat_Loc = findViewById(R.id.pat_Loc);
//        pat_Phone = findViewById(R.id.doc_num);
//        pat_Age = findViewById(R.id.pat_Age);
//    }
//
//    private void initializeID() {
//        ParseUser Doctor;
//        Doctor = ParseUser.getCurrentUser();
//        pat_Name.setText(Doctor.get("username").toString());
//        pat_Phone.setText(Doctor.get("Mobile_Number").toString());
//        pat_Loc.setText(Doctor.get("Address").toString());
//        pat_Age.setText(Doctor.get("Specialisation").toString());
//    }
//}
    TextView pat_Name, pat_Phone, pat_Loc, pat_Age;
    ImageView pat_Img, pat_ImgBlur;
    String PatientName="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);
        PatientName = getIntent().getStringExtra("Name");
        setTitle("Patient Profile");
        Log.i("here","here");
        PatientName= PatientName.substring(PatientName.lastIndexOf(" ") + 1);
        Log.i("here","here!!!!!!!!!");
        Toast.makeText(PatientProfile.this, "Name is " + PatientName, Toast.LENGTH_SHORT).show();
        Log.i("DoctorName", "Name is " + PatientName);
        linkLayoutFeatures();
        if (PatientName.equals(ParseUser.getCurrentUser().get("username").toString()))
            initializeID();
        else
        getInformation();
//        loadDP();
    }


    private void getInformation() {
        ParseQuery<ParseUser> query = ParseUser.getQuery();
        query.whereEqualTo("username", PatientName);
//        query.setLimit(1);

        query.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> objects, ParseException e) {
                if (e == null) {
                    if (objects.size() > 0) {
                        Log.i("User","FOUND!!!!!!!!!!!");
                        for (ParseUser user : objects) {
                            pat_Name.setText(user.get("fullName").toString());
                            pat_Phone.setText("Phone: " + user.get("Mobile_Number").toString());
                            pat_Loc.setText("Address: " + user.get("Address").toString());
                            pat_Age.setText("Age: "+user.get("Age").toString());

                        }
                    }
                } else {
                    e.printStackTrace();
                }
            }
        });

//        query.findInBackground( new FindCallback<ParseUser>() {
//
//            @Override
//            public void done(List<ParseUser> objects, ParseException e) {
//                if (e == null && objects.size()>0) {
//                    for (ParseObject object : objects) {
//
//                    }
//
//                } else {
//                    Log.d("DoctorName", "Error: " + e.getMessage());
//                }
//            }
//        });
//        ParseQuery<ParseUser> query = ParseUser.getQuery();
//        query.whereEqualTo("Specialisation",getIntent().getStringExtra("Type"));
//        Log.i("Type",getIntent().getStringExtra("Type"));
//        query.addAscendingOrder("username");
//
//        query.findInBackground(new FindCallback<ParseUser>() {
//            @Override
//            public void done(List<ParseUser> objects, ParseException e) {
//                if (e == null) {
//                    if (objects.size() > 0) {
//                        for (ParseUser user : objects) {
//                            doctornames.add(user.getUsername());
//                            avatars.add(R.drawable.doctor);
//                            Log.i("Names",user.getUsername());
//
//                        }
//                        recyclerView.setAdapter(adapter);
//
//                    }
//                } else {
//                    e.printStackTrace();
//                }
//            }
//        });
    }

//            @Override
//            public void done(ParseObject arg0, ParseException arg1) {
//
//
//                if (arg1 == null) {
//                    pat_Name.setText(arg0.get("fullName").toString());
//                    pat_Phone.setText("Phone: " + arg0.get("Mobile_Number").toString());
//                    pat_Loc.setText("Address: " + arg0.get("Address").toString());
//                    pat_Age.setText(arg0.get("Specialisation").toString());
//
//                } else {
//                    Log.d("DoctorName", "Error: " + arg1.getMessage());
//                }
//            }
//        ParseObject Doctor = new ParseObject("User").getParseUser(PatientName);
//        pat_Name.setText(Doctor.get("username").toString());
//        pat_Phone.setText("Phone: " + Doctor.get("Mobile_Number").toString());
//        pat_Loc.setText("Address: " + Doctor.get("Address").toString());
//        pat_Age.setText(Doctor.get("Specialisation").toString());





    private void linkLayoutFeatures() {
        pat_Name = findViewById(R.id.pat_name);
        pat_Img = findViewById(R.id.pat_img);
        pat_ImgBlur = findViewById(R.id.pat_imgBlur);
        pat_Loc = findViewById(R.id.pat_loc);
        pat_Phone = findViewById(R.id.pat_num);
        pat_Age = findViewById(R.id.pat_age);
    }

    @SuppressLint("SetTextI18n")
    private void initializeID() {
        ParseUser Doctor;
        Doctor = ParseUser.getCurrentUser();
        pat_Name.setText(Doctor.get("username").toString());
        pat_Phone.setText("Phone: " + Doctor.get("Mobile_Number").toString());
        pat_Loc.setText("Address: " + Doctor.get("Address").toString());
        pat_Age.setText("Age:"+Doctor.get("Age").toString());
    }

//    public void loadDP() {
//        ParseUser currentUser = ParseUser.getCurrentUser();
//        ParseFile profileImage = currentUser.getParseFile("DP");
//        profileImage.getDataInBackground(new GetDataCallback() {
//            public void done(byte[] data, ParseException e) {
//                if (e == null) {
//                    // data has the bytes for the resume
//                    Bitmap profile_image_bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
//                    pat_Img.setImageBitmap(profile_image_bitmap);
//                    pat_ImgBlur.setImageBitmap(profile_image_bitmap);
//                } else {
//                    // something went wrong
//                    Log.i("loadDP", "Problem Encountered");
//                }
//            }
//        });
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.profile_edit_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.editProfile) {
            Log.i("user:",ParseUser.getCurrentUser().toString());
            if (ParseUser.getCurrentUser().get("patientOrDoctor").toString().equals("patient")) {
                Intent intent = new Intent(getApplicationContext(), PatientProfileEditingActivity.class);
                startActivity(intent);
            } else if (ParseUser.getCurrentUser().get("patientOrDoctor").toString().equals("doctor")) {
                Intent intent = new Intent(getApplicationContext(), DoctorProfileEditActivity.class);
                startActivity(intent);
            }
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    }


    public void editProfile(View view) {
        Log.i("user:",ParseUser.getCurrentUser().toString());
        if (ParseUser.getCurrentUser().get("patientOrDoctor").toString().equals("patient")) {
            Intent intent = new Intent(getApplicationContext(), PatientProfileEditingActivity.class);
            startActivity(intent);
        } else if (ParseUser.getCurrentUser().get("patientOrDoctor").toString().equals("doctor")) {
            Intent intent = new Intent(getApplicationContext(), DoctorProfileEditActivity.class);
            startActivity(intent);
        }
    }
}