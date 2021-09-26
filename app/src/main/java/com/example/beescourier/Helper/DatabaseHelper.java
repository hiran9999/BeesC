package com.example.beescourier.Helper;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.telephony.mbms.StreamingService;
import android.telephony.mbms.StreamingServiceInfo;
import android.widget.Toast;


import com.example.beescourier.MainActivity;
import com.example.beescourier.MainActivity2;
import com.example.beescourier.MainActivity3;
import com.example.beescourier.Table.DatabaseClient;
import com.example.beescourier.Table.Tables;

import java.util.List;

public class DatabaseHelper {

    Context context;

    public DatabaseHelper(Context context) {
        this.context = context;
    }

    public static DatabaseHelper getInstance(Context context) {
        return new DatabaseHelper(context);
    }

    //Insert Data
    public void addNewPickup(String pick_date, String pick_address) {
        class NewPickup extends AsyncTask<Void, Void, Tables> {


            @Override
            protected Tables doInBackground(Void... voids) {
                Tables tables = new Tables();
                tables.setPick_date(pick_date);
                tables.setPick_address(pick_address);

                DatabaseClient.getInstance(context)
                        .getPickDatabase()
                        .pickDAO()
                        .insertData(tables);

                return tables;
            }

            @Override
            protected void onPostExecute(Tables tables) {
                super.onPostExecute(tables);
                if (tables != null) {
                    Toast.makeText(context, tables.getPick_date() + "\n" + tables.getPick_address(), Toast.LENGTH_SHORT).show();
                }
            }
        }
        NewPickup newPickup = new NewPickup();
        newPickup.execute();
    }

    //show all data from Tables
    public void getAllPickupsData() {
        class AllPickups extends AsyncTask<Void, Void, List<Tables>> {
            @Override
            protected List<Tables> doInBackground(Void... voids) {
                List<Tables> list = DatabaseClient.getInstance(context)
                        .getPickDatabase()
                        .pickDAO()
                        .selectAll();

                return list;
            }

            @Override
            protected void onPostExecute(List<Tables> tables) {
                super.onPostExecute(tables);
                if (tables != null && tables.size() > 0) {
                    ((MainActivity3) context).setRecyclerView(tables);
                }
            }
        }
        AllPickups allPickups = new AllPickups();
        allPickups.execute();
    }

    //Update Data
    public void updateData(Tables table, String pick_date, String pick_address) {
        class UpdateStudentData extends AsyncTask<Void, Void, Tables> {
            @Override
            protected Tables doInBackground(Void... voids) {
                table.setPick_date(pick_date);
                table.setPick_address(pick_address);

                DatabaseClient.getInstance(context)
                        .getPickDatabase()
                        .pickDAO()
                        .updateData(table);
                return table;

            }

            @Override
            protected void onPostExecute(Tables tables) {
                super.onPostExecute(tables);
                if (table != null) {
                    Toast.makeText(context, "Updated" + "\n" + table.getPick_date() + "\n" +
                            table.getPick_date(), Toast.LENGTH_SHORT).show();

                }
            }
        }
        UpdateStudentData updateStudentData = new UpdateStudentData();
        updateStudentData.execute();
    }

    //Delete Data
    public void deleteData(Tables tables){
        class DeleteData extends AsyncTask<Void,Void,Void>{

            @Override
            protected Void doInBackground(Void... voids) {
                DatabaseClient.getInstance(context)
                        .getPickDatabase()
                        .pickDAO()
                        .deleteData(tables);
                return null;
            }

        }

        DeleteData deleteData = new DeleteData();
        deleteData.execute();
    }
}