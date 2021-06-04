package com.example.databaselokal.view;

import android.os.AsyncTask;
import android.util.Log;
import com.example.databaselokal.entity. AppDatabase;
import com.example.databaselokal.entity. DataDesa;
import java.util.List;
public class MainPresenter implements MainContact.presenter {
    private MainContact.view view;

    public MainPresenter(MainContact.view view) {
        this.view = view;
    }

    class InsertData extends AsyncTask<Void, Void, Long> {
        private AppDatabase appDatabase;
        private DataDesa dataDesa;

        public InsertData(AppDatabase appDatabase, DataDesa dataDesa) {
            this.appDatabase = appDatabase;
            this.dataDesa = dataDesa;
        }

        @Override
        protected Long doInBackground(Void... voids) {
            return appDatabase.dao().insertData(dataDesa);
        }

        protected void onPostExecute(Long along) {
            super.onPostExecute(along);
            view.successAdd();
        }
    }
        @Override
        public void insertData(String nama, String alamat, int jumlah, AppDatabase database) {
            final DataDesa dataDesa = new DataDesa();
            dataDesa.setName(nama);
            dataDesa.setAddress(alamat);
            dataDesa.setPenduduk(jumlah);
            new InsertData(database, dataDesa).execute();
        }

        @Override
        public void readData(AppDatabase database) {
            List<DataDesa> list;
            list database.dao().getData();
            view.getData(list);
        }

        class EditData extends AsyncTask<Void, Void, Integer> {
            private AppDatabase appDatabase;
            private DataDesa dataDesa;

            public EditData(AppDatabase appDatabase, DataDesa dataDesa) {
                this.appDatabase = appDatabase;
                this.dataDesa = dataDesa;
            }

            @Override
            protected Integer doInBackground(Void... voids) {
                return appDatabase.dao().updateData(dataDesa);
            }

            protected void onPostExecute(Integer integer) {
                super.onPostExecute(integer);
                Log.d("integer db", "onPostExecute " + integer);
                view.successAdd();
            }
        }
    @Override
        public void editData(String nama, String alamat, int jumlah, int id, AppDatabase database) {
            final DataDesa dataDesa = new DataDesa();
            dataDesa.setName(nama);
            dataDesa.setAddress (alamat);
            dataDesa.setPenduduk (jumlah); dataDesa.setId(id);
            new EditData(database, dataDesa).execute();
        }
        class DeleteData extends AsyncTask<Void, Void, Long> {
            private AppDatabase appDatabase;
            private DataDesa dataDesa;
            public DeleteData(AppDatabase appDatabase, DataDesa dataDesa) {
                this.appDatabase = appDatabase;
                this.dataDesa = dataDesa;
            }
            @Override
            protected Long doInBackground (Void...voids){
                appDatabase.dao().deleteData(dataDesa);
                return null;
            }
            protected void onPostExecute (Long along){
                super.onPostExecute(along);
                view.successDelete();
            }
        }
            @Override
            public void deleteData (DataDesa dataDesa, AppDatabase database){
                new DeleteData(database, dataDesa).execute();
            }
        }