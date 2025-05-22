package structure.implementation;

import exception.EmptyStructureException;
import exception.FullStructureException;
import exception.InvalidIndexException;
import structure.definition.SetADT;
import structure.definition.SimpleDictionaryADT;

public class StaticSimpleDictionaryADT implements SimpleDictionaryADT {

    private static final int MAX = 10000;
    private final int[][] matrix;
    private int count;

    public StaticSimpleDictionaryADT() {
        this.matrix = new int[MAX][2];
        this.count = 0;
    }

    @Override
    public void add(int key, int value) {
        // Buscar si la clave ya existe
        for (int i = 0; i < count; i++) {
            if (matrix[i][0] == key) {
                // Pisar el valor si existe
                matrix[i][1] = value;
                return;
            }
        }

        if (count >= MAX) {
            throw new FullStructureException("Diccionario lleno");
        }

        matrix[count][0] = key;
        matrix[count][1] = value;
        count++;
    }

    @Override
    public void remove(int key) {
        for (int i = 0; i < count; i++) {
            if (matrix[i][0] == key) {
                // Reemplazo por el último elemento
                matrix[i][0] = matrix[count - 1][0];
                matrix[i][1] = matrix[count - 1][1];
                count--;
                return;
            }
        }
        // Si no existe, no hace nada
    }

    @Override
    public int get(int key) {
        if (isEmpty()) {
            throw new EmptyStructureException("No se puede obtener un valor de una estructura vacía");
        }
        for (int i = 0; i < count; i++) {
            if (matrix[i][0] == key) {
                return matrix[i][1];
            }
        }
        throw new InvalidIndexException("La clave no existe");
    }

    @Override
    public SetADT getKeys() {
        SetADT result = new StaticSetADT(); // Asegurate de que StaticSet implemente SetADT
        for (int i = 0; i < count; i++) {
            result.add(matrix[i][0]);
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}
