package com.parse.starter.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.parse.starter.R;

import java.util.ArrayList;


public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    static ArrayList<String > messages;
    ArrayList<Bitmap> images;
    LayoutInflater layoutInflater;
    public MessageAdapter(Context context, ArrayList<String> spcl){//, ArrayList<Bitmap> img){
//        this.images=img;
        this.messages=spcl;
        this.layoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_messages_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(!messages.get(position).equals("null")) {

            Log.i("Text", "SET!!");
            if(messages.get(position).contains("swayam>")){
                holder.text.setText("\t\t"+messages.get(position).substring(messages.get(position).indexOf("swayam>")+7));
                holder.text2.setText("\t\t"+messages.get(position));
                holder.text2.setAlpha(0);
                holder.text.setAlpha(1);

            }
            else{
                holder.text.setText("\t\t"+messages.get(position));
                holder.text2.setText("\t\t"+messages.get(position));
                holder.text2.setAlpha(1);
                holder.text.setAlpha(0);
            }
        }
//        if(images.get(position)!=null) {
//            holder.icon.setImageBitmap(images.get(position));
//            Log.i("Image", "SET!!!!!!!");
//        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView text;
        TextView text2;
        //     ImageView icon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //         icon=itemView.findViewById(R.id.message_image);
            text = itemView.findViewById(R.id.textViewMessage);
            text2 = itemView.findViewById(R.id.textViewMessage2);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(messages.get(getAdapterPosition()).toString().equals("Appointments")){
//                        Intent intent = new Intent(view.getContext(),AppointmentDisplayForPatients.class);
//                        view.getContext().startActivity(intent);
//                    }else {
//                        Intent intent = new Intent(view.getContext(), DoctorsList.class);
//                        intent.putExtra("Type", messages.get(getAdapterPosition()));
//                        view.getContext().startActivity(intent);
//                    }
//                }
//            });

        }
    }
}