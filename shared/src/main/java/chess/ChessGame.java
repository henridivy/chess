package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * For a class that can manage a chess game, making moves on a board
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessGame {

    private TeamColor teamTurn;
    private ChessBoard board;

    public ChessGame() {
        this.teamTurn = TeamColor.WHITE;
        board = new ChessBoard();
        board.resetBoard();
    }

    /**
     * @return Which team's turn it is
     */
    public TeamColor getTeamTurn() {
        return teamTurn;
    }

    /**
     * Set's which teams turn it is
     *
     * @param team the team whose turn it is
     */
    public void setTeamTurn(TeamColor team) {
        teamTurn = team;
    }

    /**
     * Enum identifying the 2 possible teams in a chess game
     */
    public enum TeamColor {
        WHITE,
        BLACK
    }

    /**
     * Gets a valid moves for a piece at the given location
     *
     * @param startPosition the piece to get valid moves for
     * @return Set of valid moves for requested piece, or null if no piece at
     * startPosition
     */
    public Collection<ChessMove> validMoves(ChessPosition startPosition) {
        ChessBoard testBoard = board;

        Collection<ChessMove> validMoves = new ArrayList<>();
        ChessPiece piece = board.getPiece(startPosition);

//        piece.pieceMoves();

//        return validMoves;
        return piece.pieceMoves(board, startPosition);
    }


    /**
     * Makes a move in a chess game
     *
     * @param move chess move to perform
     * @throws InvalidMoveException if move is invalid
     */
    public void makeMove(ChessMove move) throws InvalidMoveException {
//        if (getTeamTurn() == TeamColor.WHITE) {
//            setTeamTurn(TeamColor.BLACK);
//        } else { setTeamTurn(TeamColor.WHITE); }

        ChessPosition startPosition = move.getStartPosition();
        ChessPosition endPosition = move.getEndPosition();

        ChessPiece piece = board.getPiece(startPosition);
        if (piece == null) { throw new InvalidMoveException("No piece in starting position."); }

        ChessBoard backupBoard = board;

        board.removePiece(startPosition);
        board.addPiece(endPosition, piece);

//        if (isInCheck(piece.getTeamColor())) {
//            board = backupBoard;
//            throw new InvalidMoveException("King in check!");
//        }

        System.out.println("Before isInCheck:");
        System.out.println(board);
        boolean check = isInCheck(piece.getTeamColor());
        System.out.println("After isInCheck:");
        System.out.println(board);

    }

    /**
     * Determines if the given team is in check
     *
     * @param teamColor which team to check for check
     * @return True if the specified team is in check
     */
    public boolean isInCheck(TeamColor teamColor) {
        TeamColor opposingColor;

        if (teamColor == TeamColor.WHITE) {
            opposingColor = TeamColor.BLACK;
        } else {
            opposingColor = TeamColor.WHITE;
        }

        // find king
        ChessPosition kingPosition = getKingPosition(board, teamColor);

        // get all opponent's attack positions
        Collection<ChessMove> attackPositions = getAttackPositions(board, opposingColor);

        // see if king's square is being attacked
        for (ChessMove move : attackPositions) {
            ChessPosition endPosition = move.getEndPosition();
            if (kingPosition.equals(endPosition)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Determines if the given team is in checkmate
     *
     * @param teamColor which team to check for checkmate
     * @return True if the specified team is in checkmate
     */
    public boolean isInCheckmate(TeamColor teamColor) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Determines if the given team is in stalemate, which here is defined as having
     * no valid moves while not in check.
     *
     * @param teamColor which team to check for stalemate
     * @return True if the specified team is in stalemate, otherwise false
     */
    public boolean isInStalemate(TeamColor teamColor) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Sets this game's chessboard with a given board
     *
     * @param board the new board to use
     */
    public void setBoard(ChessBoard board) {
        this.board = board;
    }

    /**
     * Gets the current chessboard
     *
     * @return the chessboard
     */
    public ChessBoard getBoard() {
        return board;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    // MY ADDED METHODS

    ChessPosition getKingPosition(ChessBoard board, TeamColor teamColor) {
        ChessPosition currentPosition;
        ChessPiece currentPiece;

        // loop through each square on the board, check if the piece on the square is the team's king
        for (int r = 1; r < 9; r++) {
            for (int c = 1; c < 9; c++) {
                currentPosition = new ChessPosition(r, c);
                currentPiece = board.getPiece(currentPosition);
                if (currentPiece != null) {
                    if (currentPiece.getTeamColor() == teamColor) {
                        if (currentPiece.getPieceType() == ChessPiece.PieceType.KING) {
                            return currentPosition;
                        }
                    }
                }
            }
        }

        return null;
    }

    Collection<ChessMove> getAttackPositions(ChessBoard board, TeamColor color) {
        ChessPosition currentPosition;
        ChessPiece currentPiece;
        List<ChessMove> attackPositions = new ArrayList<>();

        // loop through each square on the board,
        for (int r = 1; r < 9; r++) {
            for (int c = 1; c < 9; c++) {
                currentPosition = new ChessPosition(r, c);
                currentPiece = board.getPiece(currentPosition);
                // if there's a piece there, and it's of the color we want, get all its valid moves
                if (currentPiece != null) {
                    if (currentPiece.getTeamColor() == color) {
                        attackPositions.addAll(currentPiece.pieceMoves(board, currentPosition));
                    }
                }
            }
        }

        return attackPositions;
    }
}
