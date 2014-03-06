RESUMO
Este trabalho tem o objetivo de desenvolver um sistema de controle projetado para
atender, de forma prática, um crescente mercado de consumo voltado a tendência
do uso de dispositivos móveis, por causa da sua praticidade e facilidade de uso.
Como atividade prática será desenvolvido um aplicativo móvel baseado na
plataforma Android. Com essa aplicação pode-se acessar de modo simples o
Arduino, que através do Android será possível controlar dispositivos eletroeletrônicos
como portões, luzes e a temperatura ambiente e fazer a interação do
usuário com a sua residência.

Para a atividade prática será criado um protótipo mecânico representando a
residência com sua entrada e instalações elétricas e desenvolvido um aplicativo de
ativação por smartphones.
• Criação de um aplicativo Android para uso do celular ou smartphone, e
uso de um emulador para os testes.
• Criação de scripts em PHP para a conexão do Arduino com o servidor
Web é comunicação do servidor com o dispositivo Android.
• Criação dos layouts em XML para Android.
• Criação de um servidor de banco de dados e um servidor PHP para ser
usado como uma ponte entre a aplicação Android e o protótipo.
• Para criação do firmware do micro controlador será utilizado o ambiente
de desenvolvimento para Arduino (Arduino 1.0.3).

Para o desenvolvimento desta aplicação foi necessário o aprendizado tanto de uma
linguagem de programação como a do Arduino e o desenvolvimento do hardware.
Para a conclusão foi adquirido novos conhecimentos em todas as etapas. Como o
desenvolvimento Java, que para ser desenvolvido para Android é um pouco
diferente da convencional, na criação do firmware, e na integração do software
com o hardware. Quanto a questão de conexão com um banco de dados, o
desenvolvimento PHP com MYSQL e servidores web, segurança dos dados entre
outras. Tudo isso resultou em uma aplicação que também é uma pequena visão
para um lado que não envolve a informática que é a interação das pessoas com
suas tarefas diárias. Todo este conhecimento necessário permitiu a realização de
um trabalho bastante satisfatório tanto no ponto de vista técnico quanto
motivacional.


MANUAL DE OPERAÇÃO E IMPLANTAÇÃO
Para a implantação deste sistema será necessário o uso de quatro componentes
principais são eles;
• Um desktop que será usado como servidor web é de dados;
• Um celular ou smartphones com sistema Android;
• Uma placa Arduino Uno ou similar.
• Uma placa de relês para controlar os dispositivos externos.
A figura 13 ilustra o funcionamento de todo o sistema.
Figura 13: Topologia do Funcionamento do Sistema de Automação
Aparelho celular ou smartphones
O aparelho deve suportar o sistema Android, e a instalação do aplicativo será feita via
Bluetooth usando o servidor para esta tarefa.
24
Servidor Web
Para a o servidor será usado o Xampp, pois ele é um pacote para ser usado como servidor
Web contendo o Apache, Mysql é o PHP.
Para a configuração do PHP no Windows XP será necessária a alteração do arquivo
php.ini-dist :
Copie o arquivo php.ini-dist, que se encontra na pasta c:\php, para a pasta do
Windows (geralmente c:\Windows). Troque seu nome por php.ini e em seguida
abra-o. Localize o seguinte texto dentro deste arquivo: "extension_dir" e altere o
valor desta entrada para o nome da pasta com os arquivos das extensões do PHP,
que no nosso caso é "c:\php\extensions". Salve e feche este arquivo, copie
também o arquivo php4ts.dll, que se encontra na pasta c:\php, para a
pasta c:\Windows\System, no caso de Windows95/98/ME/XP, ou para a
pasta c:\WINNT\System32, no caso de Windows NT/2000.
Arduino Uno
Para o uso do Arduino não tem muita coisa a fazer a única coisa a ser feita é a
instalação dos drivers corretos que vem juntos como o compilador. O compilador
pode ser baixado pelo link que está em referências úteis. Para a instalação plugue
o Arduino na porta USB, ele ira pedir para instalar os drivers corretos. Assim que
abrir a janela para localizar os arquivos a direcione-a para o endereço em que está
a pasta dos drivers para continuar a instalação. Após a instalação dos drivers, o
Arduino estará pronto para o uso, lembrando que quando o Arduino estiver sendo
usado com o cabo USB ele não deve ser alimentado por uma fonte externa. A
figura 14 mostra o Arduino e suas portas de entrada e saída, entrada de sensores,
outras partes de sua estrutura.
Figura 14: Vista superior do Arduino.
25
Sensores
Para este trabalho foi utilizado um sensor de temperatura, mais para outras
atividades pode se usar outros tipos de sensores com de nível, ultra-som, chaves
entre outros. O sensor utilizado neste projeto foi o LM35 que é um sensor de
temperatura analógico, o LM35 é um sensor de precisão, fabricado pela National
Semiconductor, que apresenta uma saída de tensão linear proporcional à
temperatura que se encontra ao seu redor, no nosso caso esta tensão varia de 0V a
5V, o sensor é alimentado com 5V. A figura 15 mostra o sensor LM35 juntamente
com seus terminais.
Figura 15: LM35 e seus terminais.
A ligação do sensor no Arduino é mostrada na figura 16, a alimentação é feita
também pelo Arduino. Onde o fio vermelho é a alimentação de 5V, o fio verde é o
terra e o fio amarelo é onde a tensão varia de 0V a 5V, sendo ligada na entrada
analógica do Arduino.
Figura 16: Esquema de ligação do sensor na Arduino.
Placa de Relê
Esta placa é responsável por ligar e desligar os dispositivos que nela estão ligadas,
para produzir a placa é necessário certo conhecimento de eletrônica ou conhecer
alguém que possa fazê-la. Como ela funciona? Quando os valores dos pinos do
Arduino estiverem em 0 à placa de relê ficará desligada, assim que o estado da
26
porta for alterado para 1, o relê correspondente a porta que foi alterada irá fechar
seus contatos ligando a carga que estiver ligada no terminal. A figura 17 mostra a
ligação do Arduino na placa de relê.
Figura 17: Esquema de ligação da placa de relê no Arduino.
Dependendo do layout da placa de relê a ligação muda nos pontos de placa, mais a
ligação no Arduino continua a mesma. Após esta etapa é só ligar as cargas nos
relê para poder utilizar.

