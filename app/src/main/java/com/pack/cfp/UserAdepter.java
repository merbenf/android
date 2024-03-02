package com.pack.cfp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;



import java.util.ArrayList;
import java.util.List;

public class UserAdepter extends ArrayAdapter<Userhelperclass> {
     private Context context;
     private ArrayList<Userhelperclass> list_user;

    public UserAdepter(@NonNull Context context, int res, ArrayList<Userhelperclass> list_User) {
        super(context,0,list_User);
        this.context = context;
        this.list_user = list_User;
    }

    @Override
    public int getCount() {
        return list_user.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, parent, false);
        }
            TextView nom_text =(TextView) convertView.findViewById(R.id.nom);
            TextView prenom_text =(TextView) convertView.findViewById(R.id.prenom);
            nom_text.setText(list_user.get(position).getNom());
            prenom_text.setText(list_user.get(position).getPrenom());

        return convertView ;
    }


    public void Update(ArrayList<Userhelperclass> list_search) {
       list_user = new ArrayList<>();
       list_user.addAll(list_search);
       notifyDataSetChanged();
    }

}
