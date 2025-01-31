public class TUICampo 
{   private String AZUL = "\u001B[35m";
    private final String LIMPAR = "\u001B[0m";
    public void desenharCampo(char[][] campo)
    {   System.out.println(AZUL + "   1 2 3 4 5 6 7 8 9 10" + "\n" +
                                      "                    " + "\n" +
                                     "1 |" + campo[0][0] + " " + campo[0][1] + " " + campo[0][2] + " " + campo[0][3] + " " + campo[0][4] + " " + campo[0][5] + " " + campo[0][6] + " " + campo[0][7] + " " + campo[0][8] + " " + campo[0][9] + "\n" +
                                     "2 |" + campo[1][0] + " " + campo[1][1] + " " + campo[1][2] + " " + campo[1][3] + " " + campo[1][4] + " " + campo[1][5] + " " + campo[1][6] + " " + campo[1][7] + " " + campo[1][8] + " " + campo[1][9] + "\n" +
                                     "3 |" + campo[2][0] + " " + campo[2][1] + " " + campo[2][2] + " " + campo[2][3] + " " + campo[2][4] + " " + campo[2][5] + " " + campo[2][6] + " " + campo[2][7] + " " + campo[2][8] + " " + campo[2][9] + "\n" +
                                     "4 |" + campo[3][0] + " " + campo[3][1] + " " + campo[3][2] + " " + campo[3][3] + " " + campo[3][4] + " " + campo[3][5] + " " + campo[3][6] + " " + campo[3][7] + " " + campo[3][8] + " " + campo[3][9] + "\n" +
                                     "5 |" + campo[4][0] + " " + campo[4][1] + " " + campo[4][2] + " " + campo[4][3] + " " + campo[4][4] + " " + campo[4][5] + " " + campo[4][6] + " " + campo[4][7] + " " + campo[4][8] + " " + campo[4][9] + "\n" +
                                     "6 |" + campo[5][0] + " " + campo[5][1] + " " + campo[5][2] + " " + campo[5][3] + " " + campo[5][4] + " " + campo[5][5] + " " + campo[5][6] + " " + campo[5][7] + " " + campo[5][8] + " " + campo[5][9] + "\n" +
                                     "7 |" + campo[6][0] + " " + campo[6][1] + " " + campo[6][2] + " " + campo[6][3] + " " + campo[6][4] + " " + campo[6][5] + " " + campo[6][6] + " " + campo[6][7] + " " + campo[6][8] + " " + campo[6][9] + "\n" +
                                     "8 |" + campo[7][0] + " " + campo[7][1] + " " + campo[7][2] + " " + campo[7][3] + " " + campo[7][4] + " " + campo[7][5] + " " + campo[7][6] + " " + campo[7][7] + " " + campo[7][8] + " " + campo[7][9] + "\n" +
                                     "9 |" + campo[8][0] + " " + campo[8][1] + " " + campo[8][2] + " " + campo[8][3] + " " + campo[8][4] + " " + campo[8][5] + " " + campo[8][6] + " " + campo[8][7] + " " + campo[8][8] + " " + campo[8][9] + "\n" +
                                     "10|" + campo[9][0] + " " + campo[9][1] + " " + campo[9][2] + " " + campo[9][3] + " " + campo[9][4] + " " + campo[9][5] + " " + campo[9][6] + " " + campo[9][7] + " " + campo[9][8] + " " + campo[9][9] + LIMPAR);
    }

}
