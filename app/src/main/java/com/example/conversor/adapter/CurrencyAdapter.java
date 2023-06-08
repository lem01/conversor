package com.example.conversor.adapter;

import  android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conversor.EditCurrencyActivity;
import com.example.conversor.R;
import com.example.conversor.model.CurrencyModel;


import java.util.List;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder> {



    private List<CurrencyModel> currencyList;
//    private RecyclerView recyclerView;


    public CurrencyAdapter(List<CurrencyModel> currencyList) {
//        CurrencyList.currencyList = currencyList;
        this.currencyList = currencyList;
    }

    @NonNull
    @Override
    public CurrencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.currency_item, parent, false);
        return new CurrencyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyViewHolder holder, int position) {


        CurrencyModel currency = CurrencyList.currencyList.get(position);



        String countryFullName = currency.getCountry() + "(" + currency.getFullNameCurrency()+")" ;


        holder.imageViewCountry.setImageResource(R.drawable.ic_baseline_image_24);
        holder.textViewFullName.setText(countryFullName);
        holder.textViewCurrency.setText(currency.getCurrency());
        holder.textViewSymbol.setText(currency.getSymbol());
        holder.textViewAmount.setText(String.valueOf(currency.getAmount() ));
        holder.deleteCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrencyList.currencyList.remove(position);
                notifyDataSetChanged();
                Toast.makeText(v.getContext(), "Eliminado " + position, Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EditCurrencyActivity.class);

                intent.putExtra("position", position);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return CurrencyList.currencyList.size();
    }


    public void addCurrency(CurrencyModel currency) {
        currencyList.add(currency);
        notifyItemInserted(currencyList.size() - 1);
    }

    public void updateCurrency(CurrencyModel currency, int position) {
        currencyList.set(position, currency);
        notifyItemChanged(position);
    }

    public void deleteCurrency(int position) {
        currencyList.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    public static class CurrencyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewCountry;
        TextView textViewFullName;
        TextView textViewCurrency;
//        TextView textViewCountry;
        TextView textViewSymbol;
        TextView textViewAmount;
        ImageButton deleteCurrency;
        ImageButton btnEdit;

        public CurrencyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewCountry = itemView.findViewById(R.id.im_country);
            textViewFullName = itemView.findViewById(R.id.tv_full_name_currency);
            textViewCurrency = itemView.findViewById(R.id.tv_currency);
//            textViewCountry = itemView.findViewById(R.id.tv_currency);
            textViewSymbol = itemView.findViewById(R.id.tv_simbol);
            textViewAmount = itemView.findViewById(R.id.tv_amount);
            deleteCurrency = itemView.findViewById(R.id.btn_delete_currency);
            btnEdit = itemView.findViewById(R.id.btn_edit_currency);
        }
    }
}


