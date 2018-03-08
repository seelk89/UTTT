/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.easv.bll.bot;

import dk.easv.bll.field.Field;
import dk.easv.bll.game.GameManager;
import dk.easv.bll.game.GameManager.GameOverState;
import java.util.Random;

/**
 *
 * @author Samuel
 */
public class MonteCarloAi
{

    private int sizeOfBoard = 9;
    private int lengthOfRow = 3;
    private int lengthofCol = 3;
    private Random rand = new Random();

    // lower = AI Dumber
    private final int numberOfSimulations = 900;

    private int Win_Points = 100;
    private int Lose_Points = -1;
    private int Draw_Points = 0;
    private int Minim_Points = -1000000000;
    private int No_Spot = -100;

    private MonteCarloAi()
    {
    }

    // What do we need this AI to do?
    // -we need it to know what spots are avaliable.
    // -then we need it to run simulations
    // -then we need it to have an observation about that simulation
    // -then we need it to pick a spot
    private int pickSpot(GameManager game)
    {

        return this.runRandomSimulations(game) + 1;
    }

    private int chooseRandomSpot(String[][] board)
    {

        int[] spotAvaliable = new int[9];
        int index = 0;
        for (int i = 0; i < sizeOfBoard; i++)
        {
            for (int j = 0; j < sizeOfBoard; j++)
            {
                if (board[i][j] == ".")
                {
                    spotAvaliable[index++] = i;
                }
            }
        }
        if (index == 0)
        {
            return this.No_Spot;
        }
        return spotAvaliable[rand() % index];
    }

    private int rand()
    {
        return Math.abs(rand.nextInt());
    }

    //Simulatioooooooooons
    private int runRandomSimulations(GameManager game)
    {

        int[] winPoints = new int[9];
        int[] goodSpots = new int[9];
        int goodSpotIndex = 0;
        int firstMove;

        String[][] tempBoard = Field.setSimulationBoard();

        boolean isThereAFreeSpace = false;
        //Where is there a good space? Setting it up.
        for (int i = 0; i < sizeOfBoard; i++)
        {
            for (int j = 0; j < sizeOfBoard; j++)
            {

                if (tempBoard[i][j] == ".")
                {
                    isThereAFreeSpace = true;
                    winPoints[i] = 0;
                } else
                {

                    winPoints[i] = this.Minim_Points;
                }
            }
        }

        //Just in case
        if (!isThereAFreeSpace)
        {
            throw new RuntimeException("No free spaces... self-destruction activated");
        }

        for (int j = 0; j < this.numberOfSimulations; j++)
        {
            firstMove = -1; //So we can track what the first move is
            int flipper = 0;
            while (game.gameOver.equals(GameOverState.Active))
            {
                // find a spot
                int spot = this.chooseRandomSpot(tempBoard);

                if (spot == this.No_Spot /* meaning there was no spot avaliable */)
                {
                    game.gameOver = GameOverState.Win;
                    // we are done with this game. 
                    break;
                }

                // The computer is basically playing the user and the comp
                // But we just take one side.
                int marker = (flipper % 2 == 0) ? game.currentPlayer : game.currentPlayer;
                // the spot
                // add one because when we play turns, we want it to look to be 1-9 based

                game.playTurn(spot + 1, marker, tempBoard);
                // take note if it's the first position
                if (firstMove == -1)
                {
                    firstMove = spot;
                }
                flipper++;

            }

            // Who won with this first move?
            // Dealing points appropriately
            if (game.gameOver.equals(GameOverState.Win)))
            {
                if (game.winner == this.AI)
                {
                    winPoints[firstMove] += this.Win_Points;
                } else
                {
                    winPoints[firstMove] += this.Lose_Points;
                }
            } else
            {
                winPoints[firstMove] += this.Draw_Points;
            }
            // Reseting the game for the next simulation
            tempBoard = game.setSimulationBoard();
        }

    }

}
}
