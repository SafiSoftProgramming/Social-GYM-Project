package net.simplifiedlearning.volleymysqlexample;

import android.content.Context;
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

import java.util.List;

import static com.bumptech.glide.request.RequestOptions.centerCropTransform;


public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {


    private Context mCtx;
    private List<Notification> notificationList;

    String ServerURL ;
    String Notification_Icon_Folder_Name ;
    String Notification_Icon_Type ;



    class NotificationViewHolder extends RecyclerView.ViewHolder {


        TextView txtv_massage_head, txtv_massage_body, txtv_massage_time_date;
        ImageView imgv_massage_icon,imgv_show_more_text;

        public NotificationViewHolder(View itemView) {
            super(itemView);

            txtv_massage_head = itemView.findViewById(R.id.txtv_massage_head);
            txtv_massage_body = itemView.findViewById(R.id.txtv_massage_body);
            txtv_massage_time_date = itemView.findViewById(R.id.txtv_massage_time_date);
            imgv_massage_icon = itemView.findViewById(R.id.imgv_massage_icon);
            imgv_show_more_text = itemView.findViewById(R.id.imgv_show_more_text);




            // on item click
            imgv_show_more_text.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    // get position
                    int pos = getAdapterPosition();
                    // check if item still exists
                    if(pos != RecyclerView.NO_POSITION){
                        ViewGroup.LayoutParams params = txtv_massage_body.getLayoutParams();
                        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                        txtv_massage_body.setLayoutParams(params);
                    }
                }
            });


        }
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



    public NotificationAdapter(Context mCtx, List<Notification> notificationList) {
        this.mCtx = mCtx;
        this.notificationList = notificationList;
    }

    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.notification_list, null);
        return new NotificationViewHolder(view);


    }

    @Override
    public void onBindViewHolder(NotificationViewHolder holder, int position) {
            ServerURL = mCtx.getResources().getString(R.string.Server_URL);
            Notification_Icon_Folder_Name = mCtx.getResources().getString(R.string.Notification_Icons_Folder_Name);
            Notification_Icon_Type = mCtx.getResources().getString(R.string.Notification_Icon_Type);


            Notification notification = notificationList.get(position);


            Glide.with(mCtx)
                    .load(ServerURL + Notification_Icon_Folder_Name + notification.getMassageIcon() + Notification_Icon_Type)
                    .apply(centerCropTransform()
                            .placeholder(R.drawable.gymnatiionlogo_squr_defult_err)
                            .error(R.drawable.gymnatiionlogo_squr_defult_err)
                            .priority(Priority.HIGH))
                    .apply(RequestOptions.skipMemoryCacheOf(true))
                    .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                    .into(holder.imgv_massage_icon);


            holder.txtv_massage_head.setText(notification.getMassageHead());
            holder.txtv_massage_body.setText(notification.getMassageBody());
            holder.txtv_massage_time_date.setText(String.valueOf(notification.getMassageTimeDate()));


            if (notification.getMassageBody().length() >= 150) {
                holder.imgv_show_more_text.setVisibility(View.VISIBLE);
            } else {
                holder.imgv_show_more_text.setVisibility(View.GONE);
            }



    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }


}
