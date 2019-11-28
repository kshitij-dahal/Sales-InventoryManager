package com.Application.Controller;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.Application.Model.database.DatabaseDriverAndroid;
import com.Application.Model.database.helper.DatabaseDriverAndroidHelper;
import com.Application.Model.database.helper.DatabaseInsertHelper;
import com.Application.Model.store.SalesApplication;
import com.Application.Model.users.Admin;
import com.Application.Model.users.User;
import com.Application.View.Employee.MainActivity;
import com.Application.View.InitialAdminSignupView;
import com.Application.View.InitialEmployeeSignupView;
import com.example.Application.R;

import java.util.List;

public class InitialAdminSignupController implements View.OnClickListener{
    InitialAdminSignupView view;
    Context appContext;

    public InitialAdminSignupController(Context context){
        appContext = context;
        view = (InitialAdminSignupView) appContext;
    }

    @Override
    public void onClick(View v) {
        // admin has clicked sign up
        try {


            Log.d("hehe","no wa" +
                    "y");
            DatabaseDriverAndroidHelper mydb = new DatabaseDriverAndroidHelper(view);
            appContext.deleteDatabase("inventorymgmt.db");
           mydb.insertRoleH("ADMIN");
            mydb.insertRoleH("EMPLOYEE");
           mydb.insertRoleH("CUSTOMER");


           // SalesApplication.insertIntoRolesTable();
           // SalesApplication.initializeRolesToId();
          //  SalesApplication.insertIntoItemsTable(); // inserts items into items table with random prices
            Log.d("hehe","no i made ittt");
            EditText usernameEditText = view.findViewById(R.id.usernameEditText);
            EditText userAgeEditText = view.findViewById(R.id.userAgeEditText);
            EditText userAddressEditText = view.findViewById(R.id.userAddressEditText);
            EditText passwordEditText = view.findViewById(R.id.passwordEditText);

            String name = usernameEditText.getText().toString();
            int age = Integer.parseInt(userAgeEditText.getText().toString());
            String address = userAddressEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            Log.d("hehe","dsds");

           int userId = Math.toIntExact(mydb.insertNewUserH(name, age, address, password));
         mydb.insertUserRoleH(userId, 1);



            Log.d("hehe","wat the hell");

            Toast.makeText(view,"success!!!  " + userId,Toast.LENGTH_SHORT).show();

         //  User users = mydb.getUserDetailsH(1);
           Log.d("hehehe","ok abt to go to employee");

            Intent intent = new Intent(appContext, InitialEmployeeSignupView.class);
            appContext.startActivity(intent);
        }catch(Exception e){
            Toast.makeText(view,"oh hehe i messed up",Toast.LENGTH_SHORT).show();
            Log.d("hehe","naanannananwat the hell");
            e.printStackTrace();
        }
    }


}
