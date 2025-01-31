import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUICampo 
{    
    private JFrame jFrame = new JFrame("Campo minado");
    
    public void CriarJanela()
    {   jFrame();      

        //#region CardLayout e Painel de fundo
        CardLayout cardLayout  = new CardLayout();
        JPanel painelDeFundo = new JPanel(cardLayout);
        jFrame.add(painelDeFundo);
        //#endregion
        //#region Tela inicial
        JLabel textoCampo = new JLabel("Campo Minado", SwingConstants.CENTER);
        textoCampo.setFont(new Font("", Font.ROMAN_BASELINE, 30));
        
        JPanel painelConfiguraçoes = new JPanel(new GridLayout(8,0));
        painelConfiguraçoes.setBackground(new Color(100, 200, 110));
        painelDeFundo.add(painelConfiguraçoes,"Card0");
        
        //#region Texto e Rótulo de Quantidade De Minas, Linhs e Colunas
        JLabel textoQuantidadeDeMinas = new JLabel("Quantida de minas");
        JTextField areaDeTextoQuantidadeDeMinas = new JTextField("25",8);
      
        JLabel textoQuantidadeDeLinhas = new JLabel("Quantida de linhas");
        JTextField areaDeTextoQuantidadeDeLinhas = new JTextField("10",8);
     
        JLabel textoQuantidadeDeColunas = new JLabel("Quantida de colunas");
        JTextField areaDeTextoQuantidadeDeColunas = new JTextField("8",8);
        //#endregion
        Campo campoMinado = new Campo(Integer.parseInt(areaDeTextoQuantidadeDeLinhas.getText()),Integer.parseInt(areaDeTextoQuantidadeDeColunas.getText()));
        Minas.setNumeroDeMinas(Integer.parseInt(areaDeTextoQuantidadeDeMinas.getText()));
        JButton botaoIrTabuleiro = new JButton("Ir para o tabuleiro");
        botaoIrTabuleiro.addActionListener(new ActionListener() 
        {   @Override
            public void actionPerformed(ActionEvent e)
            {   cardLayout.show(painelDeFundo, "Card1");
            }
        });
        
        painelConfiguraçoes.add(textoCampo, 0);
        painelConfiguraçoes.add(botaoIrTabuleiro, 1);
        painelConfiguraçoes.add(textoQuantidadeDeMinas, 2);
        painelConfiguraçoes.add(areaDeTextoQuantidadeDeMinas, 3);
        painelConfiguraçoes.add(textoQuantidadeDeLinhas, 4);
        painelConfiguraçoes.add(areaDeTextoQuantidadeDeLinhas, 5);
        painelConfiguraçoes.add(textoQuantidadeDeColunas, 6);
        painelConfiguraçoes.add(areaDeTextoQuantidadeDeColunas, 7);
        //#endregion
        //#region Painel tabuleiro
        JPanel panelTabuleiro = new JPanel();
        panelTabuleiro.setBackground(Color.CYAN);
        panelTabuleiro.setLayout(new GridLayout(Campo.getLinhas(),Campo.getColunas()));
        painelDeFundo.add(panelTabuleiro,"Card1");
        //#endregion
        //#region Painel derrota
        JPanel jPanelDerrota = new JPanel();
        jPanelDerrota.setLayout(new GridLayout(3,1));
        jPanelDerrota.setBackground(Color.RED);
        painelDeFundo.add(jPanelDerrota,"Card2");
        //#endregion
        //#region Painel vitoria
        JPanel jPanelVitoria = new JPanel();
        jPanelVitoria.setLayout(new GridLayout(4,1));;
        jPanelVitoria.setBackground(new Color(0,150,150));
        painelDeFundo.add(jPanelVitoria, "Card3");
        //#endregion
        
        //#region JLabel1, JLabel2(no jPanelDerrota), JLabel3, JLabel4 e JLabel5(jPanelVitoria)
        JLabel jLabelDerrota = new JLabel("Mina encontrada", SwingConstants.CENTER);
        jLabelDerrota.setFont(new Font("", Font.ROMAN_BASELINE, 30));
        jPanelDerrota.add(jLabelDerrota,0);
        
        ImageIcon imageIconExplosao = new ImageIcon("C:/Users/laeds/ProjetosDeJava/Projeto/src/Calculadora/src/CampoMinado/Explosão.jpg");
        JLabel jLabelImagemExplosao = new JLabel(imageIconExplosao);
        jPanelDerrota.add(jLabelImagemExplosao,1);
        
        JLabel jLabelVitoria = new JLabel("Vitória", SwingConstants.CENTER);
        jLabelVitoria.setFont(new Font("", Font.ROMAN_BASELINE, 60));
        jPanelVitoria.add(jLabelVitoria,0);

        JLabel jLabelParabenização = new JLabel("O campo foi concluido", SwingConstants.CENTER);
        jLabelParabenização.setFont(new Font("", Font.ROMAN_BASELINE, 60));
        jPanelVitoria.add(jLabelParabenização, 1);

        JLabel jLabelCarinha = new JLabel(":)", SwingConstants.CENTER);
        jLabelCarinha.setFont(new Font("",Font.ROMAN_BASELINE, 120));
        jPanelVitoria.add(jLabelCarinha, 2);
        //#endregion
        
        //#region Botão jagar novemente
        JButton botaoJagarNovementeDerrota = new JButton("JOGA NOVAMENTE");
        jPanelDerrota.add(botaoJagarNovementeDerrota,2);
        botaoJagarNovementeDerrota.addActionListener(new ActionListener() 
        {   @Override
            public void actionPerformed(ActionEvent e)
            {   cardLayout.show(painelDeFundo, "Card1");
            }
        });

        JButton botaoJagarNovementeVitoria = new JButton("JOGA NOVAMENTE");
        jPanelVitoria.add(botaoJagarNovementeVitoria,3);
        botaoJagarNovementeVitoria.addActionListener(new ActionListener() 
        {   @Override
            public void actionPerformed(ActionEvent e)
            {   cardLayout.show(painelDeFundo, "Card1");
            }
        });
        //#endregion

        //#region Por os butões e suas ações
        int botoesClicados[]= {0}; 
        for(int l = 0; l < campoMinado.getTamanhoDoCampo(); l++)
        {   //#region Configuração do Butão Misterio
            final int indice = l;
            JButton butaoMisterio = new JButton();
            Color customColor = new Color(50, 175, 0); 
            butaoMisterio.setBackground(customColor);
            butaoMisterio.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            //#endregion
            butaoMisterio.addActionListener(new ActionListener()
            {   @Override
                public void actionPerformed(ActionEvent e)
                {   //#region Configurações do BotãoMisterio
                    JButton botaoClicado1 = (JButton) e.getSource(); //O método getSource() identifica qual componente gerou um evento em uma interface gráfica.
                    panelTabuleiro.remove(botaoClicado1);
                    
                    JPanel jPanelBotao = new JPanel();
                    jPanelBotao.setLayout(new  GridLayout(0,2));
                    panelTabuleiro.add(jPanelBotao,indice);
                    //#endregion
                    
                    //#region Botão "cavar" o campo
                    ImageIcon imageIconTocar = new ImageIcon("C:/Users/laeds/ProjetosDeJava/Projeto/src/Calculadora/src/CampoMinado/Tocar.png");
                    imageIconTocar.setImage(imageIconTocar.getImage().getScaledInstance(25, 25, Image.SCALE_FAST)); // getScaledInstance(novaLargura, novaAltura, Image.SCALE_SMOOTH);
                
                    JButton jButtonCavar = new JButton(imageIconTocar);
                    jButtonCavar.setBackground(new Color(255,50,0));
                    jButtonCavar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    jButtonCavar.addActionListener(new ActionListener() 
                    {   @Override
                        public void actionPerformed(ActionEvent e)
                        {   botoesClicados[0] += 1;
                            
                            JButton botaoClicado2 = (JButton) e.getSource(); 
                            panelTabuleiro.remove(botaoClicado2);
                            panelTabuleiro.remove(jPanelBotao);

                            //#region Botão "cavar" ao redor(Não terminado)
                            String caracter = campoMinado.getCaracteresCampo(indice) + "";
                           
                            JButton jButtonAoRedor = new JButton(caracter);
                            jButtonAoRedor.setBackground(new Color(150,0,155));
                            jButtonAoRedor.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            panelTabuleiro.add(jButtonAoRedor,indice);
                            //#endregion
                            
                            panelTabuleiro.revalidate(); //recalcular o layout de um container, como um JPanel. Ao chamar revalidate(), o layout manager do painel é notificado para reposicionar os componentes de acordo com as novas dimensões e configurações. Usa-se o revalidate() quando é necessário modificar a estrutura do layout (adicionando ou removendo componentes).
                            panelTabuleiro.repaint(); // informa ao Swing que uma área da tela precisa ser atualizada porque está "suja" ou desatualizada. Usa-se o repaint() quando é necessário atualizar a aparência visual de componentes que já estão no layout.

                            if(campoMinado.getCaracteresCampo(indice) == Minas.getMina())
                                cardLayout.show(painelDeFundo, "Card2");
                            if(botoesClicados[0] == (campoMinado.getTamanhoDoCampo() - Minas.getNumeroDeMinas()))
                                cardLayout.show(painelDeFundo, "Card3");
                         
                        }
                    });
                    jPanelBotao.add(jButtonCavar,0);
                    //#endregion
                
                    //#region Botão por a bandeira
                    ImageIcon imageIconBandeira = new ImageIcon("C:/Users/laeds/ProjetosDeJava/Projeto/src/Calculadora/src/CampoMinado/Bandeira.png");
                    imageIconBandeira.setImage(imageIconBandeira.getImage().getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING));

                    JButton jButtonPorBandeira = new JButton(imageIconBandeira);
                    jButtonPorBandeira.setBackground(new Color(0,150,255));
                    jButtonPorBandeira.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                    jButtonPorBandeira.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e)
                       {    JButton botaoClicado3 = (JButton) e.getSource(); 
                            panelTabuleiro.remove(botaoClicado3);
                            panelTabuleiro.remove(jPanelBotao);
                            
                            //#region Botão tirar bandeira
                            JButton jButtonTirarBandeira = new JButton(imageIconBandeira);
                            jButtonTirarBandeira.setBackground(new Color(90,50,100));
                            jButtonTirarBandeira.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            jButtonTirarBandeira.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e)
                                {   panelTabuleiro.remove(jButtonTirarBandeira);

                                    panelTabuleiro.add(butaoMisterio,indice);

                                    panelTabuleiro.revalidate();
                                    panelTabuleiro.repaint();
                                }
                            });
                            //#endregion
                            panelTabuleiro.add(jButtonTirarBandeira,indice);

                            panelTabuleiro.revalidate();
                            panelTabuleiro.repaint();
                       }
                    });
                    jPanelBotao.add(jButtonPorBandeira,1);
                    //#endregion

                    jPanelBotao.revalidate();
                    jPanelBotao.repaint();
                }
            });
            
            panelTabuleiro.add(butaoMisterio,l);
        }
        //#endregion
        
        jFrame.pack(); // Ajusta o tamanho da janela automaticamente para encaixar todos os seus componentes de maneira adequada.
    }
    private void jFrame()
    {   jFrame.setPreferredSize(new Dimension(650,450));
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}