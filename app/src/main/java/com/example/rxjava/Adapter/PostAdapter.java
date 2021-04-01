package com.example.rxjava.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjava.Model.List_Users;
import com.example.rxjava.Model.Post;
import com.example.rxjava.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    Context context;
    List<Post> data;

    public PostAdapter(Context context, List<Post> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_posts,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //less code
        Post post = data.get(position);

        Picasso.with(context).load(data.get(position).getLink_img_profile()).into(holder.img_profile);
        Picasso.with(context).load(data.get(position).getLink_img_post()).into(holder.img_post);



        holder.tv_name.setText(data.get(position).getName());
        holder.tv_location.setText(data.get(position).getLocation());
        holder.tv_description.setText(data.get(position).getDescription());


        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String Favorite = data.get(position).getFavorite();
        holder.tv_like.setText(decimalFormat.format(Integer.valueOf(Favorite)));
        String Comment  = data.get(position).getComments();
        holder.tv_comment.setText(decimalFormat.format(Integer.valueOf(Comment)));
        //holder.tv_comment.setText(" + "+decimalFormat.format(Integer.valueOf(Comment)));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_profile,img_post;
        TextView tv_name,tv_location,tv_description,tv_comment,tv_like;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img_post = itemView.findViewById(R.id.iv_main_post);
            img_profile = itemView.findViewById(R.id.cIV_main_profile);
            tv_name = itemView.findViewById(R.id.tv_main_name);
            tv_location = itemView.findViewById(R.id.tv_main_location);
            tv_description = itemView.findViewById(R.id.tv_main_description);
            tv_comment = itemView.findViewById(R.id.tv_main_comment);
            tv_like = itemView.findViewById(R.id.tv_main_like);
        }
    }
}
