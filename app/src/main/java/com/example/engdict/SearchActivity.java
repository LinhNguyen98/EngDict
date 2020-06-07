package com.example.engdict;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SearchActivity extends AppCompatActivity {

    EditText etxtTimkiem;
    Button btnTim;
    TextView txtKetqua;


/*    Cursor curRestaurant = null;
    RestaurantAdapter adapter = null;
    RestaurantHelper helper = null;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);


        etxtTimkiem = (EditText) findViewById( R.id.etxtTimkiem);
        btnTim = (Button) findViewById(R.id.btnTim);
        txtKetqua = (TextView) findViewById(R.id.txtKetqua);
        btnTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(etxtTimkiem.getText().toString()))
                {
                    Toast.makeText(SearchActivity.this , "Không được để từ khóa trống",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    DatabaseReference mRef = FirebaseDatabase.getInstance().getReference("meaning");
                    mRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String keyword = etxtTimkiem.getText().toString();
                            if(dataSnapshot.child(keyword).exists())
                            {
                                txtKetqua.setText(dataSnapshot.child(keyword).getValue().toString());
                            }else
                            {
                                Toast.makeText(SearchActivity.this, "Không tìm thấy kết quả", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });


    }



}

