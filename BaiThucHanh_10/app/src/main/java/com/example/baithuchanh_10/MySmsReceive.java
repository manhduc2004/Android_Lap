package com.example.baithuchanh_10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MySmsReceive extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Khởi tạo Bundle để lấy dữ liệu từ Intent
        Bundle extras = intent.getExtras();

        // Kiểm tra xem Bundle có null không
        if (extras != null) {
            // Lấy các PDU (Protocol Description Unit) từ Bundle
            Object[] smsExtra = (Object[]) extras.get("pdus");

            // Khởi tạo StringBuilder để xây dựng nội dung tin nhắn
            StringBuilder smsMessageBody = new StringBuilder();
            String senderAddress = "";

            if (smsExtra != null) {
                // Lặp qua từng PDU
                for (Object pdu : smsExtra) {
                    // Tạo SmsMessage từ PDU
                    SmsMessage sms = SmsMessage.createFromPdu((byte[]) pdu);

                    // Lấy địa chỉ người gửi và nội dung tin nhắn
                    senderAddress = sms.getOriginatingAddress();
                    smsMessageBody.append(sms.getMessageBody());
                }

                // Tạo nội dung Toast hiển thị
                String fullMessage = "Có 1 tin nhắn từ " + senderAddress + "\n" + smsMessageBody.toString() + " vừa gởi đến";

                // Hiển thị Toast với nội dung đã tạo
                Toast.makeText(context, fullMessage, Toast.LENGTH_LONG).show();
            }
        }
    }
}