package net.simplifiedlearning.volleymysqlexample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class User_and_plan_header_class extends RecyclerView.Adapter<MemberAtGymAdapter.ProductViewHolder> {

    private ImageView imgv_member_profile_img;
    private TextView txtv_member_name;
    private TextView txtv_gym_name;
    private TextView txtv_member_plane;
    private TextView txtv_member_startdate;
    private TextView txtv_member_enddate;


public User_and_plan_header_class(View v) {

    imgv_member_profile_img = (ImageView) v.findViewById(R.id.imgv_member_profile_img);
    txtv_member_name = (TextView) v.findViewById(R.id.txtv_member_name);
    txtv_gym_name = (TextView) v.findViewById(R.id.txtv_gym_name);
    txtv_member_plane = (TextView) v.findViewById(R.id.txtv_member_plane);
    txtv_member_startdate = (TextView) v.findViewById(R.id.txtv_member_startdate);
    txtv_member_enddate = (TextView) v.findViewById(R.id.txtv_member_enddate);





        }

    public ImageView getImageView() {
        return imgv_member_profile_img;
        }


public void setImageView(ImageView ivExample) {
        this.imgv_member_profile_img = ivExample;
        }




    @Override
    public MemberAtGymAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MemberAtGymAdapter.ProductViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}