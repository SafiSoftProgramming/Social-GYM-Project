package net.simplifiedlearning.volleymysqlexample;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.io.IOException;
import java.util.List;

import static com.bumptech.glide.request.RequestOptions.centerCropTransform;
import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by Belal on 10/18/2017.
 */

public class MemberAtGymAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    String ServerURL ;
    String WorkOut_Img_Folder_Name ;
    String WorkOut_Img_Type ;
    private Context mCtx;
    private List<Member> productList;
    DataBaseConnction dataBaseConnction ;



    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView txtv_members_name, txtv_member_enter_time, txtv_workout_one_name, txtv_workout_two_name;
        ImageView imgv_members_profile,imgv_workout_one,imgv_workout_two;

        public ProductViewHolder(View itemView) {
            super(itemView);

            txtv_members_name = itemView.findViewById(R.id.txtv_members_name);
            txtv_member_enter_time = itemView.findViewById(R.id.txtv_member_enter_time);
            txtv_workout_one_name = itemView.findViewById(R.id.txtv_workout_one_name);
            txtv_workout_two_name = itemView.findViewById(R.id.txtv_workout_two_name);
            imgv_members_profile = itemView.findViewById(R.id.imgv_members_profile);
            imgv_workout_one = itemView.findViewById(R.id.imgv_workout_one);
            imgv_workout_two = itemView.findViewById(R.id.imgv_workout_two);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        ImageView imgv_gym_logo ;
        TextView txtv_gym_name;
        TextView txtv_num_of_member_atgym ;


        public HeaderViewHolder(View itemView) {
            super(itemView);

            imgv_gym_logo = itemView.findViewById(R.id.imgv_gym_logo);
            txtv_gym_name = itemView.findViewById(R.id.txtv_gym_name);
            txtv_num_of_member_atgym = itemView.findViewById(R.id.txtv_num_of_member_atgym);

        }
    }

    public MemberAtGymAdapter(Context mCtx, List<Member> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }



    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return -1;
        }
    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ServerURL = mCtx.getResources().getString(R.string.Server_URL);
        WorkOut_Img_Folder_Name = mCtx.getResources().getString(R.string.WorkOut_Img_Folder_Name);
        WorkOut_Img_Type =mCtx.getResources().getString(R.string.WorkOut_Img_Type);


        dataBaseConnction = new DataBaseConnction(getApplicationContext());
        try {
            dataBaseConnction.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            dataBaseConnction.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }




        View view;
        if(viewType == 0){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_at_gym_header, parent, false);
            return new HeaderViewHolder(view);
        }
        else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.members_list, parent, false);
            return new ProductViewHolder(view);
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {



        if(position == 0){

            Glide.with(mCtx)
                    .load(ServerURL+gym_database_logo())
                    .into(((HeaderViewHolder) holder).imgv_gym_logo);

            ((HeaderViewHolder) holder).txtv_gym_name.setText(gym_database_name());
            ((HeaderViewHolder) holder).txtv_num_of_member_atgym.setText(Integer.toString(productList.size())+" member(s) at the gym now");


        }
        else{


                position = position - 1 ;
                Member product = productList.get(position);


                String workout_img_one_name = product.getWorkOutOneName();
                String workout_img_two_name = product.getWorkOutTwoName();

                if (workout_img_one_name.equals("")) {
                    ((ProductViewHolder) holder).txtv_workout_one_name.setVisibility(View.GONE);
                    ((ProductViewHolder) holder).imgv_workout_one.setVisibility(View.GONE);
                } else {
                    Glide.with(mCtx)
                            .load(ServerURL + WorkOut_Img_Folder_Name + workout_img_one_name + WorkOut_Img_Type)
                            .into(((ProductViewHolder) holder).imgv_workout_one);
                    ((ProductViewHolder) holder).txtv_workout_one_name.setVisibility(View.VISIBLE);
                    ((ProductViewHolder) holder).imgv_workout_one.setVisibility(View.VISIBLE);
                }

                if (workout_img_two_name.equals("")) {
                    ((ProductViewHolder) holder).txtv_workout_two_name.setVisibility(View.GONE);
                    ((ProductViewHolder) holder).imgv_workout_two.setVisibility(View.GONE);
                } else {
                    Glide.with(mCtx)
                            .load(ServerURL + WorkOut_Img_Folder_Name + workout_img_two_name + WorkOut_Img_Type)
                            .into(((ProductViewHolder) holder).imgv_workout_two);
                    ((ProductViewHolder) holder).txtv_workout_two_name.setVisibility(View.VISIBLE);
                    ((ProductViewHolder) holder).imgv_workout_two.setVisibility(View.VISIBLE);
                }

                Glide.with(mCtx)
                        .load(ServerURL + product.getMembersPhoto())
                        .apply(centerCropTransform()
                                .placeholder(R.drawable.gymnatiionlogo_squr_defult_err)
                                .error(R.drawable.gymnatiionlogo_squr_defult_err)
                                .priority(Priority.HIGH))
                        .apply(RequestOptions.skipMemoryCacheOf(true))
                        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                        .into(((ProductViewHolder) holder).imgv_members_profile);

                ((ProductViewHolder) holder).txtv_members_name.setText(product.getMembersNmae());
                ((ProductViewHolder) holder).txtv_member_enter_time.setText(product.getEnterMemberTimeDate());
                ((ProductViewHolder) holder).txtv_workout_one_name.setText(String.valueOf(product.getWorkOutOneName()));
                ((ProductViewHolder) holder).txtv_workout_two_name.setText(String.valueOf(product.getWorkOutTwoName()));

            }

    }



    @Override
    public int getItemCount() {
        return productList.size()+1;
    }

    public String gym_database_name(){
        Cursor c = dataBaseConnction.query_user_data("gym_info_local_database",null,null,null,null,null,null);
        c.moveToPosition(0);
        String gym_url = c.getString(1);
        return gym_url ;
    }

    public String gym_database_logo(){
        Cursor c = dataBaseConnction.query_user_data("gym_info_local_database",null,null,null,null,null,null);
        c.moveToPosition(0);
        String gym_url = c.getString(2);
        return gym_url ;
    }




}
