package com.example.chatapp.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp.databinding.ItemContainerRecentConversationBinding;
import com.example.chatapp.models.ChatMessage;

import java.util.List;

public class RecentConversationsAdapter extends RecyclerView.Adapter<RecentConversationsAdapter.ConversationViewHolder> {
    
    private final List<ChatMessage> chatMessages;

    public RecentConversationsAdapter(List<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }

    class ConversationViewHolder extends RecyclerView.ViewHolder{
    ItemContainerRecentConversationBinding binding;
ConversationViewHolder(ItemContainerRecentConversationBinding itemContaienrRecentConversationBinding){
    super(itemContaienrRecentConversationBinding.getRoot());
    binding=itemContaienrRecentConversationBinding;
}
void setData(ChatMessage chatMessage){
    binding.imageProfile.setImageBitmap(getConversationImage(chatMessage.conversationImage));
    binding.textName.setText(chatMessage.message);
}


}



    private Bitmap getConversationImage(String encodedImage){
        byte[] bytes= Base64.decode(encodedImage,Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes,0,bytes.length);
    }
}
