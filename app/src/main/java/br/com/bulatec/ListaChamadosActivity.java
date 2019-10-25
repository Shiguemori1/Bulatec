package br.com.bulatec;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListaChamadosActivity extends AppCompatActivity {



    private ListView chamadosListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_chamados);
        chamadosListView = findViewById(R.id.chamadosListView);
        Intent origemIntent = getIntent();
        String nomeFila = origemIntent.getStringExtra("nomeFila");
        List <String> chamados = busca (nomeFila);
        ArrayAdapter <String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        chamados
                );
        chamadosListView.setAdapter(adapter);
        /*chamadosListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });*/

        chamadosListView.setOnItemClickListener(
                (adapterView, view, position, id) ->{
                    Intent intent =
                            new Intent (this, DetalhesChamadoActivity.class);
                    String chamado = chamados.get(position);
                    intent.putExtra("chamado_selecionado", chamado);
                    startActivity(intent);
                });


    }

    public List <String> busca (String nomeFila){
        List <String> chamados = geraListaChamados();
        if (nomeFila == null || nomeFila.isEmpty())
            return chamados;
        List <String> subLista = new ArrayList<>();
        for (String chamado: chamados){
            if (chamado.toLowerCase().contains(nomeFila.toLowerCase()))
                subLista.add(chamado);
        }
        return subLista;
    }


    public List<String> geraListaChamados(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Abilify: Para o tratamento dos piolhos");
        lista.add("Dorflex: Para dores mais fortes");
        lista.add("Neosoro: Neosoro H é indicado para a descongestão nasal");
        lista.add("Glifage XR: É indicado para o tratamento da diabetes do tipo 2");
        lista.add("Xarelto: É indicado para prevenir a formação de coágulos de sangue nas veias");
        lista.add("Selozok: Indicado para tratar a pressão alta");
        lista.add("Neosaldina: É indicada para o tratamento de diversos tipos de dores de cabeça");
        lista.add("Torsilax: Indicado para o tratamento de reumatismo");
        lista.add("Aradois:  Indicado para tratar pressão alta e reduzir o risco de derrame cerebral ou infarto");
        lista.add("Buscopan: Reduz sintomas de cólicas menstruais");
        lista.add("Maracugina: Para pessoas com muito estresse");
        lista.add("Allegra: Indicado para manifestações alérgicas");
        lista.add("Vitamina B 12: É indicada para combater a anemia e o envelhecimento precoce da pele");
        lista.add("Zanidip: Remédio destinado ao tratamento da hipertensão arterial leve a moderada");
        lista.add("Cestox: Tratamento das infecções provocadas por Taenia solium");
        lista.add("Cloridrato de Paroxetina: Tratamento da depressão");
        lista.add("Deposteron: Para reposição de testosterona em homens que apresentem hipogonadismo");
        lista.add("Omega-3: Auxilia na prevenção de doenças cardiovasculares");
        lista.add("Enterogermina: Contribuir no equilíbrio da flora intestinal");
        lista.add("Histadin: Indicado para o alívio dos sintomas associados com a rinite alérgica");
        return lista;
    }
}
