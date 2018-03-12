/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.easv.bll.bot;

import dk.easv.bll.field.IField;
import dk.easv.bll.game.IGameState;
import dk.easv.bll.move.IMove;
import dk.easv.bll.move.Move;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Jesper
 */
public class BottyMcBotFace implements IBot
{
    private static final String BOTNAME = "bottyMcBotButt";
    
    private int[][] firstSet =
    {
        {0, 0}, {2, 0}, {0, 2},
    };
    
    private int[][] secondSet =
    {
        {1, 0}, {1, 2}, {1, 1},    
    };
    
    private int[][] thirdSet =
    {
        {2, 0}, {2, 2}, {0, 0}, 
    };
        
    private int[][] fourthSet =
    {
        {0, 1}, {2, 1}, {1, 1}, 
    };
                
    private int[][] fifthSet =
    {
        {1, 1}, {2, 2}, {0, 0}, 
        {2, 0}, {0, 2}, {1, 0},
        {0, 1}, {1, 2}, {2, 1},
    };
         
    private int[][] sixthSet =
    {
        {2, 1}, {0, 1}, {1, 1},   
    };
    
    private int[][] seventhSet =
    {
        {0, 2}, {0, 0}, {2, 2},          
    };                  
    
    private int[][] eighthSet =
    {
        {1, 2}, {1, 0}, {1, 1}, 
    };
          
    private int[][] ninthSet =
    {
        {2, 2}, {0, 2}, {2, 0}, 
    };    
    
    private int[][] startMiddleSet =
    {
        {1, 1}
    };

    @Override
    public IMove doMove(IGameState state)
    {
        //Find macroboard to play in
        for (int[] move : fifthSet)
        {
            if (state.getField().getMacroboard()[move[0]][move[1]].equals(IField.AVAILABLE_FIELD))
            {  
                //checking for winable squares
                IMove winningMove = checkWinBlock(state, 0);
                if(winningMove != null)
                {
                    return winningMove;
                }    
                
                //checking for blockable wins
                IMove blockingMove = checkWinBlock(state, 1);
                if(blockingMove != null)
                {
                    return blockingMove;
                }
                
                int[][] set = firstSet;
                
                if(state.getField().getMacroboard()[1][0].equals(IField.AVAILABLE_FIELD))
                {
                    set = secondSet;
                    System.out.println("Second set");
                }
                
                if(state.getField().getMacroboard()[2][0].equals(IField.AVAILABLE_FIELD))
                {
                    set = thirdSet;
                    System.out.println("Third set");
                }
                
                if(state.getField().getMacroboard()[0][1].equals(IField.AVAILABLE_FIELD))
                {
                    set = fourthSet;
                    System.out.println("Fourth set");
                }
                
                if(state.getField().getMacroboard()[1][1].equals(IField.AVAILABLE_FIELD))
                {
                    set = fifthSet;
                    System.out.println("Fifth set");
                }
                
                if(state.getField().getMacroboard()[2][1].equals(IField.AVAILABLE_FIELD))
                {
                    set = sixthSet;
                    System.out.println("Sixth set");
                }
                
                if(state.getField().getMacroboard()[0][2].equals(IField.AVAILABLE_FIELD))
                {
                    set = seventhSet;
                    System.out.println("Seventh set");
                }
                
                if(state.getField().getMacroboard()[1][2].equals(IField.AVAILABLE_FIELD))
                {
                    set = eighthSet;
                    System.out.println("Eighth set");
                }
                
                if(state.getField().getMacroboard()[2][2].equals(IField.AVAILABLE_FIELD))
                {
                    set = ninthSet;
                    System.out.println("Ninth set");
                }
                
                //in case the bot starts, use this set
                if(state.getMoveNumber() == 0)
                {
                    set = startMiddleSet ;
                    System.out.println("Start middle");
                }
                
                //find move to play in selected prioretised moves list
                for (int[] selectedMove : set)
                {
                    int x = move[0] * 3 + selectedMove[0];
                    int y = move[1] * 3 + selectedMove[1];
                    if (state.getField().getBoard()[x][y].equals(IField.EMPTY_FIELD))
                    {
                        return new Move(x, y);
                    }
                }
                
                //selects a random move if all ohter checks fail
                Random rand = new Random();
                List<IMove> moves = state.getField().getAvailableMoves();
                if (moves.size() > 0) 
                {
                    return moves.get(rand.nextInt(moves.size())); /* get random move from available moves */
                }
            }
        } 
        //NOTE: Something failed, just take the first available move I guess!
        return state.getField().getAvailableMoves().get(0);
    }
    
    private IMove checkWinBlock(IGameState state, int playerOfset)
    {
        String player = "" + ((state.getMoveNumber() + playerOfset) % 2);
        int microBoardX = getMacroBoardX(state) * 3;
        int microBoardY = getMacroBoardY(state) * 3;
        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                //checking for winable/blockable squares in the X lines
                if(state.getField().getBoard()[microBoardX][j + microBoardY].equals(player) &&
                        state.getField().getBoard()[microBoardX + 1][j + microBoardY].equals(player) &&
                        state.getField().getBoard()[microBoardX + 2][j + microBoardY].equals(IField.EMPTY_FIELD))
                {
                    return new Move(microBoardX + 2, j + microBoardY);
                }
                
                if(state.getField().getBoard()[microBoardX + 1][j + microBoardY].equals(player) &&
                        state.getField().getBoard()[microBoardX + 2][j + microBoardY].equals(player)&&
                        state.getField().getBoard()[microBoardX][j + microBoardY].equals(IField.EMPTY_FIELD))
                {
                    return new Move(microBoardX, j + microBoardY);
                }
                
                if(state.getField().getBoard()[microBoardX][j + microBoardY].equals(player) &&
                        state.getField().getBoard()[microBoardX + 2][j + microBoardY].equals(player)&&
                        state.getField().getBoard()[microBoardX + 1][j + microBoardY].equals(IField.EMPTY_FIELD))
                {
                    return new Move(microBoardX + 1, j + microBoardY);
                }
                
                //checking for winable/blockable squares in the Y lines
                if(state.getField().getBoard()[i + microBoardX][microBoardY].equals(player) &&
                        state.getField().getBoard()[i + microBoardX][microBoardY + 1].equals(player)&&
                        state.getField().getBoard()[i + microBoardX][microBoardY + 2].equals(IField.EMPTY_FIELD))
                {
                    return new Move(i + microBoardX, microBoardY + 2);
                }
                
                if(state.getField().getBoard()[i + microBoardX][microBoardY + 1].equals(player) &&
                        state.getField().getBoard()[i + microBoardX][microBoardY + 2].equals(player)&&
                        state.getField().getBoard()[i + microBoardX][microBoardY].equals(IField.EMPTY_FIELD))
                {
                    return new Move(i + microBoardX, microBoardY);
                }
                
                if(state.getField().getBoard()[i + microBoardX][microBoardY].equals(player) &&
                        state.getField().getBoard()[i + microBoardX][microBoardY + 2].equals(player)&&
                        state.getField().getBoard()[i + microBoardX][microBoardY + 1].equals(IField.EMPTY_FIELD))
                {
                    return new Move(i + microBoardX, microBoardY + 1);
                }
                
                //checking for winable/blockable squares in the diagonal lines
                if(state.getField().getBoard()[microBoardX + 2][microBoardY].equals(player) &&
                        state.getField().getBoard()[microBoardX][microBoardY + 2].equals(player)&&
                        state.getField().getBoard()[microBoardX + 1][microBoardY + 1].equals(IField.EMPTY_FIELD))
                {
                    return new Move(microBoardX + 1,microBoardY + 1);
                }
                
                if(state.getField().getBoard()[microBoardX][microBoardY].equals(player) &&
                        state.getField().getBoard()[microBoardX + 2][microBoardY + 2].equals(player)&&
                        state.getField().getBoard()[microBoardX + 1][j + microBoardY + 1].equals(IField.EMPTY_FIELD))
                {
                    return new Move(microBoardX + 1, microBoardY + 1);
                }
            }
        }
        return null;
    }
    
    private int getMacroBoardX(IGameState state)
    {
        int macroX = 0;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if(state.getField().getMacroboard()[i][j].equals(IField.AVAILABLE_FIELD))
                {
                    macroX = i;
                }  
            }
        }
        return macroX;
    }
    
    private int getMacroBoardY(IGameState state)
    {
        int macroY = 0;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if(state.getField().getMacroboard()[i][j].equals(IField.AVAILABLE_FIELD))
                {
                    macroY = j;
                }  
            }
        }
        return macroY;
    }

    @Override
    public String getBotName()
    {
        return BOTNAME;
    }
}
