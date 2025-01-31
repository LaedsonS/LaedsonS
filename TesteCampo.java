//import java.util.Scanner;
public class TesteCampo 
{   public static void main(String ags[])
    {   /*
        //#region Objetos
        Campo campo = new Campo();
        Minas mina = new Minas();
        Scanner scanner = new Scanner(System.in);
        TUICampo tuiCampo= new TUICampo();
        //#endregion
        */
        GUICampo guiCampo = new GUICampo();
        guiCampo.CriarJanela();
        /*
        //#region Variáveis
        boolean jogoContinua = true;
        int posicaoColuna,posicaoLinha;
        String VERMELHO = "\u001B[31m", LIMPAR = "\u001B[0m", VERDE = "\u001B[32m";
        //#endregion

        tuiCampo.desenharCampo(campo.getTabuleiro());
        do
        {   //#region Por posições
            System.out.println("Escolar a posição da linha");
            posicaoLinha = scanner.nextInt();
            System.out.println("Escolar a posição da coluna");
            posicaoColuna = scanner.nextInt();
            //#endregion
            if(posicaoLinha > 0 && posicaoLinha < 11 && posicaoColuna > 0 && posicaoColuna < 11)
            {   campo.RevelarPosicaoCampo(posicaoLinha,posicaoColuna);
                tuiCampo.desenharCampo(campo.getTabuleiroInicial());
                if(campo.RevelarPosicaoCampo(posicaoLinha,posicaoColuna) == mina.getMina())
                    jogoContinua = false;
            }else
                System.out.println(VERDE + "Valor da posição não existe." + LIMPAR);
        }while(jogoContinua);
        scanner.close();
        System.out.println(VERMELHO+ "Mina encontrada!\nVocê perdeu" + LIMPAR);
        */        
    }    
}
