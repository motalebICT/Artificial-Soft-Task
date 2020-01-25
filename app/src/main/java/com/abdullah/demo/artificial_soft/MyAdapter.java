package com.abdullah.demo.artificial_soft;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.abdullah.demo.artificial_soft.model.ModelData;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter implements SelectedItem {

    private Context context;
    private List<ModelData> modelDataList;

    public MyAdapter(Context context, List<ModelData> list){
        this.context = context;
        this.modelDataList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;
        final ModelData modelData = modelDataList.get(position);
        myViewHolder.setUserId(modelData.getId());
        myViewHolder.setUserName(modelData.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedModelData(modelData);
                Toast.makeText(context,"Data : "+modelData.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return modelDataList.size();
    }



    @Override
    public void selectedModelData(ModelData modelData) {

        Intent intent = new Intent(context, DataViewerActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtra("id", modelData.getId());
        intent.putExtra("name", modelData.getName());
        intent.putExtra("User", modelData.getUser());
        intent.putExtra("who", modelData.getWho());
        intent.putExtra("image", modelData.getImage());
        context.startActivity(intent);

    }


    private class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView id, name;


        public MyViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.userId);
            name = (TextView) itemView.findViewById(R.id.userName);
        }

        public void setUserId(String uid){
            id.setText("User ID : "+uid);
        }

        public void setUserName(String user_name){
            name.setText("Name : "+user_name);
        }

    }
}
