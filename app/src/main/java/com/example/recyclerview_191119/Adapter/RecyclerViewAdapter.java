package com.example.recyclerview_191119.Adapter;

import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_191119.MainActivity;
import com.example.recyclerview_191119.Model.SubjectData;
import com.example.recyclerview_191119.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<SubjectData> SubjectList;
    private OnItemClickListener mlistener;
    public interface OnItemClickListener
    {
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mlistener =listener;
    }
    public  RecyclerViewAdapter(Context context, List<SubjectData> subjectList)
    {
        this.context=context;
        SubjectList=subjectList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.detail,parent,false);
        return new ViewHolder(view,mlistener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SubjectData Subject=SubjectList.get(position);

        holder.txtName.setText("Subject Name: "+Subject.getSubject_Name());
        holder.txtID.setText("Course ID: "+Subject.getCourse_ID());



    }

    @Override
    public int getItemCount() {
        return SubjectList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        private TextView txtName,txtID;
        public ImageView deleteimage;



        public ViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            txtName= itemView.findViewById(R.id.txt_SN);
            txtID= itemView.findViewById(R.id.txt_CID);
            deleteimage=itemView.findViewById(R.id.img_del);


            deleteimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null)
                    {
                        int position=getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                        {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {

        }
    }

}

