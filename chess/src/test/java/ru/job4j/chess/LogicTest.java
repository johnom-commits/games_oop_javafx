package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
    // Проверяем движение слона по диагонали
    @Test
    public void checkMoveBishopRight() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        boolean result = logic.move(Cell.C8, Cell.D7);
        assertThat(result, is(true));
    }
    // Проверяем движение слона отличное от диагонали.
    @Test
    public void checkMoveBishopNotRight() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        boolean result = logic.move(Cell.C8, Cell.D6);
        assertThat(result, is(false));
    }
    // Проверяем движение слона, поставив в конечной точке пешку.
    @Test
    public void checkLogicMoveForPawn() {
        PawnBlack pawnBlack = new PawnBlack(Cell.D7);
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Logic logic = new Logic();
        logic.add(pawnBlack);
        logic.add(bishopBlack);
        boolean result = logic.move(Cell.C8, Cell.D7);
        assertThat(result, is(false));
    }
}
