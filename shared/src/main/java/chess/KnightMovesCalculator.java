package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KnightMovesCalculator extends PieceMovesCalculator {

    public KnightMovesCalculator(ChessBoard board, ChessPosition startingPosition) {
        super(board, startingPosition);
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition startingPosition) {
        List<ChessMove> validMoves = new ArrayList<>();

        int r = startingPosition.getRow();
        int c = startingPosition.getColumn();

        // up
        if ((r+2 <= 8) && (c-1 >= 1)) { validMoves.add(new ChessMove(startingPosition, new ChessPosition(r+2, c-1), null)); }
        if ((r+2 <= 8) && (c+1 <= 8)) { validMoves.add(new ChessMove(startingPosition, new ChessPosition(r+2, c+1), null)); }

        // left
        if ((r+1 <= 8) && (c-2 >= 1)) { validMoves.add(new ChessMove(startingPosition, new ChessPosition(r+1, c-2), null)); }
        if ((r-1 >= 1) && (c-2 >= 1)) { validMoves.add(new ChessMove(startingPosition, new ChessPosition(r-1, c-2), null)); }

        // down
        if ((r-2 >= 1) && (c-1 >= 1)) { validMoves.add(new ChessMove(startingPosition, new ChessPosition(r-2, c-1), null)); }
        if ((r-2 >= 1) && (c+1 <= 8)) { validMoves.add(new ChessMove(startingPosition, new ChessPosition(r-2, c+1), null)); }

        // right
        if ((r+1 <= 8) && (c+2 <= 8)) { validMoves.add(new ChessMove(startingPosition, new ChessPosition(r+1, c+2), null)); }
        if ((r-1 >= 1) && (c+2 <= 8)) { validMoves.add(new ChessMove(startingPosition, new ChessPosition(r-1, c+2), null)); }



        /*
        [5,5] [i,j]
        7,4  7,6  up
        6,3  4,3  left
        3,4  3,6  down
        6,7  4,7  right
         */

        return validMoves;
    }
}
