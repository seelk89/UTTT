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
 * @author Anni
 */
public class BottyMcBotFace implements IBot
{
    private static final String BOTNAME = "GoatMeth";
    // Moves {row, col} in order of preferences. {0, 0} at top-left corner
    private int[][] preferredMovesASet =
    {
        {0, 0}, {2, 0}, {1, 0},
    };
    
    private int[][] preferredMovesBSet =
    {
        {1, 0}, {2, 0}, {0, 0},    
    };
    
    private int[][] preferredMovesCSet =
    {
        {2, 0}, {2, 2}, {2, 1}, 
    };
        
    private int[][] preferredMovesDSet =
    {
        {0, 1}, {0, 2}, {0, 0}, 
    };
         
            
    private int[][] preferredMovesESet =
    {
        {1, 1},
        {2, 2}, {0, 0}, 
        {2, 0}, {0, 2},       
    };
         
    private int[][] preferredMovesFSet =
    {
        {2, 1}, {2, 0}, {2, 2},   
    };
    

    private int[][] preferredMovesGSet =
    {
        {0, 2}, {0, 0}, {0, 1},          
    };                  
    
    private int[][] preferredMovesHSet =
    {
        {1, 2}, {2, 2}, {0, 2}, 
    };
          
    private int[][] preferredMovesISet =
    {
        {2, 2}, {0, 2}, {1, 2}, 
    };    
   
    
    @Override
    public IMove doMove(IGameState state)
    {

        //Find macroboard to play in
//        for (int[] move : preferredMovesASet)
//        {
//            if (state.getField().getMacroboard()[move[0]][move[1]].equals(IField.AVAILABLE_FIELD))
//            {
                int[][] set = preferredMovesASet;

                 if(state.getField().getMacroboard()[0][0].equals(IField.AVAILABLE_FIELD))
                {
                     IMove winningMove = checkWin(state);
                if(winningMove != null)
                {
                    return winningMove;
                }    

                    set = preferredMovesASet;
                    System.out.println("FirstA set");
                    
                 //checking for blockable wins
                IMove blockingMove = checkBlock(state);
                if(blockingMove != null)
                {
                    return blockingMove;
                }    
                    
                 for (int[] selectedMove : set)
                {
                    int x = 0 * 3 + selectedMove[0];
                    int y = 0 * 3 + selectedMove[1];
                    if (state.getField().getBoard()[x][y].equals(IField.EMPTY_FIELD))
                    {
                        return new Move(x, y);
                    }

                }
                }
                
                if(state.getField().getMacroboard()[1][0].equals(IField.AVAILABLE_FIELD))
                {
                     IMove winningMove = checkWin(state);
                if(winningMove != null)
                {
                    return winningMove;
                }    
                
                
                
                    set = preferredMovesBSet;
                    System.out.println("SecondB set");
                    
                //checking for blockable wins
                IMove blockingMove = checkBlock(state);
                if(blockingMove != null)
                {
                    return blockingMove;
                }    
                                     for (int[] selectedMove : set)
                {
                    int x = 1 * 3 + selectedMove[0];
                    int y = 0 * 3 + selectedMove[1];
                    if (state.getField().getBoard()[x][y].equals(IField.EMPTY_FIELD))
                    {
                        return new Move(x, y);
                    }

                 }
                }
                 
                if(state.getField().getMacroboard()[2][0].equals(IField.AVAILABLE_FIELD))
                {
                    IMove winningMove = checkWin(state);
                if(winningMove != null)
                {
                    return winningMove;
                }    
                
                
                    set = preferredMovesCSet;
                    System.out.println("ThirdC set");
                    
                    //checking for blockable wins
                IMove blockingMove = checkBlock(state);
                if(blockingMove != null)
                {
                    return blockingMove;
                }
                
                for (int[] selectedMove : set)
                {
                    int x = 2 * 3 + selectedMove[0];
                    int y = 0 * 3 + selectedMove[1];
                    if (state.getField().getBoard()[x][y].equals(IField.EMPTY_FIELD))
                    {
                        return new Move(x, y);
                    }

                   }
                }
                   
                if(state.getField().getMacroboard()[0][1].equals(IField.AVAILABLE_FIELD))
                { 
                    IMove winningMove = checkWin(state);
                if(winningMove != null)
                {
                    return winningMove;
                }    
                
                
                    set = preferredMovesDSet;
                    System.out.println("FourthD set");
                    
                //checking for blockable wins
                IMove blockingMove = checkBlock(state);
                if(blockingMove != null)
                {
                    return blockingMove;
                }    
                
                    for (int[] selectedMove : set)
                {
                    int x = 0 * 3 + selectedMove[0];
                    int y = 1 * 3 + selectedMove[1];
                    if (state.getField().getBoard()[x][y].equals(IField.EMPTY_FIELD))
                    {
                        return new Move(x, y);
                    }

                  }
                }  
                if(state.getField().getMacroboard()[1][1].equals(IField.AVAILABLE_FIELD))
                {
                     IMove winningMove = checkWin(state);
                if(winningMove != null)
                {
                    return winningMove;
                }    
                
                
                    set = preferredMovesESet;
                    System.out.println("FifthE set");
                    
                //checking for blockable wins
                IMove blockingMove = checkBlock(state);
                if(blockingMove != null)
                {
                    return blockingMove;
                }    
                                     for (int[] selectedMove : set)
                {
                    int x = 1 * 3 + selectedMove[0];
                    int y = 1 * 3 + selectedMove[1];
                    if (state.getField().getBoard()[x][y].equals(IField.EMPTY_FIELD))
                    {
                        return new Move(x, y);
                    }

                 }
                }
                  
                if(state.getField().getMacroboard()[2][1].equals(IField.AVAILABLE_FIELD))
                {
                     
                IMove winningMove = checkWin(state);
                if(winningMove != null)
                {
                    return winningMove;
                }    
                
                
                    set = preferredMovesFSet;
                    System.out.println("SixthF set");
                //checking for blockable wins
                IMove blockingMove = checkBlock(state);
                if(blockingMove != null)
                {
                    return blockingMove;
                }                    
                
                for (int[] selectedMove : set)
                {
                    int x = 2 * 3 + selectedMove[0];
                    int y = 1 * 3 + selectedMove[1];
                    if (state.getField().getBoard()[x][y].equals(IField.EMPTY_FIELD))
                    {
                        return new Move(x, y);
                    }

               }
                }
                   
                if(state.getField().getMacroboard()[0][2].equals(IField.AVAILABLE_FIELD))
                {
                     IMove winningMove = checkWin(state);
                if(winningMove != null)
                {
                    return winningMove;
                }    
                
               
                    set = preferredMovesGSet;
                    System.out.println("SeventhG set");
                 //checking for blockable wins
                IMove blockingMove = checkBlock(state);
                if(blockingMove != null)
                {
                    return blockingMove;
                }   
                    for (int[] selectedMove : set)
                {
                    int x = 0 * 3 + selectedMove[0];
                    int y = 2 * 3 + selectedMove[1];
                    if (state.getField().getBoard()[x][y].equals(IField.EMPTY_FIELD))
                    {
                        return new Move(x, y);
                    }

                  }
                }
                     
                if(state.getField().getMacroboard()[1][2].equals(IField.AVAILABLE_FIELD))
                {
                     IMove winningMove = checkWin(state);
                if(winningMove != null)
                {
                    return winningMove;
                }    
                
               
                    set = preferredMovesHSet;
                    System.out.println("EightH set");
                   //checking for blockable wins
                IMove blockingMove = checkBlock(state);
                if(blockingMove != null)
                {
                    return blockingMove;
                }      
                for (int[] selectedMove : set)
                {
                    int x = 1 * 3 + selectedMove[0];
                    int y = 2 * 3 + selectedMove[1];
                    if (state.getField().getBoard()[x][y].equals(IField.EMPTY_FIELD))
                    {
                        return new Move(x, y);
                    }

                }
                }
                       
                if(state.getField().getMacroboard()[2][2].equals(IField.AVAILABLE_FIELD))
                {
                     IMove winningMove = checkWin(state);
                if(winningMove != null)
                {
                    return winningMove;
                }    
                
                
                    set = preferredMovesISet;
                    System.out.println("NinthI set");
                    
                    //checking for blockable wins
                IMove blockingMove = checkBlock(state);
                if(blockingMove != null)
                {
                    return blockingMove;
                }
                 
                for (int[] selectedMove : set)
                {
                    int x = 2 * 3 + selectedMove[0];
                    int y = 2 * 3 + selectedMove[1];
                    if (state.getField().getBoard()[x][y].equals(IField.EMPTY_FIELD))
                    {
                        return new Move(x, y);
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
                        
        return state.getField().getAvailableMoves().get(0);
    }
    
    
    private IMove checkWin(IGameState state)
    {
        String player = "" + (state.getMoveNumber() % 2);
        int microBoardX = getMacroBoardX(state) * 3;
        int microBoardY = getMacroBoardY(state) * 3;
        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                //checking for winable squares in the X lines
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
                
                //checking for winable squares in the Y lines
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
                
                //checking for winable squares in the diagonal lines
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
    
    private IMove checkBlock(IGameState state)
    {
        String opponent = "" + ((state.getMoveNumber() + 1) % 2);
        int microBoardX = getMacroBoardX(state) * 3;
        int microBoardY = getMacroBoardY(state) * 3;
        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                //checking for blockable squares in the X lines
                if(state.getField().getBoard()[microBoardX][j + microBoardY].equals(opponent) &&
                        state.getField().getBoard()[microBoardX + 1][j + microBoardY].equals(opponent) &&
                        state.getField().getBoard()[microBoardX + 2][j + microBoardY].equals(IField.EMPTY_FIELD))
                {
                    return new Move(microBoardX + 2, j + microBoardY);
                }
                
                if(state.getField().getBoard()[microBoardX + 1][j + microBoardY].equals(opponent) &&
                        state.getField().getBoard()[microBoardX + 2][j + microBoardY].equals(opponent)&&
                        state.getField().getBoard()[microBoardX][j + microBoardY].equals(IField.EMPTY_FIELD))
                {
                    return new Move(microBoardX, j + microBoardY);
                }
                
                if(state.getField().getBoard()[microBoardX][j + microBoardY].equals(opponent) &&
                        state.getField().getBoard()[microBoardX + 2][j + microBoardY].equals(opponent)&&
                        state.getField().getBoard()[microBoardX + 1][j + microBoardY].equals(IField.EMPTY_FIELD))
                {
                    return new Move(microBoardX + 1, j + microBoardY);
                }
                
                //checking for blockable squares in the Y lines
                if(state.getField().getBoard()[i + microBoardX][microBoardY].equals(opponent) &&
                        state.getField().getBoard()[i + microBoardX][microBoardY + 1].equals(opponent)&&
                        state.getField().getBoard()[i + microBoardX][microBoardY + 2].equals(IField.EMPTY_FIELD))
                {
                    return new Move(i + microBoardX, microBoardY + 2);
                }
                
                if(state.getField().getBoard()[i + microBoardX][microBoardY + 1].equals(opponent) &&
                        state.getField().getBoard()[i + microBoardX][microBoardY + 2].equals(opponent)&&
                        state.getField().getBoard()[i + microBoardX][microBoardY].equals(IField.EMPTY_FIELD))
                {
                    return new Move(i + microBoardX, microBoardY);
                }
                
                if(state.getField().getBoard()[i + microBoardX][microBoardY].equals(opponent) &&
                        state.getField().getBoard()[i + microBoardX][microBoardY + 2].equals(opponent)&&
                        state.getField().getBoard()[i + microBoardX][microBoardY + 1].equals(IField.EMPTY_FIELD))
                {
                    return new Move(i + microBoardX, microBoardY + 1);
                }
                
                //checking for blockable squares in the diagonal lines
                if(state.getField().getBoard()[microBoardX + 2][microBoardY].equals(opponent) &&
                        state.getField().getBoard()[microBoardX][microBoardY + 2].equals(opponent)&&
                        state.getField().getBoard()[microBoardX + 1][microBoardY + 1].equals(IField.EMPTY_FIELD))
                {
                    return new Move(microBoardX + 1,microBoardY + 1);
                }
                
                if(state.getField().getBoard()[microBoardX][microBoardY].equals(opponent) &&
                        state.getField().getBoard()[microBoardX + 2][microBoardY + 2].equals(opponent)&&
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
