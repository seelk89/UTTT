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

/**
 *
 * @author Jesper
 */
public class BottyMcBotFace implements IBot
{

    private static final String BOTNAME = "BottyMcBotFace";
    // Moves {row, col} in order of preferences. {0, 0} at top-left corner
    private int[][] preferredMovesFirstSet =
    {
        {0, 0}, {2, 2}, {1, 1},
        {0, 2}, {2, 0}, {0, 1}, 
        {2, 1}, {1, 0}, {1, 2}
    };
    
    private int[][] preferredMovesSecondSet =
    {
        {0, 0}, {2, 2}, {1, 1},
        {0, 2}, {2, 0}, {0, 1}, 
        {2, 1}, {1, 0}, {1, 2}
    };

    @Override
    public IMove doMove(IGameState state)
    {

        //Find macroboard to play in
        for (int[] move : preferredMovesFirstSet)
        {
            if (state.getField().getMacroboard()[move[0]][move[1]].equals(IField.AVAILABLE_FIELD))
            {
                int[][] set = preferredMovesFirstSet;
                
                //System.out.println(state.getMoveNumber());
                //System.out.println(state.getRoundNumber());
                //System.out.println(state.getField().getAvailableMoves());
                
                if(state.getField().getMacroboard()[1][0].equals(IField.AVAILABLE_FIELD))
                {
                    set = preferredMovesSecondSet;
                    System.out.println("Second set");
                }
                
                //find move to play
                for (int[] selectedMove : set)
                {
                    int x = move[0] * 3 + selectedMove[0];
                    int y = move[1] * 3 + selectedMove[1];
                    if (state.getField().getBoard()[x][y].equals(IField.EMPTY_FIELD))
                    {
                        return new Move(x, y);
                    }
                }
            }
        } 
        //NOTE: Something failed, just take the first available move I guess!
        return state.getField().getAvailableMoves().get(0);
    }

    @Override
    public String getBotName()
    {
        return BOTNAME;
    }
}
