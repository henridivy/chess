package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BishopMovesCalculator extends PieceMovesCalculator {

    public BishopMovesCalculator(ChessBoard board, ChessPosition startingPosition) {
        super(board, startingPosition);
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition startingPosition) {
        List<ChessMove> validMoves = new ArrayList<>();
        ChessPosition endingPosition = startingPosition;

        // for up right
        int j = startingPosition.getColumn();
        for (int i = startingPosition.getRow(); i < 8 && j < 8; i++) {
            endingPosition = new ChessPosition(i+1, j+1);
            ChessMove newMove = new ChessMove(startingPosition, endingPosition, null);
            validMoves.add(newMove);
            j++;
        }

        // for up left
        j = startingPosition.getColumn();
        for (int i = startingPosition.getRow(); i < 8 && j > 1; i++) {
            endingPosition = new ChessPosition(i+1, j-1);
            ChessMove newMove = new ChessMove(startingPosition, endingPosition, null);
            validMoves.add(newMove);
            j--;
        }

        // for down right
        j = startingPosition.getColumn();
        for (int i = startingPosition.getRow(); i > 1 && j < 8; i--) {
            endingPosition = new ChessPosition(i-1, j+1);
            ChessMove newMove = new ChessMove(startingPosition, endingPosition, null);
            validMoves.add(newMove);
            j++;
        }

        // for down left
        j = startingPosition.getColumn();
        for (int i = startingPosition.getRow(); i > 1 && j > 1; i--) {
            endingPosition = new ChessPosition(i-1, j-1);
            ChessMove newMove = new ChessMove(startingPosition, endingPosition, null);
            validMoves.add(newMove);
            j--;
        }

            /* 5,4 (i, j)
            up right - 6,5  7,6  8,7
            up left - 6,3  7,2  8,1
            down right - 4,5  3,6  2,7  1,8
            down left - 4,3  3,2  2,1
             */

        return validMoves;
//        return super.pieceMoves(board, myPosition);
    }
}
