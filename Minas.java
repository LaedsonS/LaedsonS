import java.util.Random;

public class Minas 
{   private static char mina = '=';
    private static int linha, coluna,  numeroDeMinas = 25;
    private static Random random = new Random();

    public static void geradorPosicao()
    {   linha = random.nextInt(Campo.getLinhas());
        coluna = random.nextInt(Campo.getColunas());
    }
    
    public static void setNumeroDeMinas(int numeroDeMinas) {
        Minas.numeroDeMinas = numeroDeMinas;
    }

    public static int getLinha()
    {   return linha;
    }
    public static int getColuna()
    {   return coluna;
    }
    public static char getMina()
    {   return mina;
    }
    public static int getNumeroDeMinas()
    {   return numeroDeMinas;
    }
}