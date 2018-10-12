package org.salary.model.viewmodel;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;

import org.salary.R;
import org.salary.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserHolder>{

    List<User> data = new ArrayList<>();

    public ListUserAdapter(List<User> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ListUserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View item = inflater.inflate(R.layout.item_user,viewGroup,false);
        return new ListUserHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ListUserHolder listUserHolder, int postion) {
        User user = data.get(postion);
        listUserHolder.tvCode.setText(user.getCode());
        listUserHolder.tvName.setText(user.getName());
        listUserHolder.imgView.setImageResource(user.getIdResImg());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
