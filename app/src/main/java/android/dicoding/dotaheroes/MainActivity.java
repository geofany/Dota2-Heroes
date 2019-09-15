package android.dicoding.dotaheroes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHeroes;
    private ArrayList<Hero> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvHeroes = findViewById(R.id.rv_hero);
        rvHeroes.setHasFixedSize(true);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Dota 2 Heroes");
        }

        list.addAll(HeroesData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(list);
        rvHeroes.setAdapter(listHeroAdapter);
        listHeroAdapter.setOnItemClickCallback(new ListHeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hero data) {
                showSelectedHero(data);
                Intent intent = new Intent(MainActivity.this, DetailHero.class);
                intent.putExtra(DetailHero.extra_image, data.getPhoto_detail());
                intent.putExtra(DetailHero.extra_name, data.getName());
                intent.putExtra(DetailHero.extra_power, data.getPower());
                intent.putExtra(DetailHero.extra_role, data.getRole());
                intent.putExtra(DetailHero.extra_desc, data.getDesc());
                startActivity(intent);
            }
        });
    }

    private void showRecyclerGrid(){
        rvHeroes.setLayoutManager(new GridLayoutManager(this, 2));
        GridHeroAdapter gridHeroAdapter = new GridHeroAdapter(list);
        rvHeroes.setAdapter(gridHeroAdapter);
        gridHeroAdapter.setOnItemClickCallback(new GridHeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hero data) {
                showSelectedHero(data);
                Intent intent = new Intent(MainActivity.this, DetailHero.class);
                intent.putExtra(DetailHero.extra_image, data.getPhoto_detail());
                intent.putExtra(DetailHero.extra_name, data.getName());
                intent.putExtra(DetailHero.extra_power, data.getPower());
                intent.putExtra(DetailHero.extra_role, data.getRole());
                intent.putExtra(DetailHero.extra_desc, data.getDesc());
                startActivity(intent);
            }
        });
    }

    private void showRecyclerCardView(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        CardViewHeroAdapter cardViewHeroAdapter = new CardViewHeroAdapter(list);
        rvHeroes.setAdapter(cardViewHeroAdapter);
        cardViewHeroAdapter.setOnItemClickCallback(new CardViewHeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hero data) {
                showSelectedHero(data);
                Intent intent = new Intent(MainActivity.this, DetailHero.class);
                intent.putExtra(DetailHero.extra_image, data.getPhoto_detail());
                intent.putExtra(DetailHero.extra_name, data.getName());
                intent.putExtra(DetailHero.extra_power, data.getPower());
                intent.putExtra(DetailHero.extra_role, data.getRole());
                intent.putExtra(DetailHero.extra_desc, data.getDesc());
                startActivity(intent);
            }
        });
    }

    private void showSelectedHero(Hero hero){
        Toast.makeText(this, "Kamu Memilih " + hero.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode){
        switch (selectedMode){
            case R.id.action_list:
                showRecyclerList();
                break;

            case R.id.action_grid:
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                showRecyclerCardView();
                break;
        }
    }
}
