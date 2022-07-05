package com.example.android_assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    private final RecyclerViewinterface recyclerViewinterface;
    private List<ModelClass> userList;
    public  Adapter(List<ModelClass>userList,RecyclerViewinterface recyclerViewinterface){this.userList=userList;this.recyclerViewinterface=recyclerViewinterface;}
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
      return new ViewHolder(view,recyclerViewinterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
    int resource=userList.get(position).getImageview2();
    String name =userList.get(position).getTextview1();
    String msg=userList.get(position).getTextview3();
    String time=userList.get(position).getTextview2();
    String line=userList.get(position).getDivider();
    holder.setData(resource,name,msg,time,line);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
        private TextView divider;

        public ViewHolder(@NonNull View itemView,RecyclerViewinterface recyclerViewinterface) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageview2);
            textView1=itemView.findViewById(R.id.textview);
            textView2=itemView.findViewById(R.id.textview2);
            textView3=itemView.findViewById(R.id.textview3);

            divider=itemView.findViewById(R.id.textview4);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewinterface!=null){
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            recyclerViewinterface.onItemClick(pos);
                        }

                    }
                }
            });
        }

        public void setData(int resource, String name, String msg, String time, String line) {
            imageView.setImageResource(resource);
            textView1.setText(name);
            textView2.setText(msg);
            textView3.setText(time);
            divider.setText(line);
        }
    }
}
