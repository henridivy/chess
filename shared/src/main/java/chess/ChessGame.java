package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * A class that can manage a chess game, making moves on a board
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessGame {

    ChessBoard board = new ChessBoard();
    TeamColor teamTurn;

    public ChessGame() {
        board.resetBoard();
        teamTurn = TeamColor.WHITE;
    }

    /**
     * @return Which team's turn it is
     */
    public TeamColor getTeamTurn() {
        return teamTurn;
    }

    /**
     * Sets which teams turn it is
     *
     * @param team the team whose turn it is
     */
    public void setTeamTurn(TeamColor team) { teamTurn = team; }

    /**
     * Enum identifying the 2 possible teams in a chess game
     */
    public enum TeamColor {
        WHITE,
        BLACK
    }

    /**
     * Gets all valid moves for a piece at the given location
     *
     * @param startPosition the piece to get valid moves for
     * @return Set of valid moves for requested piece, or null if no piece at
     * startPosition
     */
    public Collection<ChessMove> validMoves(ChessPosition startPosition) {
        ChessPiece piece = board.getPiece(startPosition);
        if (piece == null) { return null; }
        Collection<ChessMove> pieceMoves = piece.pieceMoves(board, startPosition);

        // actually legal moves; moves that will not result in the king being in check
        Collection<ChessMove> validMoves = new ArrayList<>();

        // simulate every move, checking if the king is in check
        ChessBoard testBoard = board.clone();
        testBoard.addPiece(new ChessPosition(3, 5), new ChessPiece(TeamColor.BLACK, ChessPiece.PieceType.BISHOP));

        return validMoves;
    }

    /**
     * Makes a move in the chess game
     *
     * @param move chess move to perform
     * @throws InvalidMoveException if move is invalid
     */
    public void makeMove(ChessMove move) throws InvalidMoveException {

        ChessPosition start = move.getStartPosition();
        ChessPosition end = move.getEndPosition();
        // get the piece at the move's starting position
        ChessPiece piece = board.getPiece(start);


            // check if it's the piece's team's turn
            if (piece.getTeamColor() == teamTurn) {
                Collection<ChessMove> validMoves = validMoves(move.getStartPosition());

                // check if move is valid
                if (validMoves.contains(move)) {
                    makeMoveHelper(move);
                }


            } else {
                throw new InvalidMoveException("Invalid move: Wrong team's turn");
            }
//        } catch (CloneNotSupportedException e) {
//        throw new CloneNotSupportedException("Clone can't be created.");

    }

    private void makeMoveHelper(ChessMove move) {
        ChessPosition start = move.getStartPosition();
        ChessPosition end = move.getEndPosition();

        // get the piece at the move's starting position
        ChessPiece piece = board.getPiece(start);

        // add the piece to the board at the ending position
        board.addPiece(end, piece);

        // set the starting position to null
        board.addPiece(start, null);

        // set the next team's turn
        changeTeamTurn();
    }

    /**
     * Determines if the given team is in check
     *
     * @param teamColor which team to check for check
     * @return True if the specified team is in check
     */
    public boolean isInCheck(TeamColor teamColor) {
        throw new RuntimeException("Not implemented");
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
     * Sets this game's chessboard to a given board
     *
     * @param board the new board to use
     */
    public void setBoard(ChessBoard board) { this.board = board; }

    /**
     * Gets the current chessboard
     *
     * @return the chessboard
     */
    public ChessBoard getBoard() {
        return board;
    }

    private void changeTeamTurn() {
        if (teamTurn == TeamColor.WHITE) { setTeamTurn(TeamColor.BLACK); }
        else { setTeamTurn(TeamColor.WHITE); }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessGame chessGame = (ChessGame) o;
        return Objects.equals(board, chessGame.board) && teamTurn == chessGame.teamTurn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(board, teamTurn);
    }

    @Override
    public String toString() {
        return "ChessGame: \n" +
                "\nteamTurn = " + teamTurn +
                "\nboard =\n" + board.toString();
    }
}
