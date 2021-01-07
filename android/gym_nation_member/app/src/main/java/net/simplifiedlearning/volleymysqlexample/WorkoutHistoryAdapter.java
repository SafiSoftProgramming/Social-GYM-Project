package net.simplifiedlearning.volleymysqlexample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Belal on 10/18/2017.
 */

public class WorkoutHistoryAdapter extends RecyclerView.Adapter<WorkoutHistoryAdapter.WorkoutViewHolder> {

    String ServerURL ;
    String WorkOut_Img_Folder_Name ;
    String WorkOut_Img_Type ;
    private Context mCtx;
    private List<Workout> workoutList;

    public WorkoutHistoryAdapter(Context mCtx, List<Workout> workoutList) {
        this.mCtx = mCtx;
        this.workoutList = workoutList;
    }

    @Override
    public WorkoutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ServerURL = mCtx.getResources().getString(R.string.Server_URL);
        WorkOut_Img_Folder_Name = mCtx.getResources().getString(R.string.WorkOut_Img_Folder_Name);
        WorkOut_Img_Type =mCtx.getResources().getString(R.string.WorkOut_Img_Type);



        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.workouthistory_list, null);
        return new WorkoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WorkoutViewHolder holder, int position) {
        Workout workout = workoutList.get(position);


        String workout_img_one_name = workout.getWorkoutOneName();
        String workout_img_two_name = workout.getWorkoutTwoName();



        if(workout_img_one_name.equals("")){holder.imgv_workout_one.setVisibility(View.GONE); holder.txtv_workout_one_history.setVisibility(View.GONE);}
        else {
            Glide.with(mCtx)
                .load(ServerURL+WorkOut_Img_Folder_Name+workout_img_one_name+WorkOut_Img_Type)
                .into(holder.imgv_workout_one);
            holder.imgv_workout_one.setVisibility(View.VISIBLE); holder.txtv_workout_one_history.setVisibility(View.VISIBLE);
            holder.txtv_workout_one_history.setText(workout_img_one_name);
        }


        if(workout_img_two_name.equals("")){holder.imgv_workout_two.setVisibility(View.GONE); holder.txtv_workout_tow_history.setVisibility(View.GONE);}
        else {
            Glide.with(mCtx)
                .load(ServerURL+WorkOut_Img_Folder_Name+workout_img_two_name+WorkOut_Img_Type)
                .into(holder.imgv_workout_two);
            holder.imgv_workout_two.setVisibility(View.VISIBLE); holder.txtv_workout_tow_history.setVisibility(View.VISIBLE);
            holder.txtv_workout_tow_history.setText(workout_img_two_name);
        }


        switch(workout.getWorkoutRate()){

            case  "0":
            holder.img_workout_rate.setImageResource(R.drawable.rate_0);
                break;

            case  "20":
                holder.img_workout_rate.setImageResource(R.drawable.rate_20);
                break;

            case  "50":
                holder.img_workout_rate.setImageResource(R.drawable.rate_50);
                break;

            case  "80":
                holder.img_workout_rate.setImageResource(R.drawable.rate_80);
                break;

            case  "100":
                holder.img_workout_rate.setImageResource(R.drawable.rate_100);
                break;

        }





        holder.txtv_workout_start_time.setText(workout.getstartWorkoutTime());
        holder.txtv_workout_rate.setText(workout.getWorkoutRate()+"%");
        holder.txtv_workout_duration.setText(String.valueOf(workout.getWorkoutTimeDuration()));
        holder.txtv_workout_sign_out.setText(String.valueOf(workout.getWorkoutSignOutMode()));
        holder.txtv_workout_end_time.setText(String.valueOf(workout.getendWorkoutTime()));
        holder.txtv_workout_date.setText(String.valueOf(workout.getstartWorkoutDate()));
    }

    @Override
    public int getItemCount() {
        return workoutList.size();
    }

    class WorkoutViewHolder extends RecyclerView.ViewHolder {
        LinearLayout btn_share_facebook ;
        TextView txtv_workout_start_time,txtv_workout_rate,txtv_workout_duration,txtv_workout_sign_out,txtv_workout_end_time,txtv_workout_date,txtv_workout_one_history,txtv_workout_tow_history ;
        ImageView img_workout_rate,imgv_workout_one,imgv_workout_two;

        public WorkoutViewHolder(View itemView) {
            super(itemView);

            txtv_workout_start_time = itemView.findViewById(R.id.txtv_workout_start_time);
            txtv_workout_rate = itemView.findViewById(R.id.txtv_workout_rate);
            txtv_workout_duration = itemView.findViewById(R.id.txtv_workout_duration);
            txtv_workout_sign_out = itemView.findViewById(R.id.txtv_workout_sign_out);
            txtv_workout_end_time = itemView.findViewById(R.id.txtv_workout_end_time);
            txtv_workout_date = itemView.findViewById(R.id.txtv_workout_date);
            txtv_workout_one_history = itemView.findViewById(R.id.txtv_workout_one_history);
            txtv_workout_tow_history = itemView.findViewById(R.id.txtv_workout_tow_history);
            img_workout_rate = itemView.findViewById(R.id.img_workout_rate);
            imgv_workout_one = itemView.findViewById(R.id.imgv_workout_one_history);
            imgv_workout_two = itemView.findViewById(R.id.imgv_workout_tow_history);
            btn_share_facebook = itemView.findViewById(R.id.btn_share_facebook);




            // on item click
            btn_share_facebook.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    // get position
                    int pos = getAdapterPosition();

                    // check if item still exists
                    if(pos != RecyclerView.NO_POSITION){
                        Workout clickedDataItem = workoutList.get(pos);


                        Intent intent = new Intent(mCtx, WaterMarkShareActivity.class);
                        intent.putExtra("WORKOUT_DATE", clickedDataItem.getstartWorkoutDate());
                        intent.putExtra("WORKOUT_DURATION", clickedDataItem.getWorkoutTimeDuration());
                        intent.putExtra("WORKOUT_ONE_NAME", clickedDataItem.getWorkoutOneName());
                        intent.putExtra("WORKOUT_TOW_NAME", clickedDataItem.getWorkoutTwoName());
                        mCtx.startActivity(intent);
                    }
                }
            });


        }
    }
}
