package com.example.kaiqu.exercicio_pdm_part2;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.kaiqu.exercicio_pdm_part2.entity.Mensagem;
import com.example.kaiqu.exercicio_pdm_part2.entity.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class Contatos extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listContatos;
    private Bundle bundle;
    private Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos);

        listContatos = (ListView) findViewById(R.id.listContatos);
        bundle = getIntent().getExtras();
        pessoa = getIntent().getExtras().getParcelable("pessoa");
        ArrayAdapter<Pessoa> pessoaArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pessoa.getContatos());
        listContatos.setAdapter(pessoaArrayAdapter);
        listContatos.setOnItemClickListener(this);

        showMessage("Contatos", pessoa.getContatos().toString());
        for (Pessoa p :pessoa.getContatos()) {
            showMessage("Pessoas", pessoa.toString());
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Pessoa p = (Pessoa) parent.getItemAtPosition(position);
        List<Mensagem> mens = new ArrayList<Mensagem>();
        for (Mensagem m :pessoa.getMensagens()) {
            if (m.getIdDestinatario() == p.getId()){
                mens.add(m);
            }
        }
        p.setMensagens(mens);
        showMessage("Mensagems", p.getMensagens().toString());
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}



