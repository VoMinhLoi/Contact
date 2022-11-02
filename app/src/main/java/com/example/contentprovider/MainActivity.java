package com.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Item> itemList;
    ListView contactLVAX;
    ItemAdapter itemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactLVAX = (ListView) findViewById(R.id.contactLV);
        itemList = new ArrayList<>();
        itemList.add(new Item("Hoan","1"));
        itemList.add(new Item("Long","2"));
        itemList.add(new Item("Dat","3"));
        itemList.add(new Item("Cap","4"));
        itemList.add(new Item("Van","5"));
        itemAdapter = new ItemAdapter(MainActivity.this, itemList);
        contactLVAX.setAdapter(itemAdapter);
    }
    public void btnGetContactPressed(View v){
        getPhoneContacts();
    }
    private void getPhoneContacts(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_CONTACTS},0);
        }
        ContentResolver contentResolver = getContentResolver();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = contentResolver.query(uri, null, null, null, null);
        Log.i("CONTACT_PROVIDER_DEMO", "TOTAL # of Contacts ::: "+ Integer.toString(cursor.getCount()));
        itemList.clear();
        if (cursor.getCount() > 0)
            while (cursor.moveToNext()){
                @SuppressLint("Range") String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                @SuppressLint("Range") String contactNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                Log.i("CONTACT_PROVIDER_DEMO", "Contact Name ::: " + contactName + " Phone # ::: " + contactNumber);
//                String tenCotPhone = ContactsContract.Contacts.HAS_PHONE_NUMBER;  = 1
                String tenCotName = ContactsContract.Contacts.DISPLAY_NAME;
//              String tenCotName = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;
                String tenCotPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
                int viTriCotName = cursor.getColumnIndex(tenCotName);
                int viTriCotPhone = cursor.getColumnIndex(tenCotPhone);
                String name = cursor.getString(viTriCotName);
                String phone = cursor.getString(viTriCotPhone);
                Item item = new Item(name, phone);
                itemList.add(item);
                itemAdapter.notifyDataSetChanged();
            }
    }
}