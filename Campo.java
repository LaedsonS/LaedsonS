public class Campo 
{   private static int linhas = 10, colunas = 10, tamanhoDoCampo = linhas * colunas;
    private char tabuleiro [][] = new char[linhas][colunas], tabuleiroInicial [][] = new char[linhas][colunas], simboloTabuleiroInicial = '-', caracteresCampo[] = new char [tamanhoDoCampo];
 
    public Campo(int lin, int col)
    {   
        for(int l = 0; l < linhas; l++)
        {   for(int c = 0; c < colunas; c++)
            {   tabuleiro[l][c] = simboloTabuleiroInicial;
                tabuleiroInicial[l][c] = simboloTabuleiroInicial;
            }
        }
        porMinas();
        porNumeros();
        PorCaracteresCampo();
    }

    private void porNumeros()
    {   for(int l = 0; l < linhas; l++)
        {   for(int c = 0; c < colunas; c++)
            {   int numeroDeMinas = 0;
                // Verifica se a coluna anterior na mesma linha é mina
                if((c != 0) && (tabuleiro[l][c-1] == Minas.getMina()))
                    numeroDeMinas++;
                // Verifica se a linha anterior na mesma coluna é mina
                if((l != 0) && (tabuleiro[l-1][c] == Minas.getMina()))
                    numeroDeMinas++;
                // Verifica se a coluna posterior na mesma linha é mina
                if((c != colunas-1) && (tabuleiro[l][c+1] == Minas.getMina()))
                    numeroDeMinas++;
                // Verifica se a linha posterior na mesma coluna é mina
                if((l != linhas-1) && (tabuleiro[l+1][c] == Minas.getMina()))
                    numeroDeMinas++;
                // Verifica se a linha posterior na coluna anterior é mina
                if(((l != linhas-1) && (c != 0)) && (tabuleiro[l+1][c-1] == Minas.getMina()))
                    numeroDeMinas++;
                // Verifica se a linha anterior na coluna anterior é mina
                if(((l != 0) && (c != 0)) && (tabuleiro[l-1][c-1] == Minas.getMina()))
                    numeroDeMinas++;
                // Verifica se a linha posterior na coluna posterior é mina
                if(((l != linhas-1) && (c != colunas-1)) && (tabuleiro[l+1][c+1] == Minas.getMina()))
                    numeroDeMinas++;
                // Verifica se a linha anterior na coluna posterior é mina
                if(((l != 0) && (c != colunas-1)) && (tabuleiro[l-1][c+1] == Minas.getMina()))
                    numeroDeMinas++;
                    
                if(tabuleiro[l][c] != Minas.getMina())
                    tabuleiro[l][c] = (char) ('0' + numeroDeMinas);
            }
        }
    }

    private void porMinas()
    {   if(Minas.getNumeroDeMinas() != 0)
        {   for(int l = 0; l < Minas.getNumeroDeMinas() + 1; l++)
            {   Minas.geradorPosicao();
                if(tabuleiro[Minas.getLinha()][Minas.getColuna()] == simboloTabuleiroInicial)
                    tabuleiro[Minas.getLinha()][Minas.getColuna()] = Minas.getMina();
            }
        }
    }
    
    /*public void imprimirCampo()
    {   for(int l = 0; l < tabuleiro.length; l++)
        {   for(int c = 0; c < tabuleiro.length; c++)
            {   System.out.print(tabuleiroInicial[l][c]);
            }
            System.out.println();
        }
    } */

    /*public char RevelarPosicaoCampo(int posicaoL, int posicaoC)
    {   posicaoL -= 1;
        posicaoC -= 1;
        tabuleiroInicial[posicaoL][posicaoC] = tabuleiro[posicaoL][posicaoC];
        return tabuleiroInicial[posicaoL][posicaoC];
    }*/

    private void PorCaracteresCampo()
    {   int p = 0;
        for(int l = 0; l < linhas; l++)
        {   for(int c = 0; c < colunas; c++, p++)
            {   caracteresCampo[p] = tabuleiro[l][c];
            }
        }
    }

    public char[][] getTabuleiro()
    {   return tabuleiro;
    }
    public char[][] getTabuleiroInicial()
    {   return tabuleiroInicial;
    }
    public char getCaracteresCampo(int indice)
    {   return caracteresCampo[indice];
    }
    public int getTamanhoDoCampo() {
        return tamanhoDoCampo;
    }
    public static int getLinhas() {
        return linhas;
    }
    public static int getColunas() {
        return colunas;
    }
    
    public static void setLinhas(int linhas) {
        Campo.linhas = linhas;
    }
    public static void setColunas(int colunas) {
        Campo.colunas = colunas;
    }

}