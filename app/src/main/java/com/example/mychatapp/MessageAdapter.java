package com.example.mychatapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder>{
    private List<chatMessage> messages = new ArrayList<>();
    public MessageAdapter (List<chatMessage> m) {
        this.messages = m;
    }
    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        chatMessage message = messages.get(position);
        holder.message.setText(message.message);
        holder.userName.setText(message.userName);
        Glide.with(holder.userImage.getContext()).load(message.userPhoto).into(holder.userImage);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public void addMessage(chatMessage m) {
        messages.add(m);
        notifyDataSetChanged();
    }
}
