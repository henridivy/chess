package chess;

import java.util.Collection;
import java.util.List;

public class MovesCalculator {

    private final ChessBoard board;
    private final ChessPosition startingPosition;
    boolean pawnInitial;
    protected ChessPiece piece;

    public MovesCalculator(ChessBoard board, ChessPosition startingPosition) {
        this.board = board;
        this.startingPosition = startingPosition;
        this.piece = board.getPiece(startingPosition);      // get the piece that's at the given position on the given board
        this.pawnInitial = true;
    }

    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {

        // create an appropriate moves calculator depending on the piece type
        if (piece.getPieceType() == ChessPiece.PieceType.BISHOP) {
            BishopMoves calculator = new BishopMoves(board, myPosition);
            return calculator.pieceMoves(board, myPosition);
        } else if (piece.getPieceType() == ChessPiece.PieceType.KING) {
            KingMoves calculator = new KingMoves(board, myPosition);
            return calculator.pieceMoves(board, myPosition);
        } else if (piece.getPieceType() == ChessPiece.PieceType.KNIGHT) {
            KnightMoves calculator = new KnightMoves(board, myPosition);
            return calculator.pieceMoves(board, myPosition);
        } else if (piece.getPieceType() == ChessPiece.PieceType.PAWN) {
            ChessGame.TeamColor pawnColor = piece.getTeamColor();
            PawnMoves calculator = new PawnMoves(board, myPosition, pawnColor);
            return calculator.pieceMoves(board, myPosition);
        } else if (piece.getPieceType() == ChessPiece.PieceType.ROOK) {
            RookMoves calculator = new RookMoves(board, myPosition);
            return calculator.pieceMoves(board, myPosition);
        } else if (piece.getPieceType() == ChessPiece.PieceType.QUEEN) {
            QueenMoves calculator = new QueenMoves(board, myPosition);
            return calculator.pieceMoves(board, myPosition);
        }
        // return an empty list
        return List.of();
    }


}
