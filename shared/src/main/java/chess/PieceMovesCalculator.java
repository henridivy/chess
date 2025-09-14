package chess;

import java.util.Collection;
import java.util.List;

public class PieceMovesCalculator {

    private final ChessBoard board;
    private final ChessPosition startingPosition;

    public PieceMovesCalculator(ChessBoard board, ChessPosition startingPosition) {
        this.board = board;
        this.startingPosition = startingPosition;
    }

    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        // get the piece that's at the given position on the given board
        ChessPiece piece = board.getPiece(myPosition);

        // if the piece is a Bishop...
        if (piece.getPieceType() == ChessPiece.PieceType.BISHOP) {
            BishopMovesCalculator calculator = new BishopMovesCalculator(board, myPosition);
            return calculator.pieceMoves(board, myPosition);
        } else if (piece.getPieceType() == ChessPiece.PieceType.KING) {
            KingMovesCalculator calculator = new KingMovesCalculator(board, myPosition);
            return calculator.pieceMoves(board, myPosition);
        }
        // return an empty list
        return List.of();
    }


}
