package com.reziena.user.reziena_1;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class bReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        String btTag = "이것은 bReceiver";

        Log.e("bReceiver", "들어와따!!!");

        if(BluetoothDevice.ACTION_ACL_CONNECTED.equals(action)) {
            Log.e(btTag,"Now Action?:: " + action);
            HomeActivity.imageView2.setImageResource(R.drawable.ellipsehomethera_icon);
            Intent i1 = new Intent(context, BluetoothActivity.class);
            context.startActivity(i1);
        }
        else if(BluetoothDevice.ACTION_ACL_DISCONNECTED.equals(intent.getAction())) {
            Log.e(btTag,"Now Action?:: " + action);
            HomeActivity.imageView2.setImageResource(R.drawable.nondeviceicon);
            Intent i2 = new Intent(context, BTOnActivity.class);
            context.startActivity(i2);
        }
        else if (BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED.equals(intent.getAction())) {
            Log.e(btTag,"Now Action?:: " + action);
        }
        else if (BluetoothAdapter.ACTION_CONNECTION_STATE_CHANGED.equals(intent.getAction())) {
            Log.e(btTag,"Now Action?:: " + action);
        }
    }
}
