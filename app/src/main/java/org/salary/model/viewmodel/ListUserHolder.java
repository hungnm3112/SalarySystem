package org.salary.model.viewmodel;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import org.salary.R;
public class ListUserHolder extends RecyclerView.ViewHolder {
    SimpleDraweeView imgView ;
    TextView tvName ;
    TextView tvCode;
    public ListUserHolder(@NonNull View itemView) {
        super(itemView);
        imgView = itemView.findViewById(R.id.imgUser);
        tvName = itemView.findViewById(R.id.tvName);
        tvCode = itemView.findViewById(R.id.tvCode);
    }
}
