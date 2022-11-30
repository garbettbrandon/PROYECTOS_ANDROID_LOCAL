package com.example.agenda;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.agenda.db.AppDataBase;
import com.example.agenda.db.User;
import com.example.agenda.db.UserDao;

import org.jetbrains.annotations.NotNull;

import java.util.List;
public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {

    private Context context;
    private List<User> userList;
    public UserListAdapter(Context context) {
        this.context = context;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    @Override
    public UserListAdapter.MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_element, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull UserListAdapter.MyViewHolder holder, int position) {
        holder.tvFirstName.setText(this.userList.get(position).firstName);
        holder.tvLastName.setText(this.userList.get(position).lastName);
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataBase db = Room.databaseBuilder(holder.tvFirstName.getContext(),
                        AppDataBase.class, "DB_NAME").allowMainThreadQueries().build();
                UserDao userDao = db.userDao();
                // this is to delete the record from room database
                userDao.deleteById(userList.get(position).getUid());
                // this is to delete the record from Array List which is the source of recview data
                userList.remove(position);
                //update the fresh list of ArrayList data to recview
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return  this.userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvFirstName, tvLastName;
        ImageButton btnDelete, btnCall, btnEdit;

        public MyViewHolder(View view) {
            super(view);
            tvFirstName = view.findViewById(R.id.nameTv);
            tvLastName = view.findViewById(R.id.phoneTv);
            btnCall = view.findViewById(R.id.callbtn);
            btnEdit = view.findViewById(R.id.editbtn);
            btnDelete = view.findViewById(R.id.delbtn);
        }
    }
}
