package com.guideme;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.guideme.Model.DatabaseController;
import com.guideme.Model.FitData;
import com.guideme.Model.TrainingCalculator;

import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Math.round;

public class RouteListAdapter extends RecyclerView.Adapter<RouteListAdapter.RouteListViewHolder> {

    private ArrayList<FitData> routes;
    private Context context;
    private DatabaseController database;
    private FirebaseAuth firebaseAuth;

    public RouteListAdapter(ArrayList<FitData> routes, Context context) {
        this.routes = routes;
        this.context = context;
    }

    /*View Holder Class*/
    static class RouteListViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private TextView txtRouteName;
        private TextView txtRouteLength;
        private TextView txtLevel1;
        private TextView txtLevel2;
        private TextView txtLevel3;
        private TextView txtLevel4;
        private TextView txtLevel5;
        private TextView txtLevel6;
        private TextView txtTraining;

        //View Holder Constructor sets UI widgets
        public RouteListViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            txtRouteName = itemView.findViewById(R.id.route_name);
            txtRouteLength = itemView.findViewById(R.id.route_length);
            txtTraining = itemView.findViewById(R.id.route_txt_training);

            txtLevel1 = itemView.findViewById(R.id.route_txt_level_1);
            txtLevel2 = itemView.findViewById(R.id.route_txt_level_2);
            txtLevel3 = itemView.findViewById(R.id.route_txt_level_3);
            txtLevel4 = itemView.findViewById(R.id.route_txt_level_4);
            txtLevel5 = itemView.findViewById(R.id.route_txt_level_5);
            txtLevel6 = itemView.findViewById(R.id.route_txt_level_6);
        }
    }

    @NonNull
    @Override //Returns view for ViewHolder
    public RouteListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_route, parent, false);
        return new RouteListViewHolder(view);
    }

    @Override   //build view for every route from firebase
    public void onBindViewHolder(@NonNull RouteListViewHolder holder, int position) {
        firebaseAuth = FirebaseAuth.getInstance();
        database = DatabaseController.getInstance(firebaseAuth.getUid());
        FitData currentRoute = routes.get(position);
        holder.txtRouteName.setText(currentRoute.getRouteName());
        holder.txtRouteLength.setText("Distance: " + Double.toString(round(currentRoute.getDistance()/1000)) + " km");
        ArrayList<Integer> levelDistribution = currentRoute.getLevelDistribution(context);

        holder.txtLevel1.setText(levelDistribution.get(0) + " Sec.");
        holder.txtLevel2.setText(levelDistribution.get(1) + " Sec.");
        holder.txtLevel3.setText(levelDistribution.get(2) + " Sec.");
        holder.txtLevel4.setText(levelDistribution.get(3) + " Sec.");
        holder.txtLevel5.setText(levelDistribution.get(4) + " Sec.");
        holder.txtLevel6.setText(levelDistribution.get(5) + " Sec.");

        holder.txtTraining.setText("Recognized Training: " + currentRoute.getTraining(context));

        //onItemClick Event
        holder.cardView.setOnClickListener(view -> {
            Intent intent = new Intent(context, MapActivity.class);
            intent.putExtra("routeId", currentRoute.getFitIdString());
            context.startActivity(intent);
        });
        holder.cardView.setOnLongClickListener(v -> {
            //creating a popup menu
            PopupMenu popup = new PopupMenu(context, holder.cardView);
            //inflating menu from xml resource
            popup.inflate(R.menu.menu_my_routes);
            //adding click listener
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.contextRename:
                            showPopupDialog(currentRoute, holder);
                            break;
                        case R.id.contextRemove:
                            routes.remove(position);
                            notifyItemRemoved(position);
                            database.delete("/FitData/" + currentRoute.getUserId()+"/"+ currentRoute.getFitIdString()+"/");
                            //handle menu2 click
                            break;
                    }
                    return false;
                }
            });
            //displaying the popup
            popup.show();
            return false;
        });
    }

    //Dialog to change Routename
    private void showPopupDialog(FitData currentRoute, RouteListViewHolder holder) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_change_route_name);
        Button btnCancle = dialog.findViewById(R.id.dialog_btn_cancle);
        Button btnApply = dialog.findViewById(R.id.btn_dialog_apply);
        EditText etNewName = dialog.findViewById(R.id.dialog_et_change);

        btnApply.setOnClickListener(v -> {
            String newName = etNewName.getText().toString();
            holder.txtRouteName.setText(newName);
            currentRoute.setRouteName(newName);
            database.updateFitData(currentRoute);
            dialog.dismiss();
        });
        btnCancle.setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }


    @Override
    public int getItemCount() {
        return routes.size();
    }
}
