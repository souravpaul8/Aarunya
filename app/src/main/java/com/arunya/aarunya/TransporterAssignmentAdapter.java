package com.arunya.aarunya;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import java.util.List;


/**
 * Created by SOURAV PAUL on 3/21/2018.
 */

public class TransporterAssignmentAdapter extends RecyclerView.Adapter<TransporterAssignmentAdapter.AssignmentViewHolder> {

    private Context mCtx;
    private List<TransporterAssignmentDetail> assignmentList;
    public View view;

    public TransporterAssignmentAdapter(Context mCtx, List<TransporterAssignmentDetail> assignmentList) {
        this.mCtx = mCtx;
        this.assignmentList = assignmentList;
    }

    @Override
    public AssignmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.trans_assignment_view_list_item,null);
        AssignmentViewHolder holder = new AssignmentViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(AssignmentViewHolder holder, int position) {

        TransporterAssignmentDetail assignmentView =assignmentList.get(position);

        holder.fromTextView.setText(assignmentView.getFrom());
        holder.toTextView.setText(assignmentView.getTo());
        holder.distanceTextView.setText(assignmentView.getDistance());
        holder.durationTextView.setText(assignmentView.getDuration());
        holder.fullPaymentTextView.setText(assignmentView.getFullPayment());

        holder.listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mCtx, TransporterChooseActionActivity.class);
                mCtx. startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return assignmentList.size();
    }

    class AssignmentViewHolder extends RecyclerView.ViewHolder {

        TextView fromTextView,toTextView,distanceTextView,fullPaymentTextView,durationTextView;
        public View listItemView;

        public AssignmentViewHolder(View listItemView) {
             super(listItemView);

             this.listItemView = listItemView;
              fromTextView = listItemView.findViewById(R.id.from_place);
              toTextView = listItemView.findViewById(R.id.to_place);
            distanceTextView =listItemView.findViewById(R.id.distance_in_number);
            durationTextView = listItemView.findViewById(R.id.estimated_time_in_number);
            fullPaymentTextView = listItemView.findViewById(R.id.total_payment_in_number);
        }
     }

}
