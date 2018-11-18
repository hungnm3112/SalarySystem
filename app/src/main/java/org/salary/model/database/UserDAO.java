package org.salary.model.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;


import org.salary.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    static final String TABLE_NAME ="User";
    static final String COL_ID="id";
    static final String COL_NAME="name";
    static final String COL_CODE_ID="codeId";
    static final String COL_IMG="image";

    static final String createTable="CREATE TABLE " +
            "IF NOT EXISTS "+TABLE_NAME+"(" +
            "  "+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            "  "+COL_NAME+" TEXT," +
            "  "+COL_CODE_ID+" TEXT," +
            "  "+COL_IMG+" BLOB" +
            ")";

    private Database db = null;
    public UserDAO(Context context){
        db = Database.getInstance(context);
    }

    public long add(User user){
        ContentValues values = new ContentValues();
        values.put(this.COL_NAME,user.getName());
        values.put(this.COL_CODE_ID,user.getCode());
        values.put(this.COL_IMG,user.getIdResImg());

        long rowId = db.getWritableDatabase().insertOrThrow(TABLE_NAME,null,values);
        db.close();
        return  rowId;
    }

    public void updateById(User user){
        ContentValues values = new ContentValues();
        values.put(this.COL_NAME,user.getName());
        values.put(this.COL_CODE_ID,user.getCode());
        values.put(this.COL_IMG,user.getIdResImg());

        db.getWritableDatabase().update(TABLE_NAME,values,COL_ID+"=?",new String[]{String.valueOf(user.getId())});
        db.close();
    }

    public void delete(int id){
        ContentValues values = new ContentValues();
        values.put(UserDAO.COL_ID, id);
        db.getWritableDatabase().delete(UserDAO.TABLE_NAME, COL_ID+"=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public List<User> getAll(){
        String query = "SELECT * FROM " + UserDAO.TABLE_NAME;
        // query to database
        Cursor cursor = db.getReadableDatabase().rawQuery(query, null);
        List<User> listUser =  new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(cursor.getInt(0));
                user.setName(cursor.getString(1));
                user.setCode(cursor.getString(2));
                user.setImg(cursor.getBlob(3));
                listUser.add(user);
            } while (cursor.moveToNext());
        }
        db.close();
        return listUser;
    }

    public User getByID(int id){
        String query = "SELECT * FROM " + UserDAO.TABLE_NAME+" WHERE "+UserDAO.COL_ID+"=?";
        Cursor cursor = db.getReadableDatabase().rawQuery(query, null);
        if(cursor.moveToFirst()){
            User user = new User();
            user.setId(cursor.getInt(0));
            user.setName(cursor.getString(1));
            user.setCode(cursor.getString(2));
            user.setImg(cursor.getBlob(3));

            db.close();
            return user;
        }
        db.close();
        return null;
    }
}

