package edu.kit.informatik.matchthree.tests;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;

import edu.kit.informatik.matchthree.MatchThreeBoard;
import edu.kit.informatik.matchthree.MoveFactoryImplementation;
import edu.kit.informatik.matchthree.framework.Position;
import edu.kit.informatik.matchthree.framework.Token;
import edu.kit.informatik.matchthree.framework.exceptions.BoardDimensionException;
import edu.kit.informatik.matchthree.framework.interfaces.Board;
import edu.kit.informatik.matchthree.framework.interfaces.Move;

/**
 * Tests for rotate square rotation move
 * 
 * @author Micha Hanselmann
 */
public class MoveRotateSquareClockwiseMoveTest {
    
    @Test
    public void apply() {
        
        Board board = new MatchThreeBoard(Token.set("*AXY="), "*AX;Y**;X*=");
        Move rotateCW = new MoveFactoryImplementation().rotateSquareClockwise(Position.at(1, 0));
        assertTrue(rotateCW.canBeApplied(board));
        rotateCW.apply(board);
        assertEquals("**A;Y*X;X*=", board.toTokenString());
    }
    
    @Test
    public void reverse1() {
        
        Board board = new MatchThreeBoard(Token.set("*AXY="), "*AX;Y**;X*=");
        Move rotateCCW = new MoveFactoryImplementation().rotateSquareClockwise(Position.at(1, 0)).reverse();
        assertTrue(rotateCCW.canBeApplied(board));
        rotateCCW.apply(board);
        assertEquals("*X*;YA*;X*=", board.toTokenString());
    }
    
    @Test
    public void reverse2() {
        
        Board board = new MatchThreeBoard(Token.set("*AXY="), "*AX;Y**;X*=");
        Move rotateCCW = new MoveFactoryImplementation().rotateSquareClockwise(Position.at(0, 1)).reverse();
        assertTrue(rotateCCW.canBeApplied(board));
        rotateCCW.apply(board);
        assertEquals("*AX;***;YX=", board.toTokenString());
    }

}
