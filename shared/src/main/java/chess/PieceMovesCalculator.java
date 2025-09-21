package chess;

import java.util.Collection;
import java.util.List;

public class PieceMovesCalculator {

    private final ChessBoard board;
    private final ChessPosition startingPosition;
    boolean pawnInitial;
    protected ChessPiece piece;

    public PieceMovesCalculator(ChessBoard board, ChessPosition startingPosition) {
        this.board = board;
        this.startingPosition = startingPosition;
        this.piece = board.getPiece(startingPosition);      // get the piece that's at the given position on the given board
        this.pawnInitial = true;
    }

    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {

        // create an appropriate moves calculator depending on the piece type
        if (piece.getPieceType() == ChessPiece.PieceType.BISHOP) {
            BishopMovesCalculator calculator = new BishopMovesCalculator(board, myPosition);
            return calculator.pieceMoves(board, myPosition);
        } else if (piece.getPieceType() == ChessPiece.PieceType.KING) {
            KingMovesCalculator calculator = new KingMovesCalculator(board, myPosition);
            return calculator.pieceMoves(board, myPosition);
        } else if (piece.getPieceType() == ChessPiece.PieceType.KNIGHT) {
            KnightMovesCalculator calculator = new KnightMovesCalculator(board, myPosition);
            return calculator.pieceMoves(board, myPosition);
        } else if (piece.getPieceType() == ChessPiece.PieceType.PAWN) {
            ChessGame.TeamColor pawnColor = piece.getTeamColor();
            PawnMovesCalculator calculator = new PawnMovesCalculator(board, myPosition, pawnColor);
            return calculator.pieceMoves(board, myPosition);
        } else if (piece.getPieceType() == ChessPiece.PieceType.ROOK) {
            RookMovesCalculator calculator = new RookMovesCalculator(board, myPosition);
            return calculator.pieceMoves(board, myPosition);
        } else if (piece.getPieceType() == ChessPiece.PieceType.QUEEN) {
            QueenMovesCalculator calculator = new QueenMovesCalculator(board, myPosition);
            return calculator.pieceMoves(board, myPosition);
        }
        // return an empty list
        return List.of();
    }


}
