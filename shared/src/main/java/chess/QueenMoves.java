package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QueenMoves extends MovesCalculator {


    public QueenMoves(ChessBoard board, ChessPosition startingPosition) { super(board, startingPosition); }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition startingPosition) {
        List<ChessMove> validMoves = new ArrayList<>();

        BishopMoves bish_calc = new BishopMoves(board, startingPosition);
        RookMoves rook_calc = new RookMoves(board, startingPosition);

        validMoves.addAll(bish_calc.pieceMoves(board, startingPosition));
        validMoves.addAll(rook_calc.pieceMoves(board, startingPosition));

        return validMoves;
    }
}
