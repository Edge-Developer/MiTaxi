package io.edgedev.mitaxi;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.edgedev.mitaxi.databinding.SingleRequestLayoutBinding;

/**
 * Created by OPEYEMI OLORUNLEKE on 6/15/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RequestHolder> {
    private List<Request> mRequests;

    public RecyclerAdapter() {
         mRequests = new ArrayList<>();

    }

    @Override
    public RequestHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        SingleRequestLayoutBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.single_request_layout, parent, false);
        return new RequestHolder(binding);
    }

    @Override
    public void onBindViewHolder(RequestHolder holder, int position) {
        holder.bind(mRequests.get(position));

    }

    @Override
    public int getItemCount() {
        return mRequests.size();
    }

    public void addRequests(List<Request> requestList) {
        if (requestList != null) {
            for (Request request : requestList) {
                mRequests.add(request);
            }
            notifyDataSetChanged();
        }
        return;
    }

    public class RequestHolder extends RecyclerView.ViewHolder {
        private SingleRequestLayoutBinding vBinding;
        private Request vRequest;

        public RequestHolder(SingleRequestLayoutBinding binding) {
            super(binding.getRoot());
            vBinding = binding;
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        public void bind(Request request) {
            vRequest = request;
            vBinding.setRequest(request);
            vBinding.executePendingBindings();
        }
    }
}
