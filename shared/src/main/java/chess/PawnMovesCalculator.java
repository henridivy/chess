package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PawnMovesCalculator extends PieceMovesCalculator {

    ChessGame.TeamColor pawnColor;

    public PawnMovesCalculator(ChessBoard board, ChessPosition startingPosition, ChessGame.TeamColor pawnColor) {
        super(board, startingPosition);
        this.pawnColor = pawnColor;
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition startingPosition) {
        List<ChessMove> validMoves = new ArrayList<>();

        int r = startingPosition.getRow();
        int c = startingPosition.getColumn();

        // white pawns start on row 2, and are moving up (+1 or 2)
        if (pawnColor == ChessGame.TeamColor.WHITE) {
            if (r == 2) {
                validMoves.add(new ChessMove(startingPosition, new ChessPosition(r + 2, c), null));
            }
            validMoves.add(new ChessMove(startingPosition, new ChessPosition(r + 1, c), null));
        }

        // black pawns start on row 7, and are moving down (-1 or 2)
        if (pawnColor == ChessGame.TeamColor.BLACK) {
            if (r == 7) {
                validMoves.add(new ChessMove(startingPosition, new ChessPosition(r - 2, c), null));
            }
            validMoves.add(new ChessMove(startingPosition, new ChessPosition(r - 1, c), null));
        }

        return validMoves;
    }
}
