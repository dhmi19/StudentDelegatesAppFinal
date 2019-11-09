package com.example.dhruvmittal.studentdelegatesapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dhruvmittal.studentdelegatesapp.R;
import com.example.dhruvmittal.studentdelegatesapp.model.FeedbackHistory;

import java.util.ArrayList;


public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    Context context;
    ArrayList<FeedbackHistory> feedbacks; //Arraylist to store the results from the database

    public HistoryAdapter(Context context ,ArrayList<FeedbackHistory> feedbacks){
        this.context = context;
        this.feedbacks = feedbacks;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feedback_history_activity,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) { //This function is called per card layout

        FeedbackHistory feedbackHistory = feedbacks.get(position);

        //Setting the data from the API response to the Arraylist
        holder.dateCreatedTextView.setText(feedbackHistory.getDateCreated());
        holder.categoryTypeTextView.setText(feedbackHistory.getCategoryType());
        holder.question1ValueTextView.setText(feedbackHistory.getQuestion1());
        holder.question2ValueTextView.setText(feedbackHistory.getQuestion2());
        holder.question3ValueTextView.setText(feedbackHistory.getQuestion3());
        holder.question4ValueTextView.setText(feedbackHistory.getQuestion4());
        holder.question5ValueTextView.setText(feedbackHistory.getQuestion5());
        holder.question6ValueTextView.setText(feedbackHistory.getQuestion6());
    }

    @Override
    public int getItemCount() {
        return feedbacks.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView dateCreatedTextView,categoryTypeTextView,question1ValueTextView,question2ValueTextView,question3ValueTextView,
                question4ValueTextView,question5ValueTextView,question6ValueTextView;

        public MyViewHolder(View itemView) {
            super(itemView);

            dateCreatedTextView = itemView.findViewById(R.id.createdDateValueTextView);
            categoryTypeTextView = itemView.findViewById(R.id.categoryTypeValueTextView);
            question1ValueTextView = itemView.findViewById(R.id.question1ValueTextView);
            question2ValueTextView = itemView.findViewById(R.id.question2ValueTextView);
            question3ValueTextView = itemView.findViewById(R.id.question3ValueTextView);
            question4ValueTextView = itemView.findViewById(R.id.question4ValueTextView);
            question5ValueTextView = itemView.findViewById(R.id.question5ValueTextView);
            question6ValueTextView = itemView.findViewById(R.id.question6ValueTextView);
        }
    }
}
