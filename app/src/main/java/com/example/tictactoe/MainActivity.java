package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
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
        TextView status = findViewById(R.id.status);
        if(!gameActive){
            gameReset(view);
        }
        if(gameStatus[tappedImg] == 2){
            gameStatus[tappedImg]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer == 0){
                img.setImageResource(R.drawable.xtic);
                activePlayer=1;
                status.setText("0's Turn , Tap to play");
            }else{
                img.setImageResource(R.drawable.o);
                activePlayer=0;
                status.setText("X's Turn , Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }

        // check if any player has won or not

        for(int[] winPosition : winningPositions){
            if(
                    gameStatus[winPosition[0]] == gameStatus[winPosition[1]] &&
                    gameStatus[winPosition[2]] == gameStatus[winPosition[1]] &&
                    gameStatus[winPosition[0]] != 2
            ){
//                Somebody has won !!
                String winnerString;
                    if(gameStatus[winPosition[0]]==0){
//                        X has won
                        winnerString="X has Won";
                    }else{
//                        0 has won
                        winnerString="0 has Won";
                    }
                    status.setText(winnerString);

                    gameActive=false;


            }
        }

        int flag= 0;
        for(int val : gameStatus){
            if(val == 2){
                flag=1;
            }
        }
//        if flag remains 0 means all the places are full
//        if flags becomes 1 means atleast one place is empty
        if(flag == 0){
            gameReset(view);
        }


    }

//    Resting the Game values
    public void gameReset(View view){
        gameActive=true;
        activePlayer=0;

        for(int i=0;i<gameStatus.length;i++){
            gameStatus[i]=2;
        }

        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn , Tap to play");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}