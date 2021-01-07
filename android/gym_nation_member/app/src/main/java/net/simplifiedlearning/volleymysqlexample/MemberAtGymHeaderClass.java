package net.simplifiedlearning.volleymysqlexample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MemberAtGymHeaderClass extends RecyclerView.Adapter<MemberAtGymAdapter.ProductViewHolder> {

    private ImageView imgv_gym_logo;
    private TextView txtv_gym_name;
    private TextView txtv_num_of_member_atgym;


public MemberAtGymHeaderClass(View v) {

    imgv_gym_logo = (ImageView) v.findViewById(R.id.imgv_gym_logo);
    txtv_gym_name = (TextView) v.findViewById(R.id.txtv_gym_name);
    txtv_num_of_member_atgym = (TextView) v.findViewById(R.id.txtv_num_of_member_atgym);





        }

    public ImageView getImageView() {
        return imgv_gym_logo;
        }


public void setImageView(ImageView ivExample) {
        this.imgv_gym_logo = ivExample;
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