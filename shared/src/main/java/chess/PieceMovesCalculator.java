package chess;

import java.util.Collection;
import java.util.List;

public class PieceMovesCalculator {

    private final ChessBoard board;
    private final ChessPosition startingPosition;
    boolean pawnInitial;

    public PieceMovesCalculator(ChessBoard board, ChessPosition startingPosition) {
        this.board = board;
        this.startingPosition = startingPosition;
        this.pawnInitial = true;
    }
    
//    public PieceMovesCalculator(ChessBoard board, ChessPosition startingPosition, boolean pawnInitial) {
//        this.board = board;
//        this.startingPosition = startingPosition;
//        this.pawnInitial = pawnInitial;
//    }
//
//    public PieceMovesCalculator(ChessBoard board, ChessPosition startingPosition) {
//        this(board, startingPosition, true);
//    }

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
        }
        // return an empty list
        return List.of();
    }


}
