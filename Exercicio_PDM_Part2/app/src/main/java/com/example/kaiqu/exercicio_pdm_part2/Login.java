package com.example.kaiqu.exercicio_pdm_part2;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.kaiqu.exercicio_pdm_part2.entity.Mensagem;
import com.example.kaiqu.exercicio_pdm_part2.entity.Pessoa;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    private EditText editSenha;
    private Button btnAcessa;
    private String url;
    private Pessoa p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editSenha = (EditText) findViewById(R.id.editSenha);
        btnAcessa = (Button) findViewById(R.id.btnAcessar);

    }

    public void btnAceesar(View view){

        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("login", "kaique");
            jsonObject.put("senha", editSenha.getText().toString());

            String url = "http://192.168.1.10:8080/ServidorWebPDM/api/server";

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) throws JSONException {
                    p = new Pessoa();
                    p.setId(response.getInt("id"));
                    p.setNome(response.getString("nome"));
                    p.setEmail(response.getString("email"));

                    JSONObject l = response.getJSONObject("login");
                    com.example.kaiqu.exercicio_pdm_part2.entity.Login login = new com.example.kaiqu.exercicio_pdm_part2.entity.Login();
                    login.setId(l.getInt("id"));
                    login.setLogin(l.getString("login"));
                    login.setSenha(l.getString("senha"));
                    p.setLogin(login);

                    JSONArray c = response.getJSONArray("contatos");
                    ArrayList<Pessoa> contatos = new ArrayList<Pessoa>();
                    for(int i = 0; i < c.length() ; i++){
                        JSONObject jsObj = c.getJSONObject(1);
                        Pessoa pessoa = new Pessoa();
                        pessoa.setId(jsObj.getInt("id"));
                        pessoa.setNome(jsObj.getString("nome"));
                        pessoa.setEmail(jsObj.getString("email"));
                        contatos.add(pessoa);
                    }
                    p.setContatos(contatos);

                    JSONArray m = response.getJSONArray("mensagens");
                    ArrayList<Mensagem> mensagems = new ArrayList<Mensagem>();
                    for(int i = 0; i < m.length() ; i++){
                        JSONObject jsObj = c.getJSONObject(1);
                        Mensagem mensagem = new Mensagem();
                        mensagem.setId(jsObj.getInt("id"));
                        mensagem.setMensagem(jsObj.getString("mensagem"));
                        mensagems.add(mensagem);
                    }
                    p.setMensagens(mensagems);

                    showMessage("Sucesso", p.toString());
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    p = null;
                    showMessage("Senha Invalida", "Por Favor Tente Novamente!");
                }
            });

            RequestQueue queue = Volley.newRequestQueue(this);
            queue.add(jsonObjectRequest);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (p != null){
            Intent intent = new Intent(this, Contatos.class);
            intent.putExtra("pessoa", p);
            startActivity(intent);
        }
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
