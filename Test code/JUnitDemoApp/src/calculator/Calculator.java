package calculator;

class Calculator {

      /** returns sum of two integer values
     * @param i positive integer between 1 and 100
     * @param j positive integer between 1 and 100
     */
     int sum(int i, int j) throws SumException {
        if (i < 1 || j < 1 || i > 100 || j > 100)
           throw new SumException();
        
       return i + j;
    }
    
}