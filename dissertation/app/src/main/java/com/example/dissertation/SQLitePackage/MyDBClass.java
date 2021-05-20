package com.example.dissertation.SQLitePackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dissertation.GettersSetters.ListViewModel;
import com.example.dissertation.GettersSetters.ModelClass;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MyDBClass extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "dissertation_database.db";
    private static final int DATABASE_VERSION = 1;
    private Context context;
    private String question_table[] = new String[] {"SELECT * FROM test1"};

    private String Db_Query_Score[] = new String[] {"SELECT * FROM score"};

    private String Db_Query_Sign[] = new String[] {"SELECT * FROM sign_tab1",
                                                   "SELECT * FROM sign_tab2",
                                                   "SELECT * FROM sign_tab3",
                                                   "SELECT * FROM sign_tab4",
                                                   "SELECT * FROM sign_tab5",
                                                   "SELECT * FROM sign_tab6",
                                                   "SELECT * FROM sign_tab7",
                                                   "SELECT * FROM sign_tab8"};

    private String Db_Query_Law[] = new String[] {"SELECT * FROM law_tab1",
                                                  "SELECT * FROM law_tab2",
                                                  "SELECT * FROM law_tab3",
                                                  "SELECT * FROM law_tab4",
                                                  "SELECT * FROM law_tab5"};
    public MyDBClass(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
        this.context = context;

    }
    public void saveRecords(int val){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("score",val);
        values.put("timestamp",getDateTime());
        sqLiteDatabase.insert("score", null, values);
        sqLiteDatabase.close(); // Closing database connection
    }
    public ArrayList<ListViewModel> getAchiviement(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<ListViewModel> listViewModels = new ArrayList<>();
        String query = "SELECT * FROM score";
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        if (cursor.getCount()!= 0){
            while (cursor.moveToNext()){
                String counter = cursor.getString(0);
                String score = cursor.getString(1);
                String date = cursor.getString(2);
                ListViewModel listViewModel = new ListViewModel(counter,score,date);
                listViewModels.add(listViewModel);
            }
        }return listViewModels;
    }
    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
    public ArrayList<ModelClass> getData_Test(int index){
    SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
    ArrayList<ModelClass> objModelClass = new ArrayList<>();
    if (sqLiteDatabase != null){
        Cursor cursor = sqLiteDatabase.rawQuery(question_table[index],null);
        if (cursor.getCount() != 0 ) {
            while (cursor.moveToNext()){
                String QuestionView = cursor.getString(1);
                //byte[] QuestionImage = cursor.getBlob(2);
                String QuestionImage = cursor.getString(2);
                String Answer_One = cursor.getString(3);
                String Answer_Two = cursor.getString(4);
                String Answer_Three = cursor.getString(5);
                String Answer_Four = cursor.getString(6);
                int Correct_Answer = cursor.getInt(7);
                String Hint = cursor.getString(8);
               // Bitmap bitmap = BitmapFactory.decodeByteArray(QuestionImage,0,QuestionImage.length);
               // objModelClass.add(new ModelClass(QuestionView,bitmap,Answer_One,Answer_Two,Answer_Three,Answer_Four,Correct_Answer));
                objModelClass.add(new ModelClass(QuestionView,QuestionImage,Answer_One,Answer_Two,Answer_Three,Answer_Four,Correct_Answer,Hint));

                //objModelClass.add(new ModelClass(QuestionView,Answer_One,Answer_Two,Answer_Three,Answer_Four,Correct_Answer));
            }
        }
        cursor.close();
    }return objModelClass;
}
    public ArrayList<ModelClass> getData_Study(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<ModelClass> objModelClass = new ArrayList<>();
        if (sqLiteDatabase != null){
            Cursor cursor = sqLiteDatabase.rawQuery(question_table[0],null);
            if (cursor.getCount() != 0 ) {
                while (cursor.moveToNext()){
                    String QuestionView = cursor.getString(1);
                    String QuestionImage = cursor.getString(2);
                    String Answer_One = cursor.getString(3);
                    String Answer_Two = cursor.getString(4);
                    String Answer_Three = cursor.getString(5);
                    String Answer_Four = cursor.getString(6);
                    int Correct_Answer = cursor.getInt(7);
                    objModelClass.add(new ModelClass(QuestionView,QuestionImage,Answer_One,Answer_Two,Answer_Three,Answer_Four,Correct_Answer));
                }
            }
            cursor.close();
        }return objModelClass;
    }
    public ArrayList<ModelClass> getData_SignActivity(int index){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<ModelClass> objModelClass = new ArrayList<>();
        if(sqLiteDatabase != null){
            Cursor cursor = sqLiteDatabase.rawQuery(Db_Query_Sign[index],null);
            try{
                if(cursor.getCount() != 0){
                    while (cursor.moveToNext()){
                        String TextView = cursor.getString(0);
                        String ImagePath = cursor.getString(1);//new
                        //byte[] ImageView = cursor.getBlob(2);
                      // if (ImageView == null){ objModelClass.add(new ModelClass(TextView,null)); }
                        if (ImagePath == null){ objModelClass.add(new ModelClass(TextView,null)); }//new

                        else{
                          //  Bitmap ourImage = BitmapFactory.decodeByteArray(ImageView,0,ImageView.length);
                         //   objModelClass.add(new ModelClass(TextView,ourImage)); }
                            objModelClass.add(new ModelClass(TextView,ImagePath)); }
                    }
                }
            }catch (Exception e){ }
            finally { if ( cursor !=null){ cursor.close(); sqLiteDatabase.close();} }
        }return  objModelClass;
    }
    public ArrayList<ModelClass> getData_LawActivity(int index){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<ModelClass> objModelClass = new ArrayList<>();
        if(sqLiteDatabase != null){
            Cursor cursor = sqLiteDatabase.rawQuery(Db_Query_Law[index],null);
            try{
                if(cursor.getCount() != 0){
                    while (cursor.moveToNext()){
                        String TextView = cursor.getString(0);
                        String ImagePath = cursor.getString(1);//new
                        //byte[] ImageView = cursor.getBlob(2);
                        // if (ImageView == null){ objModelClass.add(new ModelClass(TextView,null)); }
                        if (ImagePath == null){ objModelClass.add(new ModelClass(TextView,null)); }//new

                        else{
                            //  Bitmap ourImage = BitmapFactory.decodeByteArray(ImageView,0,ImageView.length);
                            //   objModelClass.add(new ModelClass(TextView,ourImage)); }
                            objModelClass.add(new ModelClass(TextView,ImagePath)); }
                    }
                }
            }catch (Exception e){ }
            finally { if ( cursor !=null){ cursor.close(); sqLiteDatabase.close();} }
        }return  objModelClass;
    }
    public ArrayList<Integer> getResults(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<Integer> chartModelsArrayList = new ArrayList<>();
        if (sqLiteDatabase != null){
            Cursor cursor = sqLiteDatabase.rawQuery(Db_Query_Score[0],null);
            try{
                if (cursor.getCount() != 0){
                    while (cursor.moveToNext()){
                        int score = cursor.getInt(1);
                        chartModelsArrayList.add(score);
                    }

                }

            }catch (Exception e){

            }finally { if ( cursor !=null){ cursor.close(); sqLiteDatabase.close();} }
        }return  chartModelsArrayList;

    }



}
