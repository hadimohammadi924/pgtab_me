package com.example.pgtabme.Adapter;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pgtabme.Activity.DetailActivity;
import com.example.pgtabme.Model.DataModel;
import com.example.pgtabme.R;


import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myViewHolder> {
    private  static String EXTRA_code="code";
    private  static String EXTRA_TITLE="title";
    private  static String EXTRA_DESCRIPTION="description";
    private  static String EXTRA_IMAGE_URL="image_url";
    private  static String EXTRA_CATEGORY="category";
    ArrayList<DataModel> dataModels = new ArrayList<>();
     Context context;


    public RecyclerAdapter(ArrayList<DataModel> dataModels,Context context) {
        this.dataModels=dataModels;
        this.context=context;
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        if (view==null) {
             view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview, viewGroup, false);
        }
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int i) {
     DataModel dataModel=dataModels.get(i);
     holder.title.setText(dataModel.getTitle());

    //  final DataModel dataModel = dataModels.get(i);

        holder.title.setText(dataModel.getTitle());
      Glide.with(context)
               .load(dataModel.getImage_url())
               .into(holder.imageView);

        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {

               String code=dataModel.getCode();
               String title=dataModel.getTitle();
               String description=dataModel.getDescription();
               String image_url=dataModel.getImage_url();
                String category=dataModel.getCategory();

           Intent intent=new Intent(context, DetailActivity.class);
               intent.putExtra(EXTRA_code,code);
               intent.putExtra(EXTRA_TITLE,title);
                intent.putExtra(EXTRA_DESCRIPTION,description);
                intent.putExtra(EXTRA_IMAGE_URL,image_url);
               intent.putExtra(EXTRA_CATEGORY,category);

                context.startActivity(intent);




            }
        });

    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title;
        TextView title2;
        CardView root;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

           imageView = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            root = itemView.findViewById(R.id.root);
           // title2 = itemView.findViewById(R.id.title2);


        }
    }
    public void UpdateList(ArrayList<DataModel> newList) {
        dataModels = new ArrayList<>();
        dataModels.addAll(newList);
        notifyDataSetChanged();

    }
}





//
//
//    @NonNull
//    @Override
//    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//
//        View view = null;
//        if (view == null) {
//            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview,viewGroup, false);
//        }
//
//        return new myViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull myViewHolder holder, int i) {
//
//
//        final DataModel dataModel = dataModels.get(i);
//
//       holder.title.setText(dataModel.getTitle());
//        Glide.with(context)
//                .load(dataModel.getImage_url())
//                .into(holder.imageView);
//
//
//        holder.root.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String code=dataModel.getCode();
//                String title=dataModel.getTitle();
//                String description=dataModel.getDescription();
//                String image_url=dataModel.getImage_url();
//                String category=dataModel.getCategory();
//
////                Intent intent=new Intent(context, DetailActivity.class);
////                intent.putExtra(EXTRA_code,code);
////                intent.putExtra(EXTRA_TITLE,title);
////                intent.putExtra(EXTRA_DESCRIPTION,description);
////                intent.putExtra(EXTRA_IMAGE_URL,image_url);
////                intent.putExtra(EXTRA_CATEGORY,category);
//
////                context.startActivity(intent);
//
//
//
//
//            }
//        });
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return dataModels.size();
//    }
//
//    public class myViewHolder extends RecyclerView.ViewHolder {
//
//
//        ImageView imageView;
//        TextView title;
//        TextView title2;
//        CardView root;
//
//        public myViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            imageView = itemView.findViewById(R.id.image);
//            title = itemView.findViewById(R.id.title);
//            root = itemView.findViewById(R.id.root);
//            title2 = itemView.findViewById(R.id.title2);
//
//        }
//    }
//

//
//  //  }
//}
