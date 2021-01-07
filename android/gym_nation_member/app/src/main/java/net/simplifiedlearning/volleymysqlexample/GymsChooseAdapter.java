package net.simplifiedlearning.volleymysqlexample;

import android.content.Context;
import android.content.Intent;
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

public class GymsChooseAdapter extends RecyclerView.Adapter<GymsChooseAdapter.GymsViewHolder> {


    private Context mCtx;
    private List<Gyms> gymsList;
    DataBaseConnction dataBaseConnction ;
    String Server_URL ;

    String ServerURL ;
    String Notification_Icon_Folder_Name ;
    String Notification_Icon_Type ;

    public GymsChooseAdapter(Context mCtx, List<Gyms> gymsList) {
        this.mCtx = mCtx;
        this.gymsList = gymsList;
    }

    @Override
    public GymsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.gyms_list, null);
        Server_URL = mCtx.getResources().getString(R.string.Server_URL);
        return new GymsChooseAdapter.GymsViewHolder(view);




    }

    @Override
    public void onBindViewHolder(GymsChooseAdapter.GymsViewHolder holder, int position) {

        dataBaseConnction = new DataBaseConnction(mCtx);
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




        Gyms gyms = gymsList.get(position);


        Glide.with(mCtx)
                .load(Server_URL+gyms.getGym_logo())
                .apply(centerCropTransform()
                        .placeholder(R.drawable.gymnatiionlogo_squr_defult_err)
                        .error(R.drawable.gymnatiionlogo_squr_defult_err)
                        .priority(Priority.HIGH))
                .apply(RequestOptions.skipMemoryCacheOf(true))
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                .into(holder.imgv_gym_logo);



        holder.txtv_gym_name.setText(gyms.getGym_nameg());






    }

    @Override
    public int getItemCount() {
        return gymsList.size();
    }

    class GymsViewHolder extends RecyclerView.ViewHolder {


        TextView txtv_gym_name;
        ImageView imgv_gym_logo;

        public GymsViewHolder(View itemView) {
            super(itemView);

            txtv_gym_name = itemView.findViewById(R.id.txtv_gym_name);
            imgv_gym_logo = itemView.findViewById(R.id.imgv_gym_logo);



            // on item click
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    // get position
                    int pos = getAdapterPosition();

                    // check if item still exists
                    if(pos != RecyclerView.NO_POSITION){
                        Gyms clickedDataItem = gymsList.get(pos);


                      //  dataBaseConnction = new DataBaseConnction(mCtx);
                        dataBaseConnction.update_gym_info_data(clickedDataItem.getGym_nameg(),clickedDataItem.getGym_logo(),clickedDataItem.getGym_database_url());



                        Intent intent = new Intent(mCtx, ScannerActivity.class);
                        mCtx.startActivity(intent);
                        ((GymsChooseActivity)mCtx).finish();

                    }
                }
            });


        }
    }
}
