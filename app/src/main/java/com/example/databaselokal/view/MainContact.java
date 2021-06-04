package com.example.databaselokal.view;

import android.view.View;
import com.example.databaselokal.entity. AppDatabase; import com.example.databaselokal.entity.DataDesa;
import java.util.List;

public interface MainContact {

    interface view extends View.OnClickListener{
        void id successAdd();
    void successDelete();
    void resetForm();
    void getData(List<DataDesa> list);
    void editData(DataDesa item);
    void deleteData (DataDesa item);

}

interface presenter {
    void insertData(String nama, String alamat, int jumlah, AppDatabase database);

    void readData(AppDatabase database);

    void editData(String nama, String alamat, int jumlah, int id, AppDatabase database);

    void deleteData(DataDesa dataKampus, AppDatabase database);
}
}