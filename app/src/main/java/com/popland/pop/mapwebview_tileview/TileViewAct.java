package com.popland.pop.mapwebview_tileview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.qozix.tileview.TileView;
import com.qozix.tileview.detail.DetailLevel;
import com.qozix.tileview.detail.DetailLevelManager;
import com.qozix.tileview.markers.MarkerLayout;

public class TileViewAct extends AppCompatActivity {
TileView tileView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tileView = new TileView(this);
        tileView.setSize(2688,1824);

//        tileView.addDetailLevel(1f,"tiles/map/1000/%d_%d.png",256,256);
        tileView.addDetailLevel(0.5f,"tiles/map/500/%d_%d.png",256,256);
//        tileView.addDetailLevel(0.25f,"tiles/map/250/%d_%d.png",256,256);
        //tileView.addDetailLevel(0.125f,"tiles/map/125/%d_%d.png",256,256);

        DetailLevelManager dtManager = tileView.getDetailLevelManager();
        dtManager.setDetailLevelChangeListener(new DetailLevelManager.DetailLevelChangeListener() {
            @Override
            public void onDetailLevelChanged(DetailLevel detailLevel) {
                Toast.makeText(TileViewAct.this,"scale: "+detailLevel.getScale()+"_scaleRelative: "+detailLevel.getRelativeScale(),
                        Toast.LENGTH_SHORT).show();
            }
        });
//        tileView.scrollToAndCenter(2500,1510);//instantly
//        tileView.slideToAndCenter(2500,1510);//with animation
        //tileView.setScale(0.25f);

        setContentView(tileView);
        initialApp();
    }

    public void initialApp(){
        ImageView marker0 = new ImageView(this);
        marker0.setImageResource(R.drawable.marker);
        marker0.setTag("marker0");

        ImageView marker1 = new ImageView(this);
        marker1.setImageResource(R.drawable.marker);
        marker1.setTag("marker1");

        ImageView marker2 = new ImageView(this);
        marker2.setImageResource(R.drawable.marker);
        marker2.setTag("marker2");

        tileView.addMarker(marker0,0,0,-0.5f,-1.0f);
        tileView.addMarker(marker1,1250,755,-0.5f,-1.0f);
        tileView.addMarker(marker2,2500,1510,-0.5f,-1.0f);
        tileView.setMarkerTapListener(new MarkerLayout.MarkerTapListener() {
            @Override
            public void onMarkerTap(View view, int x, int y) {
                Toast.makeText(TileViewAct.this,view.getTag()+"_"+x+"_"+y,Toast.LENGTH_SHORT).show();
                ImageView callout0 = new ImageView(TileViewAct.this);
                callout0.setImageResource(R.mipmap.ic_launcher);
                tileView.addCallout(callout0,x,y,-0.5f,-1.0f);
            }
        });

    }
}
