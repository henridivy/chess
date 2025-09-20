package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QueenMovesCalculator extends PieceMovesCalculator {

    ChessGame.TeamColor pawnColor;

    public QueenMovesCalculator(ChessBoard board, ChessPosition startingPosition) {
        super(board, startingPosition);
    }


    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition startingPosition) {
        List<ChessMove> validMoves = new ArrayList<>();

        BishopMovesCalculator bish_calc = new BishopMovesCalculator(board, startingPosition);
        BishopMovesCalculator rook_calc = new BishopMovesCalculator(board, startingPosition);

//        validMoves = bish_calc.pieceMoves(board, startingPosition);

        return validMoves;
    }
}
