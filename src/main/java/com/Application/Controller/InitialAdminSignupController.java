package com.Application.Controller;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.Application.Model.database.helper.DatabaseDriverAndroidHelper;
import com.Application.Model.exceptions.DatabaseInsertException;
import com.Application.View.InitialAdminSignupView;
import com.Application.View.InitialEmployeeSignupView;

import java.math.BigDecimal;

public class InitialAdminSignupController extends SignUpController implements View.OnClickListener{
    InitialAdminSignupView view;
    Context appContext;

    public InitialAdminSignupController(Context context){
        appContext = context;
        view = (InitialAdminSignupView) appContext;
    }

    @Override
    public void onClick(View v) {
        try {
            // admin has clicked sign up
            DatabaseDriverAndroidHelper mydb = new DatabaseDriverAndroidHelper(view);
            dbSetup(mydb);
            int userId = createUser(view, mydb,1);

            Toast.makeText(view,"User with id " + userId + " created.",Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(appContext, InitialEmployeeSignupView.class);
            appContext.startActivity(intent);
        }catch(DatabaseInsertException | NumberFormatException e){
            Toast.makeText(view,"Please ensure that all fields are completed.",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void dbSetup(DatabaseDriverAndroidHelper mydb) throws DatabaseInsertException {
        appContext.deleteDatabase("inventorymgmt.db");

        mydb.insertRoleH("ADMIN");
        mydb.insertRoleH("EMPLOYEE");
        mydb.insertRoleH("CUSTOMER");

        mydb.insertItemH("SKATES", new BigDecimal("9.00").setScale(2));
        mydb.insertItemH("RUNNING_SHOES", new BigDecimal("15.00").setScale(2));
        mydb.insertItemH("PROTEIN_BAR", new BigDecimal("5.00").setScale(2));
        mydb.insertItemH("HOCKEY_STICK", new BigDecimal("10.00").setScale(2));
        mydb.insertItemH("FISHING_ROD", new BigDecimal("12.00").setScale(2));
    }


}
