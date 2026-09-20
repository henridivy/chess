package chess;

import java.util.ArrayList;
import java.util.Collection;

public class QueenRule extends PieceRule {

    public QueenRule(ChessBoard board, ChessGame.TeamColor color, ChessPosition starting) {
        super(board, color, starting);
        this.type = ChessPiece.PieceType.QUEEN;
    }

    @Override
    public Collection<ChessMove> getValidMoves() {

        Collection<ChessMove> validMoves = new ArrayList<>();

        BishopRule bishopMoves = new BishopRule(board, color, starting);
        RookRule rookMoves = new RookRule(board, color, starting);

        validMoves.addAll(bishopMoves.getValidMoves());
        validMoves.addAll(rookMoves.getValidMoves());

        return validMoves;
    }
}
