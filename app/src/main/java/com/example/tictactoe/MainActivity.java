package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    /*
    * Player 0 - X
    * Player 1 - 0
    * */
    int activePlayer = 1;
    /*
     * State meaning
     * 0-X
     * 1-0
     * 2-Blank
     * */
    int[] gameStatus = {2,2,2,2,2,2,2,2,2};
    /*
    * Winning Positions
    * */
    int[][] winningPositions={
            {0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{8,4,2}
    };
    public void playerTap(View view){
//        Getting the image tap
        ImageView img =(ImageView) view;
        int tappedImg = Integer.parseInt(img.getTag().toString());
        if(gameStatus[tappedImg] == 2){
            gameStatus[tappedImg]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer == 0){
                img.setImageResource(R.drawable.xtic);
                activePlayer=1;
            }else{
                img.setImageResource(R.drawable.o);
                activePlayer=0;
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}