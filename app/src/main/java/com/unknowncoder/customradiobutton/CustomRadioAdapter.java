package com.unknowncoder.customradiobutton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unknowncoder.RadioModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomRadioAdapter extends RecyclerView.Adapter<CustomRadioAdapter.ViewHolder> {
    ArrayList<RadioModel> arrayList;
    Context context;
    public int mLastSelectedItem = -1;

    public CustomRadioAdapter(ArrayList<RadioModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.radio_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.radioButton.setChecked(mLastSelectedItem == position);
        holder.radioButton.setText(arrayList.get(position).getTitle());
        holder.radioButton.setChecked(mLastSelectedItem == position);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        RadioButton radioButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            radioButton=itemView.findViewById(R.id.radio);

            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mLastSelectedItem = getAdapterPosition();
                    Toast.makeText(itemView.getContext(),arrayList.get(mLastSelectedItem).getTitle() , Toast.LENGTH_SHORT).show();
                    notifyDataSetChanged();
                }
            });

        }
    }
}
