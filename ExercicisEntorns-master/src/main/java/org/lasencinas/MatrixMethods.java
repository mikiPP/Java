package org.lasencinas;

public class MatrixMethods {



    public static Integer[][] transpose(Integer [][] matrix){

        Integer[][] transposed = new Integer[matrix.length][matrix[0].length];

        int i = 0;

        while (i < matrix.length){
            int j = 0;
            while (j < matrix[0].length){
                transposed[j][i] = matrix[i][j];
                j++;
            }
            i++;
        }
        return transposed;
    }


    public static Integer[][] matrixMultipiler(Integer [][] matrixA,Integer[][] matrixB){

        Integer[][] matrixC = {{0,0,0},{0,0,0},{0,0,0}};

        int i = 0;
        while (i < matrixA.length){
            int j=0;

            while (j < matrixB[0].length){

                int k = 0;
                while (k < matrixB.length){
                    matrixC[i][j] += matrixA[i][k] * matrixB[k][j];
                    k++;
                }
                j++;
            }
            i++;
        }

        return matrixC;
    }
}
