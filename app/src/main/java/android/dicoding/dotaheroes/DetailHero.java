package android.dicoding.dotaheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailHero extends AppCompatActivity {
    public static final String extra_image = "image";
    public static final String extra_name = "name";
    public static final String extra_power = "power";
    public static final String extra_role = "role";
    public static final String extra_desc = "desc";

    ImageView tvImageReceived;
    TextView tvNameReceived;
    TextView tvPowerReceived;
    TextView tvRoleReceived;
    TextView tvDescReceived; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hero);
        tvImageReceived = findViewById(R.id.received_img_photo);
        Glide.with(getApplicationContext())
                .load(getIntent().getStringExtra(extra_image))
                .into(tvImageReceived);

        tvNameReceived = findViewById(R.id.received_hero_name);
        String name = getIntent().getStringExtra(extra_name);
        tvNameReceived.setText(name);

        tvPowerReceived = findViewById(R.id.received_power);
        String power = getIntent().getStringExtra(extra_power);
        tvPowerReceived.setText(power);

        tvRoleReceived = findViewById(R.id.received_role);
        String role = getIntent().getStringExtra(extra_role);
        tvRoleReceived.setText(role);

        tvDescReceived = findViewById(R.id.received_desc);
        String desc = getIntent().getStringExtra(extra_desc);
        tvDescReceived.setText(desc);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(name);
        }

    }
}
